package com.ddanguizip.server.domain.publicData.cvs;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import com.ddanguizip.server.domain.publicData.factory.SelectedRiskAreaFactory;
import com.ddanguizip.server.domain.publicData.repository.SelectedRiskAreaRepository;
import com.ddanguizip.server.domain.publicData.repository.SewerageStatsRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SelectedRiskAreaLoader {
    private final LocationRepository locationRepository;
    private final SelectedRiskAreaRepository selectedRiskAreaRepository;

    private final SelectedRiskAreaFactory selectedRiskAreaFactory;

//    @PostConstruct
    public void loadSelectedRiskAreaData() throws IOException {
        Resource resource = new ClassPathResource("/static/selectedRiskAreaData.csv");
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {

            CSVReader csvReader = new CSVReader(reader);
            List<String[]> lines = csvReader.readAll();

            for (String[] line : lines) {
                Location location = locationRepository.findLocationByDong(line[0]);
                SelectedRiskArea selectedRiskArea = selectedRiskAreaFactory.create(line[1], line[2], location);

                selectedRiskAreaRepository.save(selectedRiskArea);
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
