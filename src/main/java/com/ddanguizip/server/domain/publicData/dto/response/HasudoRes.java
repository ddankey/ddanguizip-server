package com.ddanguizip.server.domain.publicData.dto.response;

import lombok.Builder;

@Builder
public record HasudoRes(
        String gu,
        Double oldExtnPer,
        String oldExtnPerYr
) {
}
