package com.nepnep.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {ApiException.class})
	protected ResponseEntity<ErrorResponse> handleApiException(ApiException e){
		log.error("handleApiException throw Exception : {}",e.getErrorCode());
		return ErrorResponse.toResponseEntity(e.getErrorCode());
	}
	

}
