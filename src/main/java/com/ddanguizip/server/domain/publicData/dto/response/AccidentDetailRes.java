package com.ddanguizip.server.domain.publicData.dto.response;

import lombok.Builder;

@Builder
public record AccidentDetailRes(
        String sagoNo,
        String sigungu,
        String dong,
        String addr,
        String sagoDetail,
        String sagoDate,
        String sinkWidth,
        String sinkExtend,
        String sinkDepth
) {
    public static AccidentDetailRes of(
            String sagoNo,
            String sigungu,
            String dong,
            String addr,
            String sagoDetail,
            String sagoDate,
            String sinkWidth,
            String sinkExtend,
            String sinkDepth
    ){
        return AccidentDetailRes.builder()
                .sagoNo(sagoNo)
                .sigungu(sigungu)
                .dong(dong)
                .addr(addr)
                .sagoDetail(sagoDetail)
                .sagoDate(sagoDate)
                .sinkWidth(sinkWidth)
                .sinkExtend(sinkExtend)
                .sinkDepth(sinkDepth)
                .build();
    }
}
