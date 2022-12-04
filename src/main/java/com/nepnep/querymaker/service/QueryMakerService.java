package com.nepnep.querymaker.service;

import java.util.List;
import java.util.Map;

public interface QueryMakerService {
	
	public List<Map<String,Object>> executeQuery(Map<String,Object> input);

}
