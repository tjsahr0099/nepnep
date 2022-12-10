package com.nepnep.querymaker.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.nepnep.querymaker.model.SchemaVO;
import com.nepnep.querymaker.model.TableVO;

@Mapper
public interface QueryMakerMapper {

	List<SchemaVO> selectTableName();

	List<TableVO> selectField(String tableName);

	List<Map<String, Object>> executeQuery(String query);

}
