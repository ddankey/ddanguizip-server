package com.ddanguizip.server.domain.publicData.factory;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SelectedRiskAreaFactory {
    public SelectedRiskArea create(String section, String reason, Location location) {
        return SelectedRiskArea.builder()
                .section(section)
                .reason(reason)
                .location(location)
                .build();
    }
}
