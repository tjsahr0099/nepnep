package com.nepnep.querymaker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nepnep.querymaker.service.QueryMakerService;
import com.nepnep.wiki.common.URLs;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(URLs.QUERY_MAKER)
@Slf4j
public class QueryMakerContoller {

	@Autowired
	private QueryMakerService queryMakerService;
	
	@PostMapping("/execute")
	private Map<String,Object> execute(@RequestBody Map<String, Object> input){
	
		
		log.info("컨트롤러 진입 input : {} " , input);
		
		return queryMakerService.executeQuery(input);		
		
	}
	
}
