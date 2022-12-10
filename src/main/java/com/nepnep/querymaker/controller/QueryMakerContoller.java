package com.nepnep.querymaker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nepnep.exception.ApiException;
import com.nepnep.exception.ErrorCode;
import com.nepnep.querymaker.service.QueryMakerService;
import com.nepnep.wiki.common.URLs;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(URLs.QUERY_MAKER)
@Slf4j
public class QueryMakerContoller {

	@Autowired
	private QueryMakerService queryMakerService;

	@GetMapping("/execute")
	private Map<String, Object> execute(@RequestParam Map<String, String> input) {
		log.info("컨트롤러 진입 input : {} ", input);

		String field = input.get("field");
		String table = input.get("table");

		// table 값이 없는 경우, 에러 처리
		if (null == table) {
			throw new ApiException(ErrorCode.TABLE_EMPTY);
		}

		// 존재하지 않는 테이블명인 경우, 에러 처리
		List<String> tableNames = queryMakerService.selectTableName();

		if (!tableNames.contains(table)) {
			throw new ApiException(ErrorCode.TABLE_UNEXIST);
		}

		// colName 값이 없는 경우, 전체 컬럼 조회
		if (null == field) {
			input.put("field", "*");
		} else {
			// 존재하지 않는 컬럼인 경우, 에러 처리
			List<String> fieldNames = queryMakerService.selectField(table);

			for (String f : field.split(",")) {
				if (!fieldNames.contains(f.toUpperCase())) {
					throw new ApiException(ErrorCode.FIELD_UNEXIST);
				}
			}
		}

		return queryMakerService.executeQuery(input);
	}

}
