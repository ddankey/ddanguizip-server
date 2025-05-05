package com.ddanguizip.server.domain.publicData.entity;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "guRiskStats")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuRiskStats extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(nullable = false)
    private Double riskRatio;

    @Column(nullable = false)
    private Integer riskLevel;

    @OneToOne
    @JoinColumn(name = "gu_location_id", unique = true) // 유일하게 연결됨
    private GuLocation guLocation;

    @Builder
    public GuRiskStats(Double riskRatio, Integer riskLevel, GuLocation guLocation) {
        this.riskRatio = riskRatio;
        this.riskLevel = riskLevel;
        this.guLocation = guLocation;
    }
}