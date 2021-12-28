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
	
	public void getMarketSum(String market) {
	}
	
	public void getCode30(String market) {
	}
	
	public void getCodeDetail(String code,String market) {
	}
	
	public void getMaxRoe(String market) {
	}
}
