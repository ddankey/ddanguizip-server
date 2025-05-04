package com.ddanguizip.server.domain.map.service;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.map.dto.reponse.RiskAreaDetail;
import com.ddanguizip.server.domain.map.dto.reponse.RiskAreaListRes;
import com.ddanguizip.server.domain.map.dto.reponse.RiskListRes;
import com.ddanguizip.server.domain.map.validator.MapValidator;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import com.ddanguizip.server.domain.publicData.repository.SelectedRiskAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapService {
    private final LocationRepository locationRepository;
    private final SelectedRiskAreaRepository selectedRiskAreaRepository;

    private final MapValidator mapValidator;

    public RiskAreaListRes findRiskAreaList(String code, Pageable pageable) {
        //code를 통해서 location 찾기
        Location location = locationRepository.findLocationByCode(code);
        mapValidator.validateLoaction(location);

        //location 통해서 데이터 추출
        Page<SelectedRiskArea> riskAreaPage = selectedRiskAreaRepository.searchList(location, pageable);
        List<RiskAreaDetail> list = new ArrayList<>();
        riskAreaPage.getContent().forEach(selectedRiskArea -> list.add(RiskAreaDetail.of(code, selectedRiskArea)));

        return RiskAreaListRes.of(list, riskAreaPage.getNumber(), riskAreaPage.getSize(), riskAreaPage.getTotalPages());
    }

    public RiskListRes findRiskListByDong() {

    }
}
