package com.ddanguizip.server.domain.publicData.controller;

import com.ddanguizip.server.domain.publicData.dto.request.PointData;
import com.ddanguizip.server.domain.publicData.service.SewerageStatsApiService;
import com.ddanguizip.server.global.common.ApplicationResponse;
import com.ddanguizip.server.global.success.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sewerage")
@RequiredArgsConstructor
public class SewerageStatsController {
    private final SewerageStatsApiService sewerageStatsApiService;

    /**
     * 좌표이용하여 노후관로 데이터 요청 API 엔드포인트
     * 행정구, 행정동 데이터 저장 후 노후관로 데이터 저장하는 로직
     */
    @PostMapping("/openapi/hasudo")
    public ApplicationResponse<Void> saveLocationAndHasudoInfo(@RequestBody List<PointData> pointDataList){
        sewerageStatsApiService.process(pointDataList);
        return ApplicationResponse.success(SuccessCode.SUCCESS);
    }
}
