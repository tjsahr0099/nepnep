package com.nepnep.querymaker.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nepnep.querymaker.mapper.QueryMakerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QueryMakerService")
public class QueryMakerServiceImpl implements QueryMakerService{

	
	@Autowired
	QueryMakerMapper queryMakerMapper;
	
	
	@Override
	public List<Map<String, Object>> executeQuery(Map<String, Object> input) {
		
		log.info("executeQuery 진입");
		
		// TODO : 비즈니스 로직 개발
		queryMakerMapper.test();
		
		
		log.info("executeQuery 종료");
		
		return null;
	}

}
