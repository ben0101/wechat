package com.a;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utils.CheckSignature;

@Controller
public class Check {

	@RequestMapping(value = "/check", produces = "text/html,charset=UTF-8")
	@ResponseBody
	public String check(@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp, @RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "echostr") String echostr) throws NoSuchAlgorithmException {

		String TOKEN = "SSS";
		boolean isCorrect = CheckSignature.isCorrect(signature, timestamp, nonce, TOKEN);
		if (isCorrect) {
			return echostr;
		}
		return "";
	}

	@RequestMapping(value = "/req", produces = "text/html,charset=UTF-8")
	public String getReqData(HttpServletRequest req) throws IOException {
		String ToUserName="";
		String FromUserName="";
		String CreateTime="";
		String MsgType="";
		String Content="";
		String MsgId="";
		
		ServletInputStream is = req.getInputStream();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(is);
			Element root = document.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();
				
				if("ToUserName".equals(element.getName())){
					ToUserName=element.getText().trim();
				}else if("FromUserName".equals(element.getName())){
					FromUserName=element.getText().trim();
				}else if("CreateTime".equals(element.getName())){
					CreateTime=element.getText().trim();
				}else if("MsgType".equals(element.getName())){
					MsgType=element.getText().trim();
				}else if("Content".equals(element.getName())){
					Content=element.getText().trim();
				}else if("MsgId".equals(element.getName())){
					MsgId=element.getText().trim();
				}
			}
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
		
		//信息类型
		if("text".equals(MsgType)){
			
		}
		
		if("开灯".equals(Content)){
			
		}else if("关灯".equals(Content)){
			
		}else if("温度".equals(Content)){
			
		}
		
		//返回xml
		/*StringBuffer str = new StringBuffer();  
        str.append("<xml>");  
        str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");  
        str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");  
        str.append("<CreateTime>" + returnTime + "</CreateTime>");  
        str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");  
        str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");  
        str.append("</xml>");  */
		
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("xml");
		
		Element eleUserName = root.addElement("ToUserName");
		eleUserName.setText("xx");
		
		
		return null;
	}
	@RequestMapping
	public String update(@RequestParam("data")String data,@RequestParam("token")String token){
		
		if(data !=null && "2".equals(token)){
			
		}
		
		return null;
	}
	

}
