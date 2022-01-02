package com.project.comento.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.comento.dao.mapper.ComentoMapper;
import com.project.comento.model.ComentoModel;

@Component
public class ComentoDao {

	@Autowired
	ComentoMapper mapper;

	public ComentoModel getThemaName(String codeName) {
		ComentoModel data = mapper.getThemaName(codeName);
		return data;
	}
	
	public ComentoModel getMarketSum(String market) {
		ComentoModel data = mapper.getMarketSum(market);
		return data;
	}
	
	public ComentoModel getCode30(String market) {
		ComentoModel data = mapper.getCode30(market);
		return data;
	}
	
	public ComentoModel getCodeDetail(String code,String market) {
		ComentoModel data = mapper.getCodeDetail(code, market);
		return data;
	}
	
	public ComentoModel getMaxRoe(String market) {
		ComentoModel data = mapper.getMaxRoe(market);
		return data;
	}
}
