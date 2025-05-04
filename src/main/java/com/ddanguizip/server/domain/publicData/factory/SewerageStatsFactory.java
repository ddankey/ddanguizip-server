package com.ddanguizip.server.domain.publicData.factory;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import org.springframework.stereotype.Component;

@Component
public class SewerageStatsFactory {
    public SewerageStats create(Location location, Double agingRate, String agingRateYr,  Double dredgingRate,String dredgingRateYr) {
        return SewerageStats.builder()
                .location(location)
                .agingRate(agingRate)
                .agingRateYr(agingRateYr)
                .dredgingRate(dredgingRate)
                .dredgingRateYr(dredgingRateYr)
                .build();
    }
}
