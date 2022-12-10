package com.nepnep.querymaker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nepnep.exception.ApiException;
import com.nepnep.exception.ErrorCode;
import com.nepnep.querymaker.model.BoardVO;
import com.nepnep.querymaker.model.ResultResponseDto;
import com.nepnep.querymaker.model.SqlEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nepnep.querymaker.mapper.QueryMakerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QueryMakerService")
@RequiredArgsConstructor
public class QueryMakerServiceImpl implements QueryMakerService{

	private final QueryMakerMapper queryMakerMapper;


	@Override
	public ResponseEntity<ResultResponseDto> executeQuery(Map<String, String> input) {
		
		log.info("executeQuery 진입");

		//1번 (queryMaker)
		String testQuery = queryMaker(input);
//		System.out.println("찐이야" + queryMakerMapper.test(testQuery)); //BoardVO 말고 스트링으로 여러개의 값을 받을 수 있나!?
		List<BoardVO> boardVOList = queryMakerMapper.select1(testQuery);


		//2번 (SqlProvider) SQL BUILDER
		log.info("ResultBySqlProvider", queryMakerMapper.selectBySqlProvider());
		SqlProvider sqlProvider = new SqlProvider();
		System.out.println(sqlProvider.mySelect());


		log.info("executeQuery 종료");
		
		return ResponseEntity.ok(
				ResultResponseDto.builder()
						.query(testQuery)
						.result(boardVOList)
						.build()
				);
	}

	//만약 리스트로 받아온다면
	private String getValuesFromList(List<String> valueList){

		StringBuilder values = new StringBuilder();

		for (int i = 0; i < valueList.size(); i++) {

			values.append(valueList.get(i));

			if(i < valueList.size() - 1) {
				values.append(", ");
			}

		}

		return values.toString();
	}
	private String queryMaker(Map<String, String> input) {

		StringBuilder sb = new StringBuilder();

		String column = Optional.ofNullable(input.get("column")).orElseThrow(() -> new ApiException(ErrorCode.REQUIRED_PARAM_NOT_PRESENT));
		String table = Optional.ofNullable(input.get("table")).orElseThrow(() -> new ApiException(ErrorCode.REQUIRED_PARAM_NOT_PRESENT)).toUpperCase();
		String condition = input.get("condition");
		String value = input.get("value");

		sb.append(SqlEnum.SELECT.getQueryStr());
		if(true) {  //컬럼 검증
			sb.append(column);
		}else {
			throw new ApiException(ErrorCode.COLUMN_NOT_FOUND);
		}
		sb.append(SqlEnum.FROM.getQueryStr());
		if(true) {	//테이블 검증
			sb.append(table);
		}else {
			throw new ApiException(ErrorCode.TABLE_NOT_FOUND);
		}

		if(condition != null && value != null) {
			sb.append(SqlEnum.WHERE.getQueryStr());
			if (true) {		//조건 검증(컬럼)
				sb.append(condition);
			}
			sb.append(SqlEnum.EQUALS.getQueryStr() + "'" + value + "'");
		}

		return sb.toString();
	}


}
