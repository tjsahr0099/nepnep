package com.nepnep.querymaker.mapper;

import com.nepnep.querymaker.model.BoardVO;
import com.nepnep.querymaker.service.SqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface QueryMakerMapper {

	String test(String testQuery);

	List<BoardVO> select1(String testQuery);

	@SelectProvider(type= SqlProvider.class, method = "mySelect")
	String selectBySqlProvider();


}
