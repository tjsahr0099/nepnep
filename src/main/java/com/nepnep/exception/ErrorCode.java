package com.nepnep.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "유저 정보를 찾을 수 없습니다."),

	TOKEN_EXPIRED(HttpStatus.FORBIDDEN, "만료된 토큰입니다."), 
	TOKEN_INVALID(HttpStatus.FORBIDDEN, "잘못된 토큰입니다."),
	TOKEN_EMPTY(HttpStatus.FORBIDDEN, "토큰이 없습니다."),
	
	QUERY_MAKER_STD_TABLE_NOT_FOUND(HttpStatus.BAD_REQUEST, "기준 테이블이 존재하지 않습니다."),
	QUERY_MAKER_TABLE_INVALIDATE(HttpStatus.BAD_REQUEST, "테이블 요청이 유효하지 않습니다."),
	QUERY_MAKER_COLUMN_INVALIDATE(HttpStatus.BAD_REQUEST, "컬럼 요청이 유효하지 않습니다."),	
	QUERY_MAKER_WHERE_INVALIDATE(HttpStatus.BAD_REQUEST, "조건이 유효하지 않습니다."),
	QUERY_MAKER_GROUP_INVALIDATE(HttpStatus.BAD_REQUEST, "그룹이 유효하지 않습니다."),
	QUERY_MAKER_GROUP_COLUMN_NOT_MATCH(HttpStatus.BAD_REQUEST, "조회 컬럼이 그룹화되지 않았습니다.");

	;

	private final HttpStatus httpStatus;
	private final String msg;

}
