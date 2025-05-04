package com.ddanguizip.server.domain.publicData.dto.response;

import lombok.Builder;

@Builder
public record HasudoResponse(
        String gu,
        Double oldExtnPer,
        String oldExtnPerYr
) {
}
