package com.nepnep.querymaker.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryMakerMapper {

	List<Map<String,Object>> executeQuery(String query);
	
	

}
