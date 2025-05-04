package com.ddanguizip.server.domain.publicData.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "agingRateApi", url = "${openapi.agingRate.base-uri}")
public interface SewerageStatsApiClient {
    //노후관로, 행정구 데이티 가져오는 api 요청
    @PostMapping(value = "/egis/core/getMyLocationHasudo.do", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> inquireHasudo(@RequestBody Map<String, Object> request);

}
