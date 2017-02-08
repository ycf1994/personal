package com.tongniu.loan.sendmessage.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Parse {
	static Logger logger = Logger.getLogger(Parse.class);
	//解析响应号码
	public static String xmlResponseForRegist(String response){
		String root="失败";
		Document document=null;
		try {
			document=DocumentHelper.parseText(response);
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
			return "-1";
		}
		 root = document.getRootElement().elementText("message");
		
		return root;
	}
	//解析响应文件
	public static  String xmlResponseForSMS(String response){
		String root="失败";
		Document document=null;
		try {
			document=DocumentHelper.parseText(response);
			
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}
		 root = document.getRootElement().elementText("error");
		
		return root;
	}
	//解析mo
	public static List<Mo> xmlResponseForMo(String responseString){
		List<Mo> Mos = new ArrayList<Mo>();
		List<Element> elements = xmlDoc(responseString);
		for (Element element : elements) {
			if (null != element) {
				logger.debug("【SDKHttpClient】上行请求->" + responseString);
				Mo mo = new Mo();
				mo.setMobileNumber(element.elementText("srctermid"));
				mo.setSmsContent(element.elementText("msgcontent"));
				mo.setAddSerial(element.elementText("addSerial"));
				mo.setAddSerialRev(element.elementText("addSerialRev"));
				mo.setSentTime(element.elementText("sendTime"));
				Mos.add(mo);
			}
		}
		
		return Mos;
	}
	//解析状态
	public static List<StatusReport> xmlResponseForStatus(String responseString){
		List<StatusReport> reports = new ArrayList<StatusReport>();
		List<Element> elements = xmlDoc(responseString);
		for (Element element : elements) {
			if (null != element) {
				logger.debug("【SDKHttpClient】上行请求->" + responseString);
				StatusReport report = new StatusReport();
				report.setMobile(element.elementText("srctermid"));
				report.setErrorCode(element.elementText("state"));
				report.setSeqID(Long.parseLong(element.elementText("seqid")));
				report.setReceiveDate(element.elementText("receiveDate"));
				report.setSubmitDate(element.elementText("submitDate"));
				report.setServiceCodeAdd(element.elementText("addSerialRev"));
				reports.add(report);
			}
		}
		
		return reports;
	}
	// 解析状态、上行
	private static List<Element> xmlDoc(String response) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(response);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		List<Element> list = root.elements();
		List<Element> elemets = new ArrayList<Element>();
		// 增强for循环来遍历所有的U8ArrivalVouch节点
		for (Element element : list) {
			String message = element.getName();
			if ("message".equalsIgnoreCase(message)) {
				if (element.elements().size() > 0) {
					elemets.add(element);
				}
			}

		}
		return elemets;
	}
}
