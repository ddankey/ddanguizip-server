package com.ddanguizip.server.domain.location.entity;

import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "location")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(nullable = false, length = 20)
    private String gu;

    @Column(nullable = false, length = 20)
    private String dong;

    @Column(nullable = false, length = 20)
    private String code;

    @Builder
    public Location(String gu, String dong, String code) {
        this.gu = gu;
        this.dong = dong;
        this.code = code;
    }
}