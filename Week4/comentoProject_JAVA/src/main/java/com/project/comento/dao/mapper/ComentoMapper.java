package com.project.comento.dao.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.project.comento.model.ComentoDetailModel;
import com.project.comento.model.ComentoListModel;
import com.project.comento.model.ComentoModel;

@Mapper
public interface ComentoMapper {

	@Select("select code,thema_name from stock_info where \n"
			+ "code = (Select code from stock_kospi where code_name = #{codeName})")
	public ComentoModel getThemaName(String codeName);
	
	@Select("select sum(market_cap) market_cap from stock_finance a where \n"
			+ "	code in (select code from stock_info where stock_market = #{market})\n"
			+ "	and date = '20210107'\n"
			+ "	order by market_cap desc\n"
			+ "	limit 5;")
	public ComentoModel getMarketSum(String market);
	
	@Select("select code, (select code_name from stock_kosdaq s where s.code = a.code) code_name from stock_finance a where \n"
			+ "	code in (select code from stock_info where stock_market = #{market})\n"
			+ "	and date = '20210107'\n"
			+ "	order by market_cap desc\n"
			+ "	limit 30;")
	public List<ComentoListModel> getCode30(String market);
	
	@Select("select code,\n"
			+ "       (select code_name from stock_kosdaq s where s.code = a.code) code_name,\n"
			+ "       (select thema_name from stock_info s where s.code = a.code) thema_name,\n"
			+ "       sub_price,\n"
			+ "       ROE,\n"
			+ "       PER\n"
			+ "from stock_finance a \n"
			+ "where code = #{code} \n"
			+ "AND date = '20210107';")
	public ComentoDetailModel getCodeDetail(String code,String market);
	
	@Select("select code,\n"
			+ "       (select code_name from stock_kospi s where s.code = a.code) code_name,\n"
			+ "       (select thema_name from stock_info s where s.code = a.code) thema_name,\n"
			+ "       sub_price,\n"
			+ "       MAX(ROE) AS ROE,\n"
			+ "       PER \n"
			+ "from stock_finance a\n"
			+ "where date = '20210107';")
	public ComentoDetailModel getMaxRoe(String market);	
	
}
