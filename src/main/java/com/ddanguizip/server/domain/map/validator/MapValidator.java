package com.ddanguizip.server.domain.map.validator;

import com.ddanguizip.server.domain.location.entity.Location;
import com.ddanguizip.server.global.exception.ApplicationException;
import com.ddanguizip.server.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapValidator {
    public void validateLoaction(Location location) {
        if (location == null) {
            throw new ApplicationException(ErrorCode.NOT_FOUND_CODE_EXCEPTION);
        }
    }
}
