package com.ddanguizip.server.domain.location.entity;

import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "guLocation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuLocation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(nullable = false, length = 20)
    private String gu;

    @Column(nullable = false, length = 20)
    private String code;

    @Builder
    public GuLocation(String gu, String code) {
        this.gu = gu;
        this.code = code;
    }
}