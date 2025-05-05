package com.ddanguizip.server.domain.publicData.repository.selectedRiskArea;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.ddanguizip.server.domain.publicData.entity.QSelectedRiskArea.selectedRiskArea;

public class SelectedRiskAreaRepositoryImpl implements SelectedRiskAreaRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public SelectedRiskAreaRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<SelectedRiskArea> searchList(Location location, Pageable pageable) {
        BooleanExpression filterCondition = locationEq(location);

        List<SelectedRiskArea> results = queryFactory
                .selectFrom(selectedRiskArea)
                .where(filterCondition)
                .orderBy(selectedRiskArea.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(selectedRiskArea.count())
                .from(selectedRiskArea)
                .where(filterCondition)
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression locationEq(Location location) {
        if (location == null) {
            return null;
        }
        return selectedRiskArea.location.eq(location);
    }
}
