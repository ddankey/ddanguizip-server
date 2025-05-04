package com.ddanguizip.server.global.success;


import com.ddanguizip.server.global.common.BaseResponseCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum SuccessCode implements BaseResponseCode {
    SUCCESS(HttpStatus.OK, 1000, "정상적인 요청입니다."),
    CREATED(HttpStatus.CREATED, 1001, "정상적으로 생성되었습니다.");

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;

    SuccessCode(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
