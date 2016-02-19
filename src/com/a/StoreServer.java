package com.a;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utils.DataUtils;

@Controller
public class StoreServer {

	
	
	
	@RequestMapping("/storeLocation")
	public String location(@RequestParam(value="name")String text)throws Exception{
		System.out.println(text);
		String httpUrl = "http://apis.baidu.com/tngou/store/location";
		String httpArg = "x=112.207&y=22.470&page=1&rows=20";
		
		DataUtils util = new DataUtils();
		String msg = util.request(httpUrl, httpArg);
		System.out.println(msg);
		
		
		return null;
	}
	
	
	
	
}
