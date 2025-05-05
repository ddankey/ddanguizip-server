package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.accident.entity.AccidentSagoNo;
import com.ddanguizip.server.domain.accident.repository.AccidentSagoNoRepository;
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
    private final AccidentSagoNoRepository accidentSagoNoRepository;
    private final UndergroundAccidentApiClient undergroundAccidentApiClient;
    private final UnderGroundAccidentMapper underGroundAccidentMapper;

    @Value("${openapi.accident.serviceKey}")
    private String serviceKey;

    @Transactional
    public void process(int pageNo,String sagoDateFrom,String sagoDateTo) {
        //지반침하사고이력 데이터 요청
        Map<String, Object> response = undergroundAccidentApiClient.inquireAccident(
                serviceKey,
                pageNo,
                "json",
                sagoDateFrom,
                sagoDateTo
        );
        //필요한 데이터 맵핑
        List<String> sagoNoList = underGroundAccidentMapper.toAccidentResponse(response);

        for(String sagoNo: sagoNoList) {
            AccidentSagoNo accidentSagoNo =AccidentSagoNo.builder()
                    .sagoNo(sagoNo)
                    .build();

            accidentSagoNoRepository.save(accidentSagoNo);
        }
    }
}
