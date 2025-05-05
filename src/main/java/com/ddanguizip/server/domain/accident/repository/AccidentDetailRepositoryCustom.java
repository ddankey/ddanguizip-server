package com.ddanguizip.server.domain.accident.repository;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.enumrate.AccidentCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccidentDetailRepositoryCustom {
    /**
     * 행궁동 기반 데이터 검색
     * @param category category
     */
    Page<AccidentDetail> searchList (AccidentCategory category, Pageable pageable);
}
