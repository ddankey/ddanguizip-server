package com.ddanguizip.server.domain.publicData.enumerate;

import java.util.Arrays;

public enum GuCode {
    GANGSEO_GU(11500, "강서구"),
    YANGCHEON_GU(11470, "양천구"),
    GURO_GU(11530, "구로구"),
    GEUMCHEON_GU(11545, "금천구"),
    YEONGDEUNGPO_GU(11560, "영등포구"),
    DONGJAK_GU(11590, "동작구"),
    GWANAK_GU(11620, "관악구"),
    MAPO_GU(11440, "마포구"),
    YONGSAN_GU(11170, "용산구"),
    SEOCHO_GU(11650, "서초구"),
    GANGNAM_GU(11680, "강남구"),
    SONGPA_GU(11710, "송파구"),
    GANGDONG_GU(11740, "강동구"),
    EUNPYEONG_GU(11380, "은평구"),
    SEODAEMUN_GU(11410, "서대문구"),
    JUNG_GU(11140, "중구"),
    SEONGDONG_GU(11200, "성동구"),
    GWANGJIN_GU(11215, "광진구"),
    JONGNO_GU(11110, "종로구"),
    SEONGBUK_GU(11290, "성북구"),
    DONGDAEMUN_GU(11230, "동대문구"),
    JUNGRANG_GU(11260, "중랑구"),
    GANGBUK_GU(11305, "강북구"),
    DOBONG_GU(11320, "도봉구"),
    NOWON_GU(11350, "노원구");

    private final int code;
    private final String guName;

    GuCode(int code, String guName) {
        this.code = code;
        this.guName = guName;
    }

    public int getCode() {
        return code;
    }

    public String getGuName() {
        return guName;
    }

}
