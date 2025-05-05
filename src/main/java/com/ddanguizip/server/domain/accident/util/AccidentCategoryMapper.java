package com.ddanguizip.server.domain.accident.util;

import com.ddanguizip.server.domain.accident.enumrate.AccidentCategory;
import org.springframework.stereotype.Component;

@Component
public class AccidentCategoryMapper {

    public AccidentCategory mapCategory(String detail) {
        String lower = detail.toLowerCase();

        if (lower.contains("노후") || lower.contains("부식") || lower.contains("손상"))
            return AccidentCategory.AGING_INFRA;

        if (lower.contains("다짐") || lower.contains("시공불량") || lower.contains("접합불량") || lower.contains("복구"))
            return AccidentCategory.BAD_CONSTRUCTION;

        if (lower.contains("중차량") || lower.contains("레미콘") || lower.contains("하중") || lower.contains("진동"))
            return AccidentCategory.EXTERNAL_LOAD;

        if (lower.contains("집중호우") || lower.contains("해빙") || lower.contains("압밀"))
            return AccidentCategory.WEATHER_NATURE;

        if (lower.contains("건축공사장") || lower.contains("현장") || lower.contains("인접") || lower.contains("굴착공사"))
            return AccidentCategory.CONSTRUCTION_SITE;

        if (lower.contains("복합") || lower.contains("폐관") || lower.contains("점검") || lower.contains("누락"))
            return AccidentCategory.COMPLEX_CAUSE;

        if (lower.contains("원인불명") || lower.contains("조사") || lower.contains("미상"))
            return AccidentCategory.UNKNOWN;

        return AccidentCategory.ETC;
    }
}