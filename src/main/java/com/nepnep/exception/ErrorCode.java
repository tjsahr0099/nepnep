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
	TOKEN_EMPTY(HttpStatus.FORBIDDEN, "토큰이 없습니다.")

	;

	private final HttpStatus httpStatus;
	private final String msg;

}
