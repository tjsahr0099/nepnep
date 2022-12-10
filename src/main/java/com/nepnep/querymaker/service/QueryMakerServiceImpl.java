package com.nepnep.querymaker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nepnep.exception.ApiException;
import com.nepnep.exception.ErrorCode;
import com.nepnep.querymaker.mapper.QueryMakerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QueryMakerService")
public class QueryMakerServiceImpl implements QueryMakerService{

	
	@Autowired
	QueryMakerMapper queryMakerMapper;
	
	private final String SQL_LINE = "\n############################\n";
	private final String SQL_SELECT_START = "\nSELECT ";
	private final String SQL_FROM_START = "\nFROM ";
	private final String SQL_WHERE_START = "\nWHERE 1=1 ";
	private final String SQL_GROUP_START = "\nGROUP BY ";	
	private final String SQL_ORDER_START = "\nORDER BY ";
	
	private final String[] AGG_FUNC = {"MAX","MIN","AGG"};
	
	
	@Override
	public Map<String,Object> executeQuery(Map<String, Object> input) {
		
		log.info("executeQuery 진입 input : {} " , input);
		inputParseLog(input);
		
		List<Map<String,Object>> tables = (List<Map<String,Object>>) input.get("tables");
		List<Map<String,Object>> wheres = (List<Map<String,Object>>) input.get("wheres");
		List<Map<String,Object>> groups = (List<Map<String,Object>>) input.get("groups");
		List<Map<String,Object>> orders = (List<Map<String,Object>>) input.get("orders");
		
		
		String query = createQuery(tables,wheres,groups,orders);
		
		
		log.info(SQL_LINE + "query : {}" + SQL_LINE , query);		
		
		// 쿼리결과
		List<Map<String,Object>> resultList = queryMakerMapper.executeQuery(query);		
		
		log.info("executeQuery 종료");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("sql", query);
		resultMap.put("list", resultList);
		
		return resultMap;
	}
	
	private String createQuery(List<Map<String,Object>> tables, List<Map<String, Object>> wheres, List<Map<String,Object>> groups, List<Map<String, Object>> orders) {
		
		log.info("createQuery : {}", tables);
		
		StringBuffer sb = new StringBuffer();
		
		if(tables==null) {
			throw new ApiException(ErrorCode.QUERY_MAKER_TABLE_INVALIDATE);
		}
		
		// 테이블 조회 생성
		List<String> selectCols = new ArrayList<String>();
		for(Map<String,Object> table : tables) {
			
			log.info("table : {} " , table);
			
			Iterator<String> tableNameKey = table.keySet().iterator();
			
			// 조회 테이블명이 없을 경우 오류
			if(!tableNameKey.hasNext()) {
				throw new ApiException(ErrorCode.QUERY_MAKER_TABLE_INVALIDATE);
			}
			
			int index = 0;
			String stdTable = "";
			
			// select 절
			sb.append(SQL_SELECT_START);	
			
			// 컬럼 및 테이블 정의
			while(tableNameKey.hasNext()) {
				
				String tableName = tableNameKey.next();
				List<String> cols = (List<String>) table.get(tableName);
				
				// 조회 컬럼이 없을 경우 오류
				if(cols.isEmpty()) {
					throw new ApiException(ErrorCode.QUERY_MAKER_COLUMN_INVALIDATE);
				}			
						
				for(String col : cols) {
					selectCols.add(tableName+"."+col);				
				}				
				// TODO@KSM : 컬럼명에 그룹함수가 들어가는 상황이 고려되지 않았다.
				
				
				// 첫 번째 테이블을 기준테이블로 본다. TODO@KSM : 성능을 위해 INNER JOIN 등으로 바꾸려면 필요
				/*
				if(index==0) {
					stdTable = tableName;
					if(stdTable.isEmpty()) {
						throw new ApiException(ErrorCode.QUERY_MAKER_STD_TABLE_NOT_FOUND);
					}
					index++;
				}
				*/		
				
				stdTable+=tableName+",";
			}
			sb.append(listToCommaString(selectCols));		

			
			// from 절		
			sb.append(SQL_FROM_START);
			sb.append(stdTable);
			lastCommaDelete(sb);
			
			// where 절
			if(wheres!=null && !wheres.isEmpty()) {
				sb.append(SQL_WHERE_START);
				for(Map<String,Object> where : wheres) {
					
					String operator = (String)where.get("operator");
					String type = (String)where.get("type");										
					String leftCol = (String)where.get("leftCol");
					String rightCol = (String)where.get("rightCol");
					
					switch(operator) {
						case "and":
							sb.append("\nAND");
							break;
						case "or":
							sb.append("\nOR");
							break;
						default:
							throw new ApiException(ErrorCode.QUERY_MAKER_WHERE_INVALIDATE);					
					}
					
					switch(type) {
					case "eq":
						sb.append(" ");
						sb.append(leftCol);
						sb.append("=");
						sb.append(rightCol);
						break;
					case "ne":
						sb.append(" ");
						sb.append(leftCol);
						sb.append("!=");
						sb.append(rightCol);
						break;
					default:
						throw new ApiException(ErrorCode.QUERY_MAKER_WHERE_INVALIDATE);						
					}
					
					
				}
			}	
			
			// group by 절
			
			sb.append(SQL_GROUP_START);
			List<String> groupByCols = new ArrayList<String>();
			if(groups!=null && !groups.isEmpty()) {
				
				for(Map<String,Object> group : groups) {
						
					String groupCol = (String) group.get("col");	
					groupByCols.add(groupCol);	
					
					
					
				}
				
				log.info("groupByCols : {} " , groupByCols);
				
				for(String selectCol : selectCols) {
					
					log.info("selectCol : {} " , selectCol);

					if(!groupByCols.contains(selectCol)) {
						
						String agg = selectCol.trim().split("\\.")[1].substring(0, 3);
						// TODO@KSM : 컬럼명과 그룹함수명이 같다면?						
						
						if(!Arrays.asList(AGG_FUNC).contains(agg)) {
							throw new ApiException(ErrorCode.QUERY_MAKER_GROUP_COLUMN_NOT_MATCH);	
						}
						
					}					
					
				}				
				
				sb.append(listToCommaString(groupByCols));				
			}
				

			// order by 절
			sb.append(SQL_ORDER_START);
			if(orders!=null && !orders.isEmpty()) {
				for(Map<String,Object> order : orders) {
					
					String type = (String) order.get("type");
					String col = (String) order.get("col");
					
					sb.append(col);
					
					switch(type) {
					case "asc":
						sb.append(" " + "ASC,");
						break;
					case "desc":
						sb.append(" " + "DESC,");
						break;
					default:
						throw new ApiException(ErrorCode.QUERY_MAKER_WHERE_INVALIDATE);						
					}
					
				}
				lastCommaDelete(sb);
			}

			

			
		}
		
		return sb.toString(); 
	}
	
	private void inputParseLog(Map<String, Object> input) {

		StringBuffer sb = new StringBuffer();		
		sb.append(SQL_LINE);		
		sb.append("tables:"+input.get("tables")+"\n");
		sb.append("wheres:"+input.get("wheres")+"\n");
		sb.append("groups:"+input.get("groups")+"\n");
		sb.append("orders:"+input.get("orders")+"\n");
		sb.append(SQL_LINE);
		
		log.info(sb.toString());
		
	}
	
	private void lastCommaDelete(StringBuffer sb) {
		log.info("lastCommaDelete input {} " , sb);
		int lastCommaIndex = sb.lastIndexOf(",");
		if(lastCommaIndex != sb.length()-1) {
			log.warn("마지막 글자가 comma가 아님");
			return;
		}
				
		sb.deleteCharAt(lastCommaIndex);
		log.info("lastCommaDelete output {} " , sb);
	}
	
	private String listToCommaString(List<String> list) {
		int listSize = list.size();
		log.info("listToArray1 {} " , listSize);
		String[] array = new String[listSize];
		list.toArray(array);
        log.info("listToArray2 {} " , list);
//        list.toArray(array);
        log.info("listToArray3 {} " , array);
		return String.join(",", array);
	}

}
