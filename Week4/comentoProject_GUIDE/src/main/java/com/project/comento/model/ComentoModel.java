package com.project.comento.model;

import java.util.List;

public class ComentoModel {
	String code;
	String thema_name;
    String market_cap;
    List codeList;

	public String getMarket_cap() {
		return market_cap;
	}

	public void setMarket_cap(String market_cap) {
		this.market_cap = market_cap;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getThemaName() {
		return thema_name;
	}

	public void setThemaName(String thema_name) {
		this.thema_name = thema_name;
	}

	public String getThema_name() {
		return thema_name;
	}

	public void setThema_name(String thema_name) {
		this.thema_name = thema_name;
	}

	public List getCodeList() {
		return codeList;
	}

	public void setCodeList(List codeList) {
		this.codeList = codeList;
	}
}
