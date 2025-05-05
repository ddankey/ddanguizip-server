package com.ddanguizip.server.domain.publicData.repository.sewerageStats;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.map.dto.reponse.RiskDetail;

import java.util.List;

public interface SewerageStatsRepositoryCustom {
    /**
     * 위험도 계산 데이터
     */
    List<RiskDetail> findRiskDetails();

    /**
     *
     * @param guLocation 찾고자 하는 구
     * @return level이 2넘는 동 개수
     */
    long countLevelOverTwo(GuLocation guLocation);
}
