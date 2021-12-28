package com.project.comento.dao.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.project.comento.model.ComentoModel;

@Mapper
public interface ComentoMapper {

	@Select("select code,thema_name from stock_info where \n"
			+ "code = (Select code from stock_kospi where code_name = #{codeName})")
	public ComentoModel getThemaName(String codeName);	
}
