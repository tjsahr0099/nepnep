package com.nepnep.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	USER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저 정보를 찾을 수 없습니다.");
	
	
	private final HttpStatus httpStatus;
	private final String msg;
	
}
