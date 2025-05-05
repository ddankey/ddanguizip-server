package com.ddanguizip.server.domain.publicData.controller;

import com.ddanguizip.server.domain.publicData.dto.request.PointData;
import com.ddanguizip.server.domain.publicData.service.SewerageStatsApiService;
import com.ddanguizip.server.domain.publicData.service.UndergroundAccidentApiService;
import com.ddanguizip.server.global.common.ApplicationResponse;
import com.ddanguizip.server.global.success.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/openapi")
@RequiredArgsConstructor
public class RequestOpenApiController {
    private final UndergroundAccidentApiService undergroundAccidentApiService;
    private final SewerageStatsApiService sewerageStatsApiService;

    /**
     * 좌표이용하여 노후관로 데이터 요청 API 엔드포인트
     * 행정구, 행정동 데이터 저장 후 노후관로 데이터 저장하는 로직
     */
    @PostMapping("/hasudo")
    public ApplicationResponse<Void> saveLocationAndHasudoInfo(@RequestBody List<PointData> pointDataList){
        sewerageStatsApiService.process(pointDataList);
        return ApplicationResponse.success(SuccessCode.SUCCESS);
    }

    /**
     * 페이지 넘버 이용하여 지반침하사고리스트 데이터 요청 API 엔드포인트
     * 서울시 필터링 통해 넘버만 저장
     */
    @PostMapping("/accident")
    public ApplicationResponse<Void> saveAccidentSagoNo(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                                        @RequestParam(name = "sagoDateFrom", defaultValue = "20000101") String sagoDateFrom,
                                                        @RequestParam(name = "sagoDateTo", defaultValue = "20250504") String sagoDateTo){
        undergroundAccidentApiService.process(pageNo,sagoDateFrom,sagoDateTo);
        return ApplicationResponse.success(SuccessCode.SUCCESS);
    }
}
