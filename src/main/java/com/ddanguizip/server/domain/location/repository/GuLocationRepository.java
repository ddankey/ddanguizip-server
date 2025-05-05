package com.ddanguizip.server.domain.location.repository;

import com.ddanguizip.server.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuLocationRepository extends JpaRepository<Location, Long>{
}
