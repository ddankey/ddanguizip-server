package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.entity.AccidentSagoNo;
import com.ddanguizip.server.domain.accident.factory.AccidentFactory;
import com.ddanguizip.server.domain.accident.repository.AccidentDetailRepository;
import com.ddanguizip.server.domain.accident.repository.AccidentSagoNoRepository;
import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.publicData.dto.response.AccidentDetailRes;
import com.ddanguizip.server.domain.publicData.util.UnderGroundAccidentMapper;
import com.ddanguizip.server.domain.publicData.util.UndergroundAccidentApiClient;
import jakarta.annotation.PostConstruct;
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
    private final LocationRepository locationRepository;
    private final AccidentSagoNoRepository accidentSagoNoRepository;
    private final AccidentDetailRepository accidentDetailRepository;
    private final UndergroundAccidentApiClient undergroundAccidentApiClient;
    private final UnderGroundAccidentMapper underGroundAccidentMapper;
    private final AccidentFactory accidentFactory;

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
            AccidentSagoNo accidentSagoNo = accidentFactory.createAccidentSagoNo(sagoNo);

            accidentSagoNoRepository.save(accidentSagoNo);
        }
    }

    @Transactional
    public void startDetail() {
        List<AccidentSagoNo> accidentSagoNoList = accidentSagoNoRepository.findAll();

        for(AccidentSagoNo accidentSagoNo: accidentSagoNoList) {
            processDetail(accidentSagoNo.getSagoNo(),0);
        }
    }

    @Transactional
    public void processDetail(String sagoNo,int pageNo) {
        //지반침하사고이력 데이터 요청
        Map<String, Object> response = undergroundAccidentApiClient.inquireAccidentDetail(
                serviceKey,
                pageNo,
                10,
                "json",
                sagoNo
        );
        //필요한 데이터 맵핑
        List<AccidentDetailRes> accidentDetailResList = underGroundAccidentMapper.toAccidentDetailResponse(response);

        for(AccidentDetailRes accidentDetailRes: accidentDetailResList) {
            //location 찾기
            Location location = locationRepository.findLocationByDongAndGu(accidentDetailRes.dong(),accidentDetailRes.sigungu());
            if (location == null) {
                // location 못 찾으면 이 항목은 건너뜀 동이 기준에 안맞을 수 있음
                continue;
            }
            //sagoNo 찾기
            AccidentSagoNo accidentSagoNo = accidentSagoNoRepository.findAccidentSagoNoBySagoNo(accidentDetailRes.sagoNo());
            //AccidentDetail 저장
            AccidentDetail accidentDetail = accidentFactory.createAccidentDetail(accidentDetailRes,location,accidentSagoNo);

            accidentDetailRepository.save(accidentDetail);
        }
    }
}
