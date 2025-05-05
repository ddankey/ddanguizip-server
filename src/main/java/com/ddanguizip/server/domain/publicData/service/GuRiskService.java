package com.ddanguizip.server.domain.publicData.service;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.location.repository.GuLocationRepository;
import com.ddanguizip.server.domain.location.repository.LocationRepository;
import com.ddanguizip.server.domain.publicData.entity.GuRiskStats;
import com.ddanguizip.server.domain.publicData.factory.GuRiskStatsFactory;
import com.ddanguizip.server.domain.publicData.repository.guRiskStats.GuRiskStatsRepository;
import com.ddanguizip.server.domain.publicData.repository.sewerageStats.SewerageStatsRepository;
import com.ddanguizip.server.global.common.policy.RiskScoreEvalutor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuRiskService {
    private final GuLocationRepository guLocationRepository;
    private final LocationRepository locationRepository;
    private final SewerageStatsRepository sewerageStatsRepository;
    private final GuRiskStatsRepository guRiskStatsRepository;
    private final GuRiskStatsFactory guRiskStatsFactory;
    private final RiskScoreEvalutor riskScoreEvalutor;

    @Transactional
    /**
     * 자치구 기준 위험 비율과 위험도 데이터 저장
     */
    public void saveRiskScoreAndRiskLevel() {
        List<GuLocation> guLocationList = guLocationRepository.findAll();

        for(GuLocation guLocation: guLocationList) {
            int levelOverTwoCount = (int) sewerageStatsRepository.countLevelOverTwo(guLocation);
            int totalDong = locationRepository.countLocationByGu(guLocation.getGu());
            double ratio = riskScoreEvalutor.calculatorRatio(levelOverTwoCount, totalDong);
            int level = riskScoreEvalutor.fromRatioByGu(ratio);

            GuRiskStats guRiskStats = guRiskStatsFactory.create(ratio,level,guLocation);
            guRiskStatsRepository.save(guRiskStats);
        }
    }
}
