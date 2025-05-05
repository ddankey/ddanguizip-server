package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import com.ddanguizip.server.domain.publicData.repository.selectedRiskArea.SelectedRiskAreaRepository;
import com.ddanguizip.server.domain.publicData.repository.sewerageStats.SewerageStatsRepository;
import com.ddanguizip.server.global.common.policy.RiskScoreEvalutor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SewerageStatsService {
    private final SewerageStatsRepository sewerageStatsRepository;
    private final SelectedRiskAreaRepository selectedRiskAreaRepository;

    private final RiskScoreEvalutor riskScoreEvalutor;

    @Transactional
    /**
     * 행정동 기준 위험 점수와 위험도 데이터 저장
     */
    public void saveRiskScoreAndRiskLevel() {
        List<SewerageStats> sewerageStatsList = sewerageStatsRepository.findAll();

        for(SewerageStats sewerageStats: sewerageStatsList) {
            //서울시에서 발표한 데이터인지
            boolean isExist = selectedRiskAreaRepository.existsByLocation(sewerageStats.getLocation());
            double score = riskScoreEvalutor.calculatorScore(sewerageStats.getAgingRate(),sewerageStats.getDredgingRate(),isExist);
            int level = riskScoreEvalutor.fromScoreByDong(score);

            sewerageStats.updateRiskScoreAndRiskLevel(score,level);
            sewerageStatsRepository.save(sewerageStats);
        }
    }
}
