package com.ddanguizip.server.domain.accident.factory;

import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.entity.AccidentSagoNo;
import com.ddanguizip.server.domain.location.entity.GuLocation;
import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.domain.publicData.dto.response.AccidentDetailRes;
import org.springframework.stereotype.Component;

@Component
public class AccidentFactory {
    public AccidentSagoNo createAccidentSagoNo(String sagoNo) {
        return AccidentSagoNo.builder()
                .sagoNo(sagoNo)
                .build();
    }

    public AccidentDetail createAccidentDetail(AccidentDetailRes accidentDetailRes,Location location, AccidentSagoNo sageNo) {
        return AccidentDetail.builder()
                .addr(accidentDetailRes.addr())
                .sagoDetail(accidentDetailRes.sagoDetail())
                .sagoDate(accidentDetailRes.sagoDate())
                .sinkWidth(accidentDetailRes.sinkWidth())
                .sinkExtend(accidentDetailRes.sinkExtend())
                .sinkDepth(accidentDetailRes.sinkDepth())
                .location(location)
                .sageNo(sageNo)
                .build();
    }
}
