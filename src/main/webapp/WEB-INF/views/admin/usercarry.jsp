<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提现审核</title>
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
		$("#usercarryList_data")
				.datagrid(
						{

							title : "提现记录表",
							width : "auto",
							height : "auto",
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showUserCarry/findUserCarry",
							queryParams : {
								searchValue : '',
								status : -1
							},
							idField : 'id',
							singleSelect : true,//是否单选 
							pagination : true,//分页控件 
							rownumbers : true,//行号  
							columns : [ [
									{
										field : 'id',
										title : '记录编号',
										width : 100,
										align : 'center',
									},
									{
										field : 'user_id',
										title : '用户编号',
										width : 100,
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
										field : 'money',
										title : '提现金额',
										width : 200,
										align : 'center',
										formatter : function(
												value) {

											return numFormat(value)
													+ "元";
										}
									},
									{
										field : 'bank_id',
										title : '银行id',
										width : 50,
										align : 'center',
									},
									{
										field : 'bank_card',
										title : '银行卡号',
										width : 200,
										align : 'center',
									},
									{
										field : 'status',
										title : '审核状态',
										width : 100,
										align : 'center',
										formatter : function(value) {
											if (value == 0) {
												return "未处理";
											}
											if (value == 1) {
												return "提现成功";
											}
											if (value == 2) {
												return "提现关闭";
											}

										}
									},
									{
										field : 'create_time',
										title : '创建时间',
										width : 170,
										align : 'center',
									},
									{
										field : 'update_time',
										title : '处理时间',
										width : 170,
										align : 'center',
									},
									{
										field : 'a',
										title : '操作',
										width : 150,
										align : 'center',
										formatter : function(value, row, index) {
											if (row.status == 0)
												return '<a href="javascript:;" name="opera" class="easyui-linkbutton" iconCls="icon-ok" onclick="check(\''
														+ row.id
														+ '\',1)"  >提现</a>'
														+ '<a href="javascript:;" name="opera" class="easyui-linkbutton" iconCls="icon-cancel" onclick="check(\''
														+ row.id
														+ '\',2)"  >驳回</a>';

										}
									} ] ],
							onLoadSuccess : function(data, row, index) {

								$("a[name='opera']").linkbutton({
									plain : true
								});

							},
							//toolbar : "#toolbar"
							toolbar : "#toolbar",
								 pageSize : 50,//每页显示的记录条数，默认为10 
								pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

						});

		var p = $('#usercarryList_data').datagrid('getPager');
		$(p).pagination({
			// pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 20 ],//可以设置每页记录条数的列表  
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		if (value != null)
			$("#param").val(value);
		else
			value = $("#param").val();
		
		var status=$("input[name='status']:checked").val();
		$("#usercarryList_data").datagrid("load", {
			"searchValue" : value,
			"status":status
		});

	}

	function check(id, status) {
		$.ajax({
			url:"${pageContext.request.contextPath}/admin/userCarry/check",
			type:"post",
			dataType:"json",
			data:{"id":id,"status":status},
			success:function(result){
				//alert(result.msg);
				if(result.msg){
					$.messager.alert('提示信息',status==1?"提现成功":"驳回成功");
					$("#usercarryList_data").datagrid("load");
				}
			}
		})
	}
</script>



</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="usercarryList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'请输入真实姓名查询'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
			<input type="radio" value="-1" checked="checked" name="status" onclick="doSearch(null)" />全部
			<input type="radio" value="0" name="status"  onclick="doSearch(null)"/>未处理 
			<input
				type="radio" value="1" name="status" onclick="doSearch(null)" />提现成功
				
				 <input type="radio"
				value="2" name="status" onclick="doSearch(null)" />提现关闭

		</div>

	</div>






</body>
</html>