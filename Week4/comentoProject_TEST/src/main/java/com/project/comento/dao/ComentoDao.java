package com.project.comento.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.comento.dao.mapper.ComentoMapper;
import com.project.comento.model.ComentoDetailModel;
import com.project.comento.model.ComentoListModel;
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
	
	public List getCode30(String market) {
		List<ComentoListModel> list = (List<ComentoListModel>) mapper.getCode30(market);
		return list;
	}
	
	public ComentoDetailModel getCodeDetail(String code,String market) {
		ComentoDetailModel data = mapper.getCodeDetail(code,market);
		return data;
	}
	
	public ComentoDetailModel getMaxRoe(String market) {
		ComentoDetailModel data = mapper.getMaxRoe(market);
		return data;
	}
}
