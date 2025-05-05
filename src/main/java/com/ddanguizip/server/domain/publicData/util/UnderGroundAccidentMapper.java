package com.ddanguizip.server.domain.publicData.util;

import com.ddanguizip.server.domain.publicData.dto.response.AccidentDetailRes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UnderGroundAccidentMapper {
    //지반침하사고 요청 후 서울특별시 데이터만 필터링하여 고유번호 리스트화
    public List<String> toAccidentResponse(Map<String, Object> response) {
        try {
            Map<String, Object> r = (Map<String, Object>) response.get("response");
            Map<String, Object> body = (Map<String, Object>) r.get("body");
            List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");

            List<String> result = new ArrayList<>();

            for (Map<String, Object> item : items) {
                String sido = (String) item.get("sido");
                if ("서울특별시".equals(sido)) {
                    String sagoNo = (String) item.get("sagoNo");
                    result.add(sagoNo);
                }
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("지반침하 사고 이력 파싱 실패", e);
        }
    }

    //지반침하사고 상세정보 요청 후 필요한 데이터만 필터링
    public List<AccidentDetailRes> toAccidentDetailResponse(Map<String, Object> response) {
        try {
            Map<String, Object> r = (Map<String, Object>) response.get("response");
            Map<String, Object> body = (Map<String, Object>) r.get("body");
            List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");

            List<AccidentDetailRes> result = new ArrayList<>();

            for (Map<String, Object> item : items) {
                result.add(AccidentDetailRes.of(
                        (String) item.get("sagoNo"),
                        (String) item.get("sigungu"),
                        (String) item.get("dong"),
                        (String) item.get("addr"),
                        (String) item.get("sagoDetail"),
                        (String) item.get("sagoDate"),
                        (String) item.get("sinkWidth"),
                        (String) item.get("sinkExtend"),
                        (String) item.get("sinkDepth")
                ));
            }

            return result;

        } catch (Exception e) {
            throw new RuntimeException("지반침하 사고 이력 파싱 실패", e);
        }
    }
}
