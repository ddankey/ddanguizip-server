package com.ddanguizip.server.domain.location.factory;

import com.ddanguizip.server.domain.location.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationFactory {
    public Location create(String gu, String dong, String code) {
        return Location.builder()
                .gu(gu)
                .dong(dong)
                .code(code)
                .build();
    }
}
