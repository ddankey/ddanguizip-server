package com.ddanguizip.server.domain.publicData.entity;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    private Double agingRate;  // 노후관율

    @Column(length=7)
    private String agingRateYr;  // 노후관율 업데이트 년도

    private Double dredgingRate; // 준설율

    @Column(length=7)
    private String dredgingRateYr;  // 준설율 업데이트 년도

    private Double riskScore;  // 위험 점수

    private Integer riskLevel;  // 위험도

    @Builder
    public SewerageStats(Location location, Double agingRate, String agingRateYr) {
        this.location = location;
        this.agingRate = agingRate;
        this.agingRateYr = agingRateYr;
    }

    public void updatedredgingRateAndDredgingRateYr(Double dredgingRate, String dredgingRateYr){
        this.dredgingRate = dredgingRate;
        this.dredgingRateYr = dredgingRateYr;
    }

    public void updateRiskScoreAndRiskLevel(Double riskScore, int riskLevel){
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
    }
}