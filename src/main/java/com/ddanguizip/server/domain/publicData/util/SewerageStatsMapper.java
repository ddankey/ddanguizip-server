package com.ddanguizip.server.domain.publicData.util;

import com.ddanguizip.server.domain.publicData.dto.response.HasudoRes;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component //컴포넌트 스캔 대상 클래스 (bean 자동 등록)
public class SewerageStatsMapper {
    public HasudoRes toHasudoResponse(Map<String, Object> response) {
        try {
            Map<String, Object> rst = (Map<String, Object>) response.get("rst");

            String gu = (String) rst.get("gugun");
            Double oldExtnPer = (Double) rst.get("oldExtnPer");
            String oldExtnPerYr = (String) rst.get("oldExtnPerYr");

            return HasudoRes.builder()
                    .gu(gu)
                    .oldExtnPer(oldExtnPer)
                    .oldExtnPerYr(oldExtnPerYr)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("노후관로 요청 실패");
        }
    }
}
