package com.ddanguizip.server.domain.location.factory;

import com.ddanguizip.server.domain.location.entity.GuLocation;
import org.springframework.stereotype.Component;

@Component
public class GuLocationFactory {
    public GuLocation create(String gu, String code) {
        return GuLocation.builder()
                .gu(gu)
                .code(code)
                .build();
    }
}
