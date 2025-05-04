package com.ddanguizip.server.domain.map.dto.reponse;

import com.ddanguizip.server.domain.publicData.entity.SelectedRiskArea;
import lombok.Builder;

@Builder
public record RiskAreaDetailList(
        String code,
        String section,
        String reason


) {
    public static RiskAreaDetailList of(String code, SelectedRiskArea selectedRiskArea
                                        ){
        return RiskAreaDetailList.builder()
                .code(code)
                .section(selectedRiskArea.getSection())
                .reason(selectedRiskArea.getReason())
                .build();
    }
}
