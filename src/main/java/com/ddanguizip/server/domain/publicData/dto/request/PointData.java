package com.ddanguizip.server.domain.publicData.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PointData(
        @JsonProperty("EMD_CD")
        long EMD_CD,
        @JsonProperty("EMD_KOR_NM")
        String EMD_KOR_NM,
        @JsonProperty("wktPoint")
        String wktPoint
) {
}
