package com.ddanguizip.server.domain.publicData.factory;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.publicData.entity.GuRiskStats;
import org.springframework.stereotype.Component;

@Component
public class GuRiskStatsFactory {
    public GuRiskStats create(Double riskRatio, Integer riskLevel, GuLocation guLocation) {
        return GuRiskStats.builder()
                .riskRatio(riskRatio)
                .riskLevel(riskLevel)
                .guLocation(guLocation)
                .build();
    }
}
