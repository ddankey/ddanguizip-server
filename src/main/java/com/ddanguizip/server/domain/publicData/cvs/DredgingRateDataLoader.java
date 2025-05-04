package com.ddanguizip.server.domain.publicData.cvs;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.publicData.repository.SewerageStatsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DredgingRateDataLoader {
    private final LocationRepository locationRepository;
    private final SewerageStatsRepository sewerageStatsRepository;

    //    @PostConstruct
    public void loadDredgingRateData() throws IOException {
        Resource resource = new ClassPathResource("/static/dredgingRateData.csv");
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {

            CSVReader csvReader = new CSVReader(reader);
            List<String[]> lines = csvReader.readAll();

            //준설률 기준
            String dredgingRateYr = lines.get(0)[2];

            //0~3은 자치구 데이터가 아니므로 4부터 시작
            for (int i = 4; i < lines.size(); i++) {
                String[] line = lines.get(i);

                List<Location> locationList = locationRepository.findAllByGu(line[1]);

                for(Location location: locationList) {
                    sewerageStatsRepository.findSewerageStatsByLocation(location)
                            .ifPresentOrElse(sewerageStats -> {
                                        sewerageStats.updatedredgingRateAndDredgingRateYr(Double.parseDouble(line[4]), dredgingRateYr);
                                        sewerageStatsRepository.save(sewerageStats);
                                    },
                                    () -> {

                                    }
                            );
                }
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
