package com.nepnep.wiki.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {
	private final ErrorCode errorCode;
}
