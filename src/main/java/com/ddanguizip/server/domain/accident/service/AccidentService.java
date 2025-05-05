package com.ddanguizip.server.domain.accident.service;

import com.ddanguizip.server.domain.accident.dto.AccidentInfoDetail;
import com.ddanguizip.server.domain.accident.dto.AccidentInfoList;
import com.ddanguizip.server.domain.accident.entity.AccidentDetail;
import com.ddanguizip.server.domain.accident.enumrate.AccidentCategory;
import com.ddanguizip.server.domain.accident.repository.AccidentDetailRepository;
import com.ddanguizip.server.domain.accident.validator.AccidentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService {
    private final AccidentValidator accidentValidator;
    private final AccidentDetailRepository accidentDetailRepository;

    public AccidentInfoList searchAccidentListByCategory(String category, Pageable pageable) {
        //카테고리 검사
        accidentValidator.validateAccidentCategory(category);
        AccidentCategory accidentCategoryEnum = AccidentCategory.valueOf(category.toUpperCase());

        //location 통해서 데이터 추출
        Page<AccidentDetail> accidentDetailPage = accidentDetailRepository.searchList(accidentCategoryEnum, pageable);
        List<AccidentInfoDetail> list = new ArrayList<>();
        accidentDetailPage.getContent().forEach(accidentDetail -> list.add(AccidentInfoDetail.of(accidentDetail, accidentCategoryEnum.getDescription())));

        return AccidentInfoList.of(list, accidentDetailPage.getNumber(), accidentDetailPage.getSize(),accidentDetailPage.getTotalElements(), accidentDetailPage.getTotalPages());
    }
}
