<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/datagrid-detailview.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/numFormat.js"></script>

<script type="text/javascript">
	$(function() {
		$("#showAccountList_data")
				.datagrid(

						{
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							onExpandRow : function(index, row) {

								var ddv = $(this).datagrid('getRowDetail',
										index).find('table#ddv-' + index);
								ddv
										.datagrid({
											pageSize : 50,//每页显示的记录条数，默认为10 
											pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
											title : "入账明细",
											width : "100%",
											height : "auto",
											url : "${pageContext.request.contextPath}/admin/showInvestment_account/searchShowInvestment_account?value="
													+ row.username,

											singleSelect : true,//是否单选 
											pagination : true,//分页控件 
											rownumbers : true,//行号  

											columns : [ [
													{
														field : 'investment_account_no',
														title : '资金编号',
														width : 110,
														align : 'center',
													},
													{
														field : 'username',
														title : '用户名',
														width : 100,
														align : 'center',
													},
													{
														field : 'realname',
														title : '真实姓名',
														width : 100,
														align : 'center',
													},
													{
														field : 'idno',
														title : '身份证号',
														width : 160,
														align : 'center',
													},
													{
														field : 'money',
														title : '入账金额',
														width : 200,
														align : 'center',
														formatter : function(
																value) {

															return numFormat(value)
																	+ "元";
														}
													},
													{
														field : 'balance',
														title : '余额',
														width : 100,
														align : 'center',
														formatter : function(
																value) {

															return numFormat(value)
																	+ "元";
														}

													},
													{
														field : 'interest_rate',
														title : '活期利率',
														width : 100,
														align : 'center',
														formatter : function(
																value) {
															return parseFloat(
																	value * 100)
																	.toFixed(2)
																	+ '%';
														}
													}, {
														field : 'input_time',
														title : '录入时间',
														width : 100,
														align : 'center',
													}, {
														field : 'start_date',
														title : '开始日期',
														width : 100,
														align:'center', 
													} ] ],
											onResize : function() {
												$('#showAccountList_data')
														.datagrid(
																'fixDetailRowHeight',
																index);
											},
											onLoadSuccess : function() {
												setTimeout(
														function() {
															$(
																	'#showAccountList_data')
																	.datagrid(
																			'fixDetailRowHeight',
																			index);
														}, 0);
											}

										});
								var s = ddv.datagrid('getPager');
								$(s)
										.pagination(
												{
													//	pageSize : 10,//每页显示的记录条数，默认为10 
													//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
													beforePageText : '第',//页数文本框前显示的汉字 
													afterPageText : '页    共 {pages} 页',
													displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

												});
							},

						});

		var p = $('#showAccountList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});

	})

	function doSearch(value) {
		$("#showAccountList_data").datagrid("load", {
			"value" : value
		});
	}
</script>
</head>
<body>


	<div id="toolbar">
		<div>
			<input class="easyui-searchbox" data-options="prompt:'输入姓名或者用户名搜索'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
		</div>
	</div>


	<table id="showAccountList_data" title="用户账户信息"
		style="width: 1200px; height: auto;"
		data-options="view:detailview,singleSelect:true,pagination:true,rownumbers:true,
fitColumns:true,toolbar:'#toolbar',url:'${pageContext.request.contextPath}/admin/showAccount/search',queryParams:{value:''},">
		<thead>
			<tr>
				<th data-options="field:'user_id',width:100,align:'center'">用户编号</th>
				<th data-options="field:'username',width:100,align:'center'">用户名</th>
				<th data-options="field:'realname',width:100,align:'center'">账户真实姓名</th>
				<th data-options="field:'account_id',width:100,align:'center'">账户编号</th>
				<th
					data-options="field:'amount_money',width:150,align:'center',formatter:function(value){return numFormat(value)+'元';}">总入账金额</th>
				
				<th
					data-options="field:'gain',width:100,align:'center',formatter:function(value){return numFormat(value)+'元';}">累计收益</th>
				<th
					data-options="field:'sum_money',width:100,align:'center',formatter:function(value){return numFormat(value)+'元';}">资金总额</th>
			</tr>
		</thead>
	</table>
</body>
</html>