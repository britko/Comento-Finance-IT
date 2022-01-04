package com.project.comento.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.comento.dao.ComentoDao;
import com.project.comento.model.ComentoDetailModel;
import com.project.comento.model.ComentoListModel;
import com.project.comento.model.ComentoModel;

@RestController
@RequestMapping("/comento/biz")
public class comentoRestController {

	@Autowired
	ComentoDao ComentoDao;

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String sayHello() {
		return "Hello World!";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/code/theme", produces = "application/json")
	public HashMap getThemaName(@RequestParam String codeName) {
		ComentoModel data = ComentoDao.getThemaName(codeName);
		HashMap<String, Object> resultData = new HashMap<>();
		resultData.put("result", "sucess");
		resultData.put("description", "sucess");
		resultData.put("theme_name", data.getThema_name());
		return resultData;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/marketcap/sum", produces = "application/json")
	public HashMap getMarketSum(@RequestParam String market) {
		ComentoModel data = ComentoDao.getMarketSum(market);
		HashMap<String, Object> resultData = new HashMap<>();
		resultData.put("result", "sucess");
		resultData.put("description", "sucess");
		resultData.put("marketCapSum", data.getMarket_cap());
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/30", produces = "application/json")
	public HashMap getCode30(@RequestParam String market) {
		List<ComentoListModel> list = ComentoDao.getCode30(market);
		HashMap<String, Object> resultData = new HashMap<>();
		resultData.put("result", "sucess");
		resultData.put("description", "sucess");
		resultData.put("codeList", list);
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/detail", produces = "application/json")
	public HashMap getCodeDetail(@RequestParam String code,String market) {
		ComentoDetailModel data = ComentoDao.getCodeDetail(code,market);
		HashMap<String, Object> resultData = new HashMap<>();
		resultData.put("result", "sucess");
		resultData.put("description", "sucess");
		resultData.put("code", data.getCode());
		resultData.put("code_name", data.getCode_name());
		resultData.put("thema_name", data.getThema_name());
		resultData.put("sub_price", data.getSub_price());
		resultData.put("ROE", data.getROE());
		resultData.put("PER", data.getPER());
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/maxRoe", produces = "application/json")
	public HashMap getMaxRoe(@RequestParam String market) {
		ComentoDetailModel data = ComentoDao.getMaxRoe(market);
		HashMap<String, Object> resultData = new HashMap<>();
		resultData.put("result", "sucess");
		resultData.put("description", "sucess");
		resultData.put("code", data.getCode());
		resultData.put("code_name", data.getCode_name());
		resultData.put("thema_name", data.getThema_name());
		resultData.put("sub_price", data.getSub_price());
		resultData.put("ROE", data.getROE());
		return resultData;
	}
}
