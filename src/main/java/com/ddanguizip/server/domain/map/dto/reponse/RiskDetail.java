package com.ddanguizip.server.domain.map.dto.reponse;

import lombok.Builder;

@Builder
public record RiskDetail(
        String code,
        Integer level
) {
    public static RiskDetail of(String code, Integer level){
        return RiskDetail.builder()
                .code(code)
                .level(level)
                .build();
    }
}
