<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户信息</title>
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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/datagrid-detailview.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/numFormat.js"></script>
<script type="text/javascript">
	$(function() {
		$("#tfundacctList_data")
				.datagrid(
						{pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							onExpandRow : function(index, row) {
								var fund_balance = row.fund_balance;
								var fund_id=row.fund_id;
								var outindex=index;
								$("#ddv-"+index)
										.datagrid({
											pageSize : 50,//每页显示的记录条数，默认为10 
											pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
											//title : "合同信息",
											width : "auto",
											height : "auto",
											nowrap : false,
											striped : true,
											border : true,
											collapsible : false,//是否可折叠的 
											url : "${pageContext.request.contextPath}/admin/tfundacct/getContractsByFund_id?fund_id="
													+ row.fund_id,
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
														formatter : function(
																value) {
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
														width : 200,
														align : 'center',
													},
													{
														field : 'a',
														title : '操作',
														width : 100,
														formatter : function(
																value, row,
																index) {
															return '<a name="a" href="javascript:void(0)" class="easyui-linkbutton"	onclick="backMoney(\''
																	+ row.contract_no
																	+ '\','
																	+ (fund_balance >= row.contract_money)
																	+ ','
																	+ row.contract_money
																	+','
																	+fund_id
																	+","
																	+outindex
																	+ ')" iconcls="icon-redo">回款</a> ';
														}
													} ] ],
											//toolbar : "#toolbar"
											//toolbar : "#toolbar"
										
											onResize : function() {
												$('#tfundacctList_data')
														.datagrid(
																'fixDetailRowHeight',
																index);
											},
											onLoadSuccess : function() {
												$("a[name='a']").linkbutton({
													plain : true
												});
												setTimeout(
														function() {
															$(
																	'#tfundacctList_data')
																	.datagrid(
																			'fixDetailRowHeight',
																			index);
														}, 0);
											}
										});

								var p =$("#ddv-"+index).datagrid('getPager');
								$(p)
										.pagination(
												{
													//pageSize : 10,//每页显示的记录条数，默认为10 
													//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
													beforePageText : '第',//页数文本框前显示的汉字 
													afterPageText : '页    共 {pages} 页',
													displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

												});
							},
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table id="ddv-' + index + '"></table></div>';
							},
							view : detailview,
							title : "资金账户信息",
							width : "100%",
							height : "auto",
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/tfundacct/getTfundacctListByCust_name",
							queryParams : {
								cust_name : ''
							},
							idField : 'id',
							singleSelect : true,//是否单选 
							pagination : true,//分页控件 
							rownumbers : true,//行号  
							remoteSort : false,
							columns : [ [
									{
										field : 'fund_id',
										title : '资金账户编号',
										width : 200,
										align : 'center',
									},
									{
										field : 'fund_acct',
										title : '资金账户名称',
										width : 200,
										align : 'center',
									},
									{
										field : 'cust_id',
										title : '用户ID',
										width : 200,
										align : 'center',
									},
									{
										field : 'cust_name',
										title : '用户名称',
										width : 200,
										align : 'center',
									},

									{
										field : 'contract_money',
										title : '借款总额',
										width : 200,
										align : 'center',
										formatter : function(
												value) {

											return numFormat(value)
													+ "元";
										}
									}
									
									] ],
							toolbar : "#toolbar",
							onLoadSuccess : function(data, row, index) {

								$("a[name='x']").linkbutton({
									plain : true
								});

							},

						});

		var p = $('#tfundacctList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {

		$("#tfundacctList_data").datagrid("load", {
			cust_name : value
		});

	}
</script>

<script type="text/javascript">
function backMoney(contract_no,flag,contract_money,fund_id,index){
	if(!flag){
		$.messager.alert('提示信息',"余额不足，无法回款");
	}
	
	//alert(index);
	if(flag){
		$.ajax({
			url:'${pageContext.request.contextPath}/admin/contract/checkContract',
			type:'post',
			dataType:'json',
			data:{contract_no:contract_no,states:5},
			success:function(result){
				if(result.msg){
					$.ajax({
						url:'${pageContext.request.contextPath}/admin/tfundacct/fundacctBack',
						type:'post',
						dataType:'json',
						data:{contract_no:contract_no,money:contract_money,fund_id:fund_id},
						success:function(result){
							//alert(index);
							if(result.msg){
								//$("#ddv-"+index).datagrid("reload");
								$("#tfundacctList_data")
								.datagrid("reload");
							}
						}
					});
				}
			}
		});
		
		
		
	}
	
}
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="tfundacctList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'请输入真实姓名查询'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>

		</div>

	</div>
</body>
</html>