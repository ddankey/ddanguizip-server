package com.ddanguizip.server.domain.accident.dto;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import lombok.Builder;

@Builder
public record AccidentInfoDetail(
        String gu,
        String dong,
        String addr,
        String sagoDetail,
        String sinkWidth,
        String sinkExtend,
        String sinkDepth,
        String accidentDate,
        String categoryDescription
) {
    public static AccidentInfoDetail of(
            AccidentDetail accidentDetail,
            String categoryDescription
    ){
        return AccidentInfoDetail.builder()
                .gu(accidentDetail.getLocation().getGu())
                .dong(accidentDetail.getLocation().getDong())
                .addr(accidentDetail.getAddr())
                .accidentDate(accidentDetail.getSagoDate())
                .sagoDetail(accidentDetail.getSagoDetail())
                .sinkWidth(accidentDetail.getSinkWidth())
                .sinkExtend(accidentDetail.getSinkExtend())
                .sinkDepth(accidentDetail.getSinkDepth())
                .categoryDescription(categoryDescription)
                .build();
    }
}
