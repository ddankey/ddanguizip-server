package com.ddanguizip.server.domain.publicData.repository.selectedRiskArea;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SelectedRiskAreaRepositoryCustom {
    /**
     * 행궁동 기반 데이터 검색
     * @param location location
     */
    Page<SelectedRiskArea> searchList (Location location, Pageable pageable);

    /**
     * 행궁동으로 데이터 존재하는지 확인
     * @param location location
     * @return 존재여부
     */
    boolean existsByLocation(Location location);
}
