package com.ddanguizip.server.domain.publicData.repository.sewerageStats;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.entity.SewerageStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SewerageStatsRepository extends JpaRepository<SewerageStats, Long>, SewerageStatsRepositoryCustom{
    Optional<SewerageStats> findSewerageStatsByLocation(Location location);
}
