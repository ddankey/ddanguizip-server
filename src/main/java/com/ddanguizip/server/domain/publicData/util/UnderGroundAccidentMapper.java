package com.ddanguizip.server.domain.publicData.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UnderGroundAccidentMapper {
    public List<String> toAccidentResponse(Map<String, Object> response) {
        try {
            Map<String, Object> r = (Map<String, Object>) response.get("response");
            Map<String, Object> body = (Map<String, Object>) r.get("body");
            Map<String, Object> itemsMap = (Map<String, Object>) body.get("items");

            List<Map<String, Object>> items = (List<Map<String, Object>>) itemsMap.get("item");

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
}
