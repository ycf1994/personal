package com.tongniu.loan.sendmessage.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;

public class SMSSent  {

	public static String service(String phone,String message) throws UnsupportedEncodingException{
		String url= Path.SMSPath(phone, message);
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset("utf-8");
		String responseString=HttpClientUtil.getInstance().doGetRequest(url).trim();
		String response=Parse.xmlResponseForSMS(responseString);
		return response;
	}

	public static boolean sendCode(String phone,String code){
		String str="验证码CODE，您正在进行密码重置，5分钟内有效，打死不要告诉别人哦！";
		try {
			return "0".equals(service(phone, str.replace("CODE", code)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}



	
}

