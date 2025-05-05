package com.ddanguizip.server.domain.publicData.cvs;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.location.factory.GuLocationFactory;
import com.ddanguizip.server.domain.location.repository.GuLocationRepository;
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

@Component
@RequiredArgsConstructor
public class GuCodeDataLoader {
    private final GuLocationFactory guLocationFactory;
    private final GuLocationRepository guLocationRepository;
//    @PostConstruct
    public void loadDredgingRateData() throws IOException {
        Resource resource = new ClassPathResource("/static/guCodeData.csv");
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {

            CSVReader csvReader = new CSVReader(reader);
            List<String[]> lines = csvReader.readAll();

            for (String[] line : lines) {
                GuLocation guLocation = guLocationFactory.create(line[1], line[0]);
                guLocationRepository.save(guLocation);
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
