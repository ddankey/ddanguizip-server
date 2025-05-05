package com.ddanguizip.server.domain.accident.enumrate;

public enum AccidentCategory {
    AGING_INFRA("노후 지하시설물"),
    BAD_CONSTRUCTION("시공·복구 불량"),
    EXTERNAL_LOAD("외부 하중·진동"),
    WEATHER_NATURE("기상·자연 요인"),
    CONSTRUCTION_SITE("건축공사장 영향"),
    COMPLEX_CAUSE("복합 요인·관리 부재"),
    UNKNOWN("원인 불명/조사 중"),
    ETC("기타");

    private final String description;

    AccidentCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static boolean existCategory(String category) {
        for (AccidentCategory value : AccidentCategory.values()) {
            if (value.name().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}