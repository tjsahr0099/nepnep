package com.nepnep.querymaker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nepnep.querymaker.mapper.QueryMakerMapper;
import com.nepnep.querymaker.model.SchemaVO;
import com.nepnep.querymaker.model.TableVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QueryMakerService")
public class QueryMakerServiceImpl implements QueryMakerService {

	@Autowired
	QueryMakerMapper queryMakerMapper;

	@Override
	public List<String> selectTableName() {
		log.info("selectTableName 진입");

		List<String> result = new ArrayList<String>();
		List<SchemaVO> schemaInfos = queryMakerMapper.selectTableName();

		for (SchemaVO schemaInfo : schemaInfos) {
			result.add(schemaInfo.getTableName());
		}

		log.info("selectTableName 종료");

		return result;
	}

	@Override
	public List<String> selectField(String tableName) {
		log.info("selectField 진입");

		List<String> result = new ArrayList<String>();
		List<TableVO> tableInfos = queryMakerMapper.selectField(tableName);

		for (TableVO tableInfo : tableInfos) {
			result.add(tableInfo.getField().toUpperCase());
		}

		log.info("selectField 종료");

		return result;
	}

	@Override
	public Map<String, Object> executeQuery(Map<String, String> input) {
		log.info("executeQuery 진입");

		String field = input.get("field");
		String table = input.get("table");
		String query = "SELECT " + field + " FROM " + table;

		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("query", query);
		result.put("result", queryMakerMapper.executeQuery(query));

		log.info("executeQuery 종료");

		return result;
	}

}
