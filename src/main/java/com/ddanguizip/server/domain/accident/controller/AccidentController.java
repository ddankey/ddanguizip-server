package com.ddanguizip.server.domain.accident.controller;

import com.ddanguizip.server.domain.accident.dto.AccidentInfoList;
import com.ddanguizip.server.domain.accident.service.AccidentService;
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
@RequestMapping("/api/v1/accident")
@RequiredArgsConstructor
public class AccidentController {
    private final AccidentService accidentService;

    @GetMapping("")
    public ApplicationResponse<AccidentInfoList> search(
            @RequestParam(name = "category", defaultValue = "") String category,
            @PageableDefault(size = 10,page = 0) Pageable pageable) {

        AccidentInfoList accidentInfoList = accidentService.searchAccidentListByCategory(category, pageable);
        return ApplicationResponse.success(SuccessCode.SUCCESS,accidentInfoList);
    }
}
