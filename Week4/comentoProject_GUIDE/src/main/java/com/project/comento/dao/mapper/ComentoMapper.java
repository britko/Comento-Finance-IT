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

	@Select("select sum(market_cap) from stock_finance where \n"
			+ "code in (select code from stock_info where stock_market = #{market}) \n"
			+ "and date='20210107' \n"
			+ "order by market_cap desc \n"
			+ "limit 5;")
	public ComentoModel getMarketSum(String market);

	@Select("select code, code_name from stock_finance where \n"
			+ "code in (select code from stock_info where stock_market = #{market}) \n"
			+ "and date='20210107' \n"
			+ "order by code desc \n"
			+ "limit 30;")
	public ComentoModel getCode30(String market);

	@Select("select code, code_name, thema_name, sub_price, ROE, PER from stock_finance where \n"
			+ "code in (select code from stock_info where stock_market = #{market}) \n"
			+ "and code = #{code}")
	public ComentoModel getCodeDetail(String code,String market);

	@Select("select code, code_name, thema_name, sub_price, ROE from stock_finance where \n"
			+ "code in (select code from stock_info where stock_market = #{market}) \n"
			+ "and date='20210107' \n"
			+ "order by ROE desc \n"
			+ "limit 1;")
	public ComentoModel getMaxRoe(String market);

}
