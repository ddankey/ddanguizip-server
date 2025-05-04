package com.ddanguizip.server.domain.publicData.repository;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SelectedRiskAreaRepository extends JpaRepository<SelectedRiskArea, Long>, SelectedRiskAreaRepositoryCustom{
}
