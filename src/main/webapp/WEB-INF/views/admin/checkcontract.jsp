<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户合同审核</title>
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
		$("#showContractList_data")
				.datagrid(
						{
							 pageSize : 50,//每页显示的记录条数，默认为10 
								pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							title : "合同信息",
							width : "auto",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showContract/getAllShowContractList",
							idField : 'id',
							singleSelect : true,//是否单选 
							pagination : true,//分页控件 
							rownumbers : true,//行号  
							//fitColumns:true,
							remoteSort : false,
							// minimizable:false,
							//  maximizable:false,   
							// collapsible:false,
							columns : [ [
									{
										field : 'contract_no',
										title : '合同编号',
										width : 100,
										align : 'center',
									},
									{
										field : 'user',
										title : '出资方',
										width : 100,
										align : 'center',
									},
									{
										field : 'cust',
										title : '借款方',
										width : 100,
										align : 'center',
									},
									{
										field : 'contract_money',
										title : '借款金额',
										width : 200,
										align : 'center',
										formatter : function(
												value) {

											return numFormat(value)
													+ "元";
										}
									},
									{
										field : 'earnest_money',
										title : '保证金',
										width : 200,
										align : 'center',
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									},
									{
										field : 'sum_money',
										title : '总金额',
										width : 200,
										align : 'center',
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									},
									{
										field : 'sign_date',
										title : '签署日期',
										width : 100,
										align : 'center',
									},
									{
										field : 'start_date',
										title : '开始日期',
										width : 100,
										align : 'center',
									},
									{
										field : 'end_date',
										title : '结束日期',
										width : 100,
										align : 'center',
									},
									{
										field : 'investment_rate',
										title : '投资利率',
										width : 100,
										align : 'center',
										formatter : function(
												value) {
											return parseFloat(
													value * 100)
													.toFixed(2)
													+ '%';
										}
										
									},
									{
										field : 'states',
										title : '合同状态',
										width : 100,
										align : 'center',
										formatter : function(value) {
											if (value == 0) {
												return "未审核";
											}
											if (value == 1) {
												return "已审核";
											}
											if (value == 2) {
												return "投资中";
											}
											if (value == 3) {
												return "合同结清";
											}
											if (value == 4) {
												return "已作废";
											}
											if (value == 5) {
												return "待回款";
											}
											if (value == 6) {
												return "已回款";
											}
										}
									},
									{
										field : 'invest_gain',
										title : '预期收益',
										width : 200,
										align : 'center',
										formatter : function(
												value) {

											return numFormat(value)
													+ "元";
										}
									},
									{
										field : 'sum_gain',
										title : '累计收益',
										width : 200,
										align : 'center',
										formatter : function(
												value) {

											return numFormat(value)
													+ "元";
										}
									},
									{
										field : 'check_name',
										title : '审核人',
										width : 100,
										align : 'center',
									},
									{
										field : 'check_time',
										title : '审核时间',
										width : 100,
										align : 'center',
									},
									{
										field : 'fund_id',
										title : '资金账户ID',
										width : 100,
										align : 'center',
									},
									{
										field : 'fund_acc',
										title : '资金账户',
										width : 100,
										align : 'center',
									},
									{
										field : 'investment_account_no',
										title : '投资账户编号',
										width : 100,
										align : 'center',
									},
									{
										field : 'operate',
										title : '操作',
										width : 200,
										align : 'center',
										formatter : function(value, row, index) {
											var str = "";
											if (row.states == 0) {
												str+="<select>";
												str += "<option value='1' >审核</option>";
												str += "<option value='3' disabled=''>合同结清</option>";
												str += "<option value='4'>作废</option>";

											} else if (row.states == 1||row.states==2) {
												return "已审核";
											} else if (row.states == 3) {
												return "合同结清";
											} else if (row.states == 4) {
												return "已作废";
											} else if (row.states == 5) {
											
												str+="<select>";
												str += "<option value='6' >合同结清</option>";
												str += "<option value='7' >回款撤销</option>";
											} else if (row.states == 6) {
												return "已回款";
											}
											str += "</select>";
											str += "<input type='hidden' value='"+row.contract_no+"' />";
											str += "<input type='button' value='保存' onclick='changeState(this)'/>"
											//alert(str);
											return str;

										}
									} ] ],

							onLoadSuccess : function(data, row, index) {
								//alert(index);
								// $("select").combobox({plain:true}); 

							},
							//toolbar:"#toolbar",

						});

		var p = $('#showContractList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function changeState(ele) {
		var contract_no = ($($(ele).prev()).val());
		var states = ($($(ele).prev().prev()).val());
		/* var contract_money= $($(ele).prev().prev().prev()).val();
		var fund_id= $($(ele).prev().prev().prev().prev()).val(); */
		
		/* alert(contract_no);
		alert(states);
		alert(contract_money);
		alert(fund_id);
		return; */
		$
				.ajax({
					url : "${pageContext.request.contextPath}/admin/contract/checkContract",
					type : "post",
					dataType : "json",
					data : {
						"contract_no" : contract_no,
						"states" : states
					},
					success : function(result) {
						if (result.msg) {
							$.messager.alert('提示信息',"操作成功");
							$("#showContractList_data").datagrid("reload");
						}

					}

				})
	}
</script>


</head>
<body>

	<input type="hidden" id="param" value="" />
	<table id="showContractList_data" align="center">

	</table>


</body>
</html>