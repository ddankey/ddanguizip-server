package com.ddanguizip.server.domain.accident.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record AccidentInfoList(
        List<AccidentInfoDetail> accidentInfoDetailList,
        int pageNo,
        long pageSize,
        long totalSize,
        int totalPages
) {
    public static AccidentInfoList of(List<AccidentInfoDetail> accidentInfoDetailList,
                                      int pageNo,
                                      long pageSize,
                                      long totalSize,
                                      int totalPages
    ){
        return AccidentInfoList.builder()
                .accidentInfoDetailList(accidentInfoDetailList)
                .pageSize(pageSize)
                .totalPages(totalPages)
                .totalSize(totalSize)
                .pageNo(pageNo)
                .build();
    }
}