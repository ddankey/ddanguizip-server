package com.ddanguizip.server.domain.accident.entity;

import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "accident_sago_no")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
//20250505: 20250504
public class AccidentSagoNo extends BaseTimeEntity {

    @Id
    private String sagoNo;  // sagoNo가 저장될 PK 컬럼
}
