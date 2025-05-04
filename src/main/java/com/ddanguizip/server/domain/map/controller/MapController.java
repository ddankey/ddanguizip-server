package com.ddanguizip.server.domain.map.controller;

import com.ddanguizip.server.domain.map.dto.reponse.RiskAreaListRes;
import com.ddanguizip.server.domain.map.dto.reponse.RiskListRes;
import com.ddanguizip.server.domain.map.service.MapService;
import com.ddanguizip.server.global.common.ApplicationResponse;
import com.ddanguizip.server.global.success.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/map")
@RequiredArgsConstructor
public class MapController {
    private final MapService mapService;

    @GetMapping("/risk/selected-area")
    public ApplicationResponse<RiskAreaListRes> search(
            @RequestParam(name = "code", defaultValue = "") String code,
            @PageableDefault(size = 1,page = 0) Pageable pageable) {

        RiskAreaListRes riskAreaListRes = mapService.findRiskAreaList(code, pageable);
        return ApplicationResponse.success(SuccessCode.SUCCESS,riskAreaListRes);
    }

    @GetMapping("/risk/dong")
    public ApplicationResponse<RiskListRes> getRiskListByDong() {

        RiskListRes riskListRes = mapService.findRiskListByDong();
        return ApplicationResponse.success(SuccessCode.SUCCESS,riskListRes);
    }
}
