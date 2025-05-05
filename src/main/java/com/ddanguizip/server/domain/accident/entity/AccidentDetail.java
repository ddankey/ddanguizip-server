package com.ddanguizip.server.domain.accident.entity;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "accidentDetail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentDetail extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(nullable = false, length = 40)
    private String addr;

    @Column(nullable = false, length = 500)
    private String sagoDetail;

    @Column(nullable = false, length = 20)
    private String sagoDate;

    @Column(nullable = false, length = 20)
    private String sinkWidth;

    @Column(nullable = false, length = 20)
    private String sinkExtend;

    @Column(nullable = false, length = 20)
    private String sinkDepth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "accident_sageNo", unique = true)
    private AccidentSagoNo sageNo;

    @Builder
    public AccidentDetail(String addr,
                          String sagoDetail,
                          String sagoDate,
                          String sinkWidth,
                          String sinkExtend,
                          String sinkDepth,
                          Location location,
                          AccidentSagoNo sageNo) {
        this.addr = addr;
        this.sagoDetail = sagoDetail;
        this.sagoDate = sagoDate;
        this.sinkWidth = sinkWidth;
        this.sinkExtend = sinkExtend;
        this.sinkDepth = sinkDepth;
        this.location = location;
        this.sageNo = sageNo;
    }
}
