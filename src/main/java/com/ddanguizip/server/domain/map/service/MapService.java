package com.ddanguizip.server.domain.map.service;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.map.dto.reponse.RiskAreaDetail;
import com.ddanguizip.server.domain.map.dto.reponse.RiskAreaListRes;
import com.ddanguizip.server.domain.map.dto.reponse.RiskDetail;
import com.ddanguizip.server.domain.map.dto.reponse.RiskListRes;
import com.ddanguizip.server.domain.map.validator.MapValidator;
import com.ddanguizip.server.domain.publicData.entity.GuRiskStats;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import com.ddanguizip.server.domain.publicData.repository.guRiskStats.GuRiskStatsRepository;
import com.ddanguizip.server.domain.publicData.repository.selectedRiskArea.SelectedRiskAreaRepository;
import com.ddanguizip.server.domain.publicData.repository.sewerageStats.SewerageStatsRepository;
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
    private final SewerageStatsRepository sewerageStatsRepository;
    private final GuRiskStatsRepository guRiskStatsRepository;

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
        List<SewerageStats> sewerageStatsList = sewerageStatsRepository.findAll();
        List<RiskDetail> list = new ArrayList<>();
        for(SewerageStats sewerageStats: sewerageStatsList) {
            list.add(RiskDetail.of(sewerageStats.getLocation().getCode(),sewerageStats.getRiskLevel()));
        }

        return RiskListRes.of(list);
    }

    public RiskListRes findRiskListByGu() {
        List<GuRiskStats> guRiskStatsList = guRiskStatsRepository.findAll();
        List<RiskDetail> list = new ArrayList<>();
        for(GuRiskStats guRiskStats: guRiskStatsList) {
            list.add(RiskDetail.of(guRiskStats.getGuLocation().getCode(),guRiskStats.getRiskLevel()));
        }

        return RiskListRes.of(list);
    }
}
