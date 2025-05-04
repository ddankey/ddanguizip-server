package com.ddanguizip.server.domain.map.dto.reponse;

import lombok.Builder;

import java.util.List;

@Builder
public record RiskListRes(
        List<RiskDetail> riskDetailList
) {
    public static RiskListRes of(List<RiskDetail> riskDetailList
    ){
        return RiskListRes.builder()
                .riskDetailList(riskDetailList)
                .build();
    }
}
