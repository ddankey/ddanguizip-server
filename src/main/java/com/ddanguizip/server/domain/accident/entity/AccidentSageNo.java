package com.ddanguizip.server.domain.accident.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "accident_sage_no")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AccidentSageNo {

    @Id
    private String code;  // sagoNo가 저장될 PK 컬럼
}
