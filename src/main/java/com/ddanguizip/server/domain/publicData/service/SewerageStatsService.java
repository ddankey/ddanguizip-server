package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import com.ddanguizip.server.domain.publicData.repository.SewerageStatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SewerageStatsService {
    private final SewerageStatsRepository sewerageStatsRepository;


    /**
     * 행정동 기준 위험 점수와 위험도 데이터 저장
     */
    public void saveRiskScoreAndRiskLevel() {
        List<SewerageStats> sewerageStatsList = sewerageStatsRepository.findAll();
    }
}
