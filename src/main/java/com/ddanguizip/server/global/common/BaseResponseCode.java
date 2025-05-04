package com.ddanguizip.server.global.common;

import org.springframework.http.HttpStatus;

public interface BaseResponseCode {
    HttpStatus getHttpStatus();
    Integer getCode();
    String getMessage();
}
