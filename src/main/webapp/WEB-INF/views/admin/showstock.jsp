<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>股票买卖明细</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.5/demo/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/numFormat.js"></script>
<script type="text/javascript">
	$(function() {
		//linkUrl = $("#linkUrl").val();
		//alert(linkUrl);
		$("#showStockList_data")
				.datagrid(
						{
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							title : "股票购买记录",
							width : "1150px",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showStock/getAllShowSquaredataList",
							idField : 'id',
							singleSelect : true,//是否单选 
							pagination : true,//分页控件 
							rownumbers : true,//行号  
							//fitColumns:true,
							remoteSort : false,
							// minimizable:false,
							//  maximizable:false,   
							// collapsible:false,
							columns : [ [ {
								field : 'cust_name',
								title : '客户名称',
								width : 100,
								align:'center', 
							}, {
								field : 'fund_acct',
								title : '资金账户',
								width : 100,
								align:'center', 
							}, {
								field : 'stock_code',
								title : '股票代码',
								width : 100,
								align:'center', 
							}, {
								field : 'stock_name',
								title : '股票名称',
								width : 100,
								align:'center', 
							}, {
								field : 'seid_id',
								title : '市场编号',
								width : 100,
								align:'center', 
							}, {
								field : 'seid_name',
								title : '市场名称',
								width : 100,
								align:'center', 
							}, {
								field : 'sl',
								title : '购买数量',
								width : 100,
								align:'center', 
							}, {
								field : 'now_price',
								title : '买入价格',
								width : 100,
								align:'center',
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
								
							}, {
								field : 'bz',
								title : '备注',
								width : 100,
								align:'center', 
							},  {
								field:'trade_date',
								title : '购买日期',
								width : 100,
								align:'center', 
								
							}] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar"

						});

		var p = $('#showStockList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	
	function doSearch(value){
		//alert(value);
		if(value!=null) {
			$("#param").attr("value",value);
		}else{
			value=$("#param").val();
		}
		//alert(value);
		var flag=$($('input:radio[name=choose]:checked')).val();
		if(flag==1){
			var url=value.length==0?"${pageContext.request.contextPath}/admin/showStock/getAllShowSquaredataList":
				"${pageContext.request.contextPath}/admin/showStock/searchShowSquaredata?cust_name="+value;
				//alert(url);
			$("#showStockList_data")
			.datagrid(
					{

						title : "股票购买记录",
						width : "1150px",
						height : "auto",
						nowrap : false,
						striped : true,
						border : true,
						collapsible : false,//是否可折叠的 
						url : url,
						idField : 'id',
						singleSelect : true,//是否单选 
						pagination : true,//分页控件 
						rownumbers : true,//行号  
						//fitColumns:true,
						remoteSort : false,
						// minimizable:false,
						//  maximizable:false,   
						// collapsible:false,
						columns : [ [ {
							field : 'cust_name',
							title : '客户名称',
							width : 100,
							align:'center', 
						}, {
							field : 'fund_acct',
							title : '资金账户',
							width : 100,
							align:'center', 
						}, {
							field : 'stock_code',
							title : '股票代码',
							width : 100,
							align:'center', 
						}, {
							field : 'stock_name',
							title : '股票名称',
							width : 100,
							align:'center', 
						}, {
							field : 'seid_id',
							title : '市场编号',
							width : 100,
							align:'center', 
						}, {
							field : 'seid_name',
							title : '市场名称',
							width : 100
						}, {
							field : 'sl',
							title : '购买数量',
							width : 100,
							align:'center', 
						}, {
							field : 'now_price',
							title : '买入价格',
							width : 100,
							align:'center', 
							formatter : function(
									value) {

								return numFormat(value)
										+ "元";
							}
						}, {
							field : 'bz',
							title : '备注',
							width : 100,
							align:'center', 
						},  {
							field:'trade_date',
							title : '购买日期',
							width : 100,
							align:'center', 
							
						}] ],
						//toolbar : "#toolbar"
						toolbar : "#toolbar",
						pageSize : 50,//每页显示的记录条数，默认为10 
						pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
						
					});

	var p = $('#showStockList_data').datagrid('getPager');
	$(p).pagination({
		//pageSize : 10,//每页显示的记录条数，默认为10 
		//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
		beforePageText : '第',//页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

	});	
		}
		else{
			
			var url=value.length==0?"${pageContext.request.contextPath}/admin/showStock/getAllShowStockamountList":
				"${pageContext.request.contextPath}/admin/showStock/searchShowStockamountCount?cust_name="+value;
				//alert(url);
			$("#showStockList_data")
			.datagrid(
					{

						title : "股票汇总记录",
						width : "1150px",
						height : "auto",
						nowrap : false,
						striped : true,
						border : true,
						collapsible : false,//是否可折叠的 
						url : url,
						idField : 'id',
						singleSelect : true,//是否单选 
						pagination : true,//分页控件 
						rownumbers : true,//行号  
						//fitColumns:true,
						remoteSort : false,
						// minimizable:false,
						//  maximizable:false,   
						// collapsible:false,
						columns : [ [ {
							field : 'cust_name',
							title : '客户名称',
							width : 100,
							align:'center', 
						}, {
							field : 'fund_acct',
							title : '资金账户',
							width : 100,
							align:'center', 
						}, {
							field : 'stock_code',
							title : '股票代码',
							width : 100,
							align:'center', 
						}, {
							field : 'stock_name',
							title : '股票名称',
							width : 100,
							align:'center', 
						}, {
							field : 'seid_id',
							title : '市场编号',
							width : 100,
							align:'center', 
						}, {
							field : 'seid_name',
							title : '市场名称',
							width : 100,
							align:'center', 
						}, {
							field : 'balance',
							title : '购买总数',
							width : 100,
							align:'center', 
						}] ],
						//toolbar : "#toolbar"
						toolbar : "#toolbar",
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
					});

	var p = $('#showStockList_data').datagrid('getPager');
	$(p).pagination({
		//pageSize : 10,//每页显示的记录条数，默认为10 
		//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
		beforePageText : '第',//页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

	});	
			
			
		}

		
		
	}
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="showStockList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'输入客户名称搜索'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
				<input type="radio" value="1" name="choose" onchange="doSearch(null)" checked="checked"  />股票购买记录
				<input type="radio" value="2" name="choose" onchange="doSearch(null)" />股票持有汇总


		</div>

	</div>
</body>
</html>