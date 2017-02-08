package com.tongniu.loan.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tongniu.loan.business.domain.Squaredata;
import com.tongniu.loan.business.service.SquaredataService;
import com.tongniu.loan.business.service.StockamountService;
import com.tongniu.loan.business.service.TstockinfoService;
import com.tongniu.loan.view.service.ShowTfundacctService;

@Controller
@RequestMapping(value = "/admin/capitaloperation")
public class CapitalOpreationController {
	
	@Resource
	private SquaredataService squaredataService;
	/**
	 * 操作资金记录
	 */
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	@ResponseBody
	public String buy(Squaredata squaredata, ModelMap map) {
		squaredata.setType(113200);
		squaredata.setOccurrence_fund(squaredata.getSl()*squaredata.getNow_price());
		squaredata.setBz("买入");
		map.put("isBuyd", squaredataService.addSquaredata(squaredata));
		return JSON.toJSONString(map).toString();
	}
	
	
	
	
	
	
	
	
	@Resource
	private ShowTfundacctService showTfundacctService;
	
	
	@RequestMapping(value="/getAllShowTfundacctList")
	@ResponseBody
	public String getAllShowTfundacctList(){
		return JSON.toJSONString(showTfundacctService.getAllShowTfundacctList());
	}
	
	@RequestMapping(value="/getAllShowTfundacctList2")
	@ResponseBody
	public String getAllShowTfundacctList2(){
		System.out.println(showTfundacctService.getAllShowTfundacctList2().size());
		return JSON.toJSONString(showTfundacctService.getAllShowTfundacctList2());
	}
	
	@RequestMapping(value = "/buystock")
	public String buystock() {
		return "admin/buystock";
	}
	
	
	
	@Resource
	private TstockinfoService tstockinfoService;
	
	@RequestMapping(value="/getAllTstockinfo")
	@ResponseBody
	public String getAllTstockinfo(){
		return JSON.toJSONString(tstockinfoService.getAllTstockinfo());
		
	}
	
	@Resource
	private StockamountService stockamountService;
	
	@RequestMapping(value="/getStockamountListByFund_id")
	@ResponseBody
	public String getStockamountListByFund_id(Integer fund_id){
		return JSON.toJSONString(stockamountService.getStockamountListByFund_id(fund_id));
	}
	
	
	
	/**
	 * 卖出
	 */
	@RequestMapping(value = "/sale", method = RequestMethod.POST)
	@ResponseBody
	public String sale(Squaredata squaredata, ModelMap map) {
		squaredata.setType(113298);
		System.out.println(squaredata.getSl());
		System.out.println(squaredata.getNow_price());
		squaredata.setOccurrence_fund(squaredata.getSl()*squaredata.getNow_price());
		squaredata.setBz("卖出");
		map.put("isSaled", squaredataService.addSquaredata(squaredata));
		return JSON.toJSONString(map).toString();
	}
	
	
	
	/**
	 * 划拨
	 * */
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	@ResponseBody
	public String record(Squaredata squaredata,ModelMap map){
		squaredata.setTrade_date(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())));
		map.put("isRecorded", squaredataService.addSquaredata(squaredata));
		return JSON.toJSONString(map).toString();
	}
	
	
	
	
	
	
	
}
