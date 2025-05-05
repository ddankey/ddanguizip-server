package com.ddanguizip.server.domain.publicData.repository.selectedRiskArea;

import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectedRiskAreaRepository extends JpaRepository<SelectedRiskArea, Long>, SelectedRiskAreaRepositoryCustom{
}
