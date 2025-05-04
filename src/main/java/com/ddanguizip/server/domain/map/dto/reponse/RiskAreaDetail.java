package com.ddanguizip.server.domain.map.dto.reponse;

import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import lombok.Builder;

@Builder
public record RiskAreaDetail(
        String code,
        String section,
        String reason


) {
    public static RiskAreaDetail of(String code, SelectedRiskArea selectedRiskArea
                                        ){
        return RiskAreaDetail.builder()
                .code(code)
                .section(selectedRiskArea.getSection())
                .reason(selectedRiskArea.getReason())
                .build();
    }
}
