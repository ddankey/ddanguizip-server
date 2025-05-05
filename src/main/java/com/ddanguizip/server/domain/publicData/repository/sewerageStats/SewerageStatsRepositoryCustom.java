package com.ddanguizip.server.domain.publicData.repository.sewerageStats;

import com.ddanguizip.server.domain.map.dto.reponse.RiskDetail;

import java.util.List;

public interface SewerageStatsRepositoryCustom {
    /**
     * 위험도 계산 데이터
     */
    List<RiskDetail> findRiskDetails();
}
