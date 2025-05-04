package com.ddanguizip.server.domain.map.dto.reponse;

import lombok.Builder;

import java.util.List;

@Builder
public record RiskAreaListRes(
        List<RiskAreaDetail> riskAreaDetailList,
        int pageNo,
        long pageSize,
        int totalPages
) {
    public static RiskAreaListRes of(List<RiskAreaDetail> riskAreaDetailList,
                                    int pageNo,
                                    long pageSize,
                                    int totalPages
    ){
        return RiskAreaListRes.builder()
                .riskAreaDetailList(riskAreaDetailList)
                .pageSize(pageSize)
                .totalPages(totalPages)
                .pageNo(pageNo)
                .build();
    }
}