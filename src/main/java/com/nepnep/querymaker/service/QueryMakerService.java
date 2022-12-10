package com.nepnep.querymaker.service;

import java.util.List;
import java.util.Map;

import com.nepnep.querymaker.model.SchemaVO;
import com.nepnep.querymaker.model.TableVO;

public interface QueryMakerService {
	public List<String> selectTableName();

	public List<String> selectField(String tableName);

	public Map<String, Object> executeQuery(Map<String, String> input);

}
