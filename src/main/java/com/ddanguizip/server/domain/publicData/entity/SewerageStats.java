package com.ddanguizip.server.domain.publicData.entity;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sewerageStats")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SewerageStats extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @OneToOne
    @JoinColumn(name = "location_id", unique = true) // 유일하게 연결됨
    private Location location;

    @Column(nullable = true)
    private Double agingRate;  // 노후관율

    @Column(nullable = true)
    private String agingRateYr;  // 노후관율 업데이트 년도

    @Column(nullable = true)
    private Double dredgingRate; // 준설율

    @Column(nullable = true)
    private String dredgingRateYr;  // 준설율 업데이트 년도

    @Builder
    public SewerageStats(Location location, Double agingRate, String agingRateYr, Double dredgingRate, String dredgingRateYr) {
        this.location = location;
        this.agingRate = agingRate;
        this.agingRateYr = agingRateYr;
        this.dredgingRate = dredgingRate;
        this.dredgingRateYr = dredgingRateYr;
    }

    public void updatedredgingRateAndDredgingRateYr(Double dredgingRate, String dredgingRateYr){
        this.dredgingRate = dredgingRate;
        this.dredgingRateYr = dredgingRateYr;
    }
}