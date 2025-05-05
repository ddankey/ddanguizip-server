package com.ddanguizip.server.domain.accident.repository;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.enumrate.AccidentCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.ddanguizip.server.domain.accident.entity.QAccidentDetail.accidentDetail;

public class AccidentDetailRepositoryImpl implements AccidentDetailRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public AccidentDetailRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<AccidentDetail> searchList(AccidentCategory category, Pageable pageable) {
        BooleanExpression filterCondition = categoryEq(category);

        List<AccidentDetail> results = queryFactory
                .selectFrom(accidentDetail)
                .where(filterCondition)
                .orderBy(accidentDetail.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(accidentDetail.count())
                .from(accidentDetail)
                .where(filterCondition)
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression categoryEq(AccidentCategory category) {
        if (category == null) {
            return null;
        }
        return accidentDetail.category.eq(category);
    }
}
