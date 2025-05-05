package com.ddanguizip.server.domain.accident.repository;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.entity.AccidentSagoNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentDetailRepository extends JpaRepository<AccidentDetail, Long>,AccidentDetailRepositoryCustom {
}
