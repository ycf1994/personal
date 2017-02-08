<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户收益明细</title>
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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/numFormat.js"></script>	
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		
		//linkUrl = $("#linkUrl").val();
		//alert(linkUrl);
		$("#showInterestList_data")
				.datagrid(
						{
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							title : "用户收益明细",
							width : "auto",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showInterest/getAllShowInterestList",
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
								field : 'sum_current_interest',
								title : '当天活期利息',
								width : 200,
								align:'center', 
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'sum_investment_interest',
								title : '当天投资利息',
								width : 200,
								align:'center', 
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'interest_date',
								title : '收益日期',
								width : 100,
								align:'center', 
							} ] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar"

						});

		var p = $('#showInterestList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		//alert(value);
		//var flag = $($('input:radio[name=choose]:checked')).val();
		//alert(flag);
		/* if (value != null) {
			$("#param").attr("value", value);

		} else {
			value = $("#param").val();
		} */

		$("#showInterestList_data")
		.datagrid(
				{
					pageSize : 50,//每页显示的记录条数，默认为10 
					pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
					title : "用户收益明细",
					width : "auto",
					height : "auto",
					nowrap : false,
					striped : true,
					border : true,
					collapsible : false,//是否可折叠的 
					url : "${pageContext.request.contextPath}/admin/showInterest/searchShowInterest?value="+value,
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
						field : 'sum_current_interest',
						title : '当天活期利息',
						width : 200,
						align:'center', 
						formatter : function(
								value) {

							return numFormat(value)
									+ "元";
						}
					}, {
						field : 'sum_investment_interest',
						title : '当天投资利息',
						width : 200,
						align:'center', 
						formatter : function(
								value) {

							return numFormat(value)
									+ "元";
						}
					}, {
						field : 'interest_date',
						title : '收益日期',
						width : 100,
						align:'center', 
					} ] ],
					//toolbar : "#toolbar"
					toolbar : "#toolbar"

				});

var p = $('#showInterestList_data').datagrid('getPager');
$(p).pagination({
	//pageSize : 10,//每页显示的记录条数，默认为10 
	//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

});

	}

/* 	//格式化 easyui-datebox 日期格式
 	$.fn.datebox.defaults.formatter = function(value) {
		alert(value);
 		 var date = new Date(value);
         var year = date.getFullYear().toString();
         var month = (date.getMonth() + 1);
         var day = date.getDate().toString();
       
         if (month < 10) {
             month = "0" + month;
         }
         if (day < 10) {
             day = "0" + day;
         }
         
         return year + "/" + month + "-" + day;
	} */
	 
	
	/* function search(e){
		//alert(1);
		//alert(e.value);
	} */
	
	/* $(document).ready(function(){
		$('#date').datebox({
            onSelect: function (date) {
            	var y = date.getFullYear();
        		var m = date.getMonth() + 1;
        		var d = date.getDate();
        		alert(y + '-' + m + '-' + d);
            }
        });
	}) */
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="showInterestList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'输入姓名或者用户名搜索'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
				
			
		</div>

	</div>
</body>
</html>