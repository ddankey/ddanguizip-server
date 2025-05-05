package com.ddanguizip.server.domain.accident.validator;

import com.ddanguizip.server.domain.accident.enumrate.AccidentCategory;
import com.ddanguizip.server.global.exception.ApplicationException;
import com.ddanguizip.server.global.exception.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class AccidentValidator {
    public void validateAccidentCategory(String category) {
        if (category == null || !AccidentCategory.existCategory(category)) {
            throw new ApplicationException(ErrorCode.NOT_FOUND_CODE_EXCEPTION);
        }
    }
}
