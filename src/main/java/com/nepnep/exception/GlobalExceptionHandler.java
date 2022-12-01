package com.nepnep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<ErrorResponse> handleException(Exception e){
		log.error("handleException throw Exception : {}",e.fillInStackTrace());
		return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
