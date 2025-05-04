package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.factory.LocationFactory;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.publicData.dto.request.PointData;
import com.ddanguizip.server.domain.publicData.dto.response.HasudoResponse;
import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import com.ddanguizip.server.domain.publicData.factory.SewerageStatsFactory;
import com.ddanguizip.server.domain.publicData.repository.SewerageStatsRepository;
import com.ddanguizip.server.domain.publicData.util.SewerageStatsApiClient;
import com.ddanguizip.server.domain.publicData.util.SewerageStatsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SewerageStatsApiService {
    private final LocationFactory locationFactory;
    private final SewerageStatsFactory sewerageStatsFactory;

    private final LocationRepository locationRepository;
    private final SewerageStatsRepository sewerageStatsRepository;

    private final SewerageStatsApiClient sewerageStatsApiClient;
    private final SewerageStatsMapper sewerageStatsMapper;

    @Transactional
    public void process(List<PointData> pointDataList) {
        for (PointData point : pointDataList) {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("wktPoint", point.wktPoint());

            //하수도 노후관로 데이터 요청
            Map<String, Object> reponse = sewerageStatsApiClient.inquireHasudo(requestBody);
            //필요한 데이터 맵핑
            HasudoResponse hasudoResponse = sewerageStatsMapper.toHasudoResponse(reponse);

            Location location = locationFactory.create(hasudoResponse.gu(), point.EMD_KOR_NM(), String.valueOf(point.EMD_CD()));
            locationRepository.save(location);

            SewerageStats sewerageStats = sewerageStatsFactory.create(location, hasudoResponse.oldExtnPer(), hasudoResponse.oldExtnPerYr());
            sewerageStatsRepository.save(sewerageStats);
        }
    }
}
