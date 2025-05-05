package com.ddanguizip.server.domain.publicData.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "accidentApi", url = "${openapi.accident.base-uri}")
public interface UndergroundAccidentApiClient {
    //지반침하사고 고유번호 가져오는 api 요청
    @PostMapping(value = "/1611000/undergroundsafetyinfo/getSubsidenceList", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> inquireAccident(@RequestParam("serviceKey") String serviceKey,
                                        @RequestParam("pageNo") int pageNo,
                                        @RequestParam("type") String type,
                                        @RequestParam("sagoDateFrom") String sagoDateFrom,
                                        @RequestParam("sagoDateTo") String sagoDateTo);

    //지반침하사고 고유번호 가져오는 api 요청
    @PostMapping(value = "/1611000/undergroundsafetyinfo/getSubsidenceInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> inquireAccidentDetail(@RequestParam("serviceKey") String serviceKey,
                                        @RequestParam("pageNo") int pageNo,
                                        @RequestParam("numOrRows") int numOrRows,
                                        @RequestParam("type") String type,
                                        @RequestParam("sagoNo") String sagoNo);

}
