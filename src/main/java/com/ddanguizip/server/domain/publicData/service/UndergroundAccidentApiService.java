package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.publicData.dto.response.AccidentRes;
import com.ddanguizip.server.domain.publicData.util.UnderGroundAccidentMapper;
import com.ddanguizip.server.domain.publicData.util.UndergroundAccidentApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UndergroundAccidentApiService {

    private final UndergroundAccidentApiClient undergroundAccidentApiClient;
    private final UnderGroundAccidentMapper underGroundAccidentMapper;

    @Value("${openapi.accident.serviceKey}")
    private String serviceKey;

    @Transactional
    public void process(int pageNo,String sagoDateFrom,String sagoDateTo) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("serviceKey", serviceKey);
        requestBody.put("pageNo", pageNo);
        requestBody.put("type", "json");
        requestBody.put("sagoDateFrom", sagoDateFrom);
        requestBody.put("sagoDateTo", sagoDateTo);

        //지반침하사고이력 데이터 요청
        Map<String, Object> response = undergroundAccidentApiClient.inquireAccident(requestBody);
        //필요한 데이터 맵핑
        List<String> sageNoList = underGroundAccidentMapper.toAccidentResponse(response);
    }
}
