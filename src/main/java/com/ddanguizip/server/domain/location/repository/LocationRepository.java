package com.ddanguizip.server.domain.location.repository;

import com.ddanguizip.server.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long>{
    List<Location> findAllByGu(String gu);
    Location findLocationByDong(String dong);
    Location findLocationByCode(String code);
}
