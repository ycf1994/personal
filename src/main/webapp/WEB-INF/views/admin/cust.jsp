<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借款人信息</title>
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
<script type="text/javascript">
	$(function() {
		
		//linkUrl = $("#linkUrl").val();
		//alert(linkUrl);
		$("#custList_data")
				.datagrid(
						{

							title : "借款人信息",
							width : "auto",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/cust/getCustList",
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
								title : '用户编号',
								width : 100,
								align:'center',  
							}, {
								field : 'realname',
								title : '真实姓名',
								width : 100,
								align:'center', 
							}, {
								field : 'idno',
								title : '身份证号',
								width : 100,
								align:'center', 
							}, {
								field : 'mobile',
								title : '手机号码',
								width : 100,
								align:'center', 
							}] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar",
							 pageSize : 50,//每页显示的记录条数，默认为10 
								pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

						});

		var p = $('#custList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
	
	 

	   $("#custList_data")
		.datagrid(
				{

					title : "借款人信息",
					width : "auto",
					height : "auto",
					nowrap : false,
					striped : true,
					border : true,
					collapsible : false,//是否可折叠的 
					url : "${pageContext.request.contextPath}/admin/cust/searchCust?realname="+value,
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
						title : '用户编号',
						width : 100
					}, {
						field : 'realname',
						title : '真实姓名',
						width : 100
					}, {
						field : 'idno',
						title : '身份证号',
						width : 100
					}, {
						field : 'mobile',
						title : '手机号码',
						width : 100
					}] ],
					//toolbar : "#toolbar"
					toolbar : "#toolbar",
					 pageSize : 50,//每页显示的记录条数，默认为10 
						pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

				});

var p = $('#custList_data').datagrid('getPager');
$(p).pagination({
	//pageSize : 10,//每页显示的记录条数，默认为10 
	//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

});

	}

</script>


<script>
function add() {
	$("#dlg").dialog("open").dialog('setTitle', '新增借款人');
	$("#fm").form("clear");	
}

function save(){
	$("#fm").form("submit", {
		url : "${pageContext.request.contextPath}/admin/cust/addCust",
		onsubmit : function() {
			return $(this).form("validate");
		},
		success : function(result) {
			var obj = jQuery.parseJSON(result);
			//alert(obj.msg);
			if (obj.msg) {
				$.messager.alert("提示信息", "操作成功");
				$("#dlg").dialog("close");
				$("#custList_data").datagrid("load");
			} else {
				$.messager.alert("提示信息", "操作失败");
			}
		}
	});
}
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="custList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'请输入真实姓名查询'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
				<a href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-add" onclick="add()" plain="true">新增</a> 
			
		</div>

	</div>
	
	
	
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">
		
		<form id="fm" method="post">
			<div class="fitem">
				<label>真实姓名 </label> <input name="realname"  class="easyui-validatebox"
					  required="true" />
			</div>
			<div class="fitem">
				<label>身份证号</label> <input name="idno" class="easyui-validatebox" 
					 required="true" />
			</div>
			<div class="fitem">
				<label>手机号码</label> <input name="mobile" class="easyui-validatebox"
					required="true"  />
			</div>
			
			
	</form>
	</div>
	
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="save()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
	
	
</body>
</html>