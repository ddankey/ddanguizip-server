package com.ddanguizip.server.domain.publicData.repository.sewerageStats;

import com.ddanguizip.server.domain.map.dto.reponse.RiskDetail;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.ddanguizip.server.domain.location.entity.QLocation.location;
import static com.ddanguizip.server.domain.publicData.entity.QSewerageStats.sewerageStats;

public class SewerageStatsRepositoryImpl implements SewerageStatsRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public SewerageStatsRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<RiskDetail> findRiskDetails() {

        return queryFactory
                .select(Projections.constructor(RiskDetail.class,
                        location.code,
                        sewerageStats.riskLevel))
                .from(sewerageStats)
                .join(sewerageStats.location, location)
                .fetch();
    }
}
