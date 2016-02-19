package com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utils.DataUtils;

@Controller
public class NewsServer {

	@RequestMapping("/news")
	public String news(){
		String httpUrl = "http://apis.baidu.com/txapi/health/health";
		String httpArg = "num=10&page=1";
		
		DataUtils util = new DataUtils();
		String msg = util.request(httpUrl, httpArg);
		System.out.println(msg);
		
		return null;
	}
	
	
	
}
