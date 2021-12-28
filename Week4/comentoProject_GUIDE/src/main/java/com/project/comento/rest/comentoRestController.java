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
		HashMap<String, Object> resultData = new HashMap<>();
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/30", produces = "application/json")
	public HashMap getCode30(@RequestParam String market) {	
		HashMap<String, Object> resultData = new HashMap<>();
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/detail", produces = "application/json")
	public HashMap getCodeDetail(@RequestParam String code,String market) {
		HashMap<String, Object> resultData = new HashMap<>();
		return resultData;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/code/maxRoe", produces = "application/json")
	public HashMap getMaxRoe(@RequestParam String market) {
		HashMap<String, Object> resultData = new HashMap<>();
		return resultData;
	}
}
