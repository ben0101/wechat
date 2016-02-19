package com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utils.DataUtils;

@Controller
public class HospitalServer {

	@RequestMapping("/hospitalLocation")
	public String location()throws Exception{
		String httpUrl = "http://apis.baidu.com/tngou/hospital/location";
		String httpArg = "x=112.207&y=22.470&page=1&rows=20";
		
		DataUtils util = new DataUtils();
		String msg = util.request(httpUrl, httpArg);
		System.out.println(msg);
		
		
		return null;
	}
	
}
