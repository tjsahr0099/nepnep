package com.nepnep.querymaker.controller;

import java.util.List;
import java.util.Map;

import com.nepnep.querymaker.model.BoardVO;
import com.nepnep.querymaker.model.ResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nepnep.querymaker.service.QueryMakerService;
import com.nepnep.wiki.common.URLs;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(URLs.QUERY_MAKER)
@Slf4j
@RequiredArgsConstructor
public class QueryMakerContoller {

	private final QueryMakerService queryMakerService;
	
//	@GetMapping("/execute")
//	private List<Map<String,Object>> execute(Map<String, Object> input){
//		System.out.println(input.entrySet());
//		log.info("컨트롤러 진입 input : {} " , input);
//
//		return queryMakerService.executeQuery(input);
//
//	}

	@GetMapping("/execute")
	private ResponseEntity<ResultResponseDto> execute(@RequestParam Map<String, String> input){
		System.out.println(input.entrySet());
		log.info("컨트롤러 진입 input : {} " , input);

		return queryMakerService.executeQuery(input);

	}
	
}
