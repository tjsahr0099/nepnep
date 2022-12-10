package com.nepnep.querymaker.service;

import com.nepnep.querymaker.model.BoardVO;
import com.nepnep.querymaker.model.ResultResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface QueryMakerService {
	
	ResponseEntity<ResultResponseDto> executeQuery(Map<String,String> input);



}
