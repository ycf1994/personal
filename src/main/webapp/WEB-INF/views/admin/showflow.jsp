<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户资金流水</title>
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
		$("#showFlowList_data")
				.datagrid(
						{
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							title : "用户资金流水信息",
							width : "1150px",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showFlow/getAllShowFlowList",
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
								field : 'id',
								title : '系统编号',
								width : 100,
								align:'center', 
							}, {
								field : 'deal_no',
								title : '流水编号',
								width : 100,
								align:'center', 
							}, {
								field : 'user_id',
								title : '用户编号',
								width : 100,
								align:'center', 
							}, {
								field : 'username',
								title : '用户名',
								width : 100,
								align:'center', 
							}, {
								field : 'realname',
								title : '真实姓名',
								width : 100,
								align:'center', 
							}, {
								field : 'money',
								title : '金额',
								width : 200,
								align:'center', 
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'input_time',
								title : '交易时间',
								width : 100,
								align:'center', 
							}, {
								field : 'transferred_time',
								title : '到账时间',
								width : 100,
								align:'center', 
							}, {
								field : 'flag',
								title : '交易类型',
								width : 100,
								align:'center', 
								formatter : function(value) {
									if (value == 111001) {
										return "资金入账";
									}
									if (value ==111006) {
										return "提现";
									}
									if (value == 111004) {
										return "活期利息";
									}
									if (value == 111005) {
										return "投资利息";
									}
									if (value == 111002) {
										return "投资合同打款 ";
									}
									if (value == 111003) {
										return "投资金额返还";
									}
									
								}
							},  {
								field:'bz',
								title : '备注',
								width : 300,
								align:'center', 
								formatter : function(value, row, index) {
									if(row.flag==1 || row.flag==2)
										return row.bank_name+":"+row.bank_card;
									
									
								}
							}] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar"

						});

		var p = $('#showFlowList_data').datagrid('getPager');
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
		var flag=$($('input:radio[name=choose]:checked')).val();
		//alert(flag);
		if(value!=null){
			$("#param").attr("value",value);
			
		}else{
			value=$("#param").val();
		}
		
		$("#showFlowList_data")
		.datagrid(
				{

					title : "用户资金流水信息",
					width : "1150px",
					height : "auto",
					nowrap : false,
					striped : true,
					border : true,
					collapsible : false,//是否可折叠的 
					url : "${pageContext.request.contextPath}/admin/showFlow/searchShowFlow?flag="+flag+"&value="+value,
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
								field : 'id',
								title : '系统编号',
								width : 100,
								align:'center', 
							}, {
								field : 'deal_no',
								title : '流水编号',
								width : 100,
								align:'center', 
							}, {
								field : 'user_id',
								title : '用户编号',
								width : 100,
								align:'center', 
							}, {
								field : 'username',
								title : '用户名',
								width : 100,
								align:'center', 
							}, {
								field : 'realname',
								title : '真实姓名',
								width : 100,
								align:'center', 
							}, {
								field : 'money',
								title : '金额',
								width : 200,
								align:'center', 
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'input_time',
								title : '交易时间',
								width : 100,
								align:'center', 
							}, {
								field : 'transferred_time',
								title : '到账时间',
								width : 100,
								align:'center', 
							}, {
								field : 'flag',
								title : '交易类型',
								width : 100,
								align:'center', 
								formatter : function(value) {
									if (value == 111001) {
										return "资金入账";
									}
									if (value ==111006) {
										return "提现";
									}
									if (value == 111004) {
										return "活期利息";
									}
									if (value == 111005) {
										return "投资利息";
									}
									if (value == 111002) {
										return "投资合同打款 ";
									}
									if (value == 111003) {
										return "投资金额返还";
									}
									
								}
							},  {
								field:'bz',
								title : '备注',
								width : 300,
								align:'center', 
								formatter : function(value, row, index) {
									if(row.flag==1 )
										return row.bank_name+":"+row.bank_card;
									
									
								}
							}] ],
					//toolbar : "#toolbar"
					toolbar : "#toolbar",
						pageSize : 50,//每页显示的记录条数，默认为10 
						pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
				});

var p = $('#showFlowList_data').datagrid('getPager');
$(p).pagination({
	//pageSize : 10,//每页显示的记录条数，默认为10 
	//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

});
		
		
	}
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="showFlowList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'输入姓名或者用户名搜索'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
				<input type="radio" value="111001" name="choose" onchange="doSearch(null)"  />资金入账
				<input type="radio" value="111006" name="choose" onchange="doSearch(null)" />提现
				<input type="radio" value="111004" name="choose" onchange="doSearch(null)" />活期利息
				<input type="radio" value="111005" name="choose" onchange="doSearch(null)" />投资利息
				<input type="radio" value="111002" name="choose" onchange="doSearch(null)" />投资合同打款
				<input type="radio" value="111003" name="choose" onchange="doSearch(null)" />投资合同返款
				<input type="radio" value="0" name="choose" onchange="doSearch(null)" checked="checked" />全部
		</div>

	</div>
</body>
</html>