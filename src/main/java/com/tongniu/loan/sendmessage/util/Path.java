package com.tongniu.loan.sendmessage.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Path {

	public static String sn = "8SDK-EMY-6699-RJSTN";// 软件序列号,请通过亿美销售人员获取
	public static String key = "183131";// 序列号首次激活时自己设定
	public static String password = "123456";// 密码,请通过亿美销售人员获取
	public static String baseUrl = "http://hprpt2.eucp.b2m.cn:8080/sdkproxy/";
	
	
	public static String registPath(){
		String url = baseUrl + "regist.action";
		String param = "cdkey=" + sn + "&password=" + password;
		url = url + "?" + param;
		System.out.println(url);
		return url;
	}
	public static String SMSPath(String phone,String message) throws UnsupportedEncodingException{
		message = URLEncoder.encode(message, "UTF-8");
		String url=baseUrl+"sendsms.action";
		String param = "cdkey=" + sn + "&password=" + password + "&phone=" + phone + "&message=" + message ;
		url = url + "?" + param;
		System.out.println(url);
		return url;
	}
	public static String SMStimerPath(String phone,String message,String dateStr1) throws UnsupportedEncodingException, ParseException{
		message = URLEncoder.encode(message, "UTF-8");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        Date date = dateFormat.parse(dateStr1); 
        long seqId=date.getTime();
		String url=baseUrl+"sendtimesms.action";
		String param = "cdkey=" + sn + "&password=" + password + "&phone=" + phone + "&message=" + message + "&seqid=" + seqId;
		url = url + "?" + param;
		System.out.println(url);
		return url;
	}
	public static String queryBalancePath(){
		String url = baseUrl + "querybalance.action";
		String param = "cdkey=" + sn + "&password=" + password;
		url = url + "?" + param;
		System.out.println(url);
		return url;
	}
	public static String logoutPath(){
		String url = baseUrl + "logout.action";
		String param = "cdkey=" + sn + "&password=" + password;
		url = url + "?" + param;
		System.out.println(url);
		return url;
	}
	public static String changePasswordPath(String  newpassword){
		String url = baseUrl + "changepassword.action";
		String param = "cdkey=" + sn + "&password=" + password+"&newpassword="+newpassword;
		url = url + "?" + param;
		return url;
	}
	public static String getmoPath(){
		String url=baseUrl + "getmo.action";
		String param = "cdkey=" + sn + "&password=" + password;
		url = url + "?" + param;
		return url;
	}
	public static String getReportPath(){
		String url=baseUrl+"getreport.action";
		String param = "cdkey=" + sn + "&password=" + password;
		url = url + "?" + param;
		return url;
	}
}
