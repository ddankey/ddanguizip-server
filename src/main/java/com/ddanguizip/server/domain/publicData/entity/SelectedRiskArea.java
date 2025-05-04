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
@Table(name = "selectedRiskArea")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SelectedRiskArea extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(nullable = false, length = 40)
    private String section;

    @Column(nullable = false, length = 100)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @Builder
    public SelectedRiskArea(String section, String reason, Location location) {
        this.section = section;
        this.reason = reason;
        this.location = location;
    }
}
