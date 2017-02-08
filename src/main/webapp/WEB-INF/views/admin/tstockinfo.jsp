<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>股票信息</title>
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
		$("#tstockinfoList_data")
				.datagrid(
						{
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
							title : "股票信息",
							width : "auto",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/tstockinfo/getAllTstockinfoList",
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
								field : 'stock_id',
								title : '系统编号',
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
								field : 'stock_type',
								title : '股票类型代码',
								width : 100,
								align:'center', 
							}, {
								field : 'stock_type_name',
								title : '股票类型',
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
							}] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar"

						});

		var p = $('#tstockinfoList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
	
	 

	   $("#tstockinfoList_data")
		.datagrid(
				{

					title : "股票信息",
					width : "auto",
					height : "auto",
					nowrap : false,
					striped : true,
					border : true,
					collapsible : false,//是否可折叠的 
					url : "${pageContext.request.contextPath}/admin/tstockinfo/searchTstockinfo?value="+value,
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
								field : 'stock_id',
								title : '系统编号',
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
								field : 'stock_type',
								title : '股票类型代码',
								width : 100,
								align:'center', 
							}, {
								field : 'stock_type_name',
								title : '股票类型',
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
							}] ],
					//toolbar : "#toolbar"
					toolbar : "#toolbar",
						pageSize : 50,//每页显示的记录条数，默认为10 
						pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
				});

var p = $('#tstockinfoList_data').datagrid('getPager');
$(p).pagination({
	//pageSize : 10,//每页显示的记录条数，默认为10 
	//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

});

	}
	function add() {
		$("#dlg").dialog("open").dialog('setTitle', '增加股票信息');
		;
		$("#fm").form("clear");
		init();
		//url = "${pageContext.request.contextPath}/admin/user/save";
		//document.getElementById("hidtype").value = "submit";
	}
</script>


<script type="text/javascript">
function init(){
	
		$
		.ajax({
			url : '${pageContext.request.contextPath}/admin/tstockinfo/getAllNeedPara',
			type : 'post',
			dataType : 'json',
			data:{"type_id":1130},
			success : function(result) {				
				var seids = result;
				var str = "[";
				for ( var i in seids) {
					str += "{label:'"
							+ i
							+ "',value:'"
							+ seids[i].type_value
							+ "--"
							+ seids[i].type_content
							+"'},";
				}
				str = str.substring(0,
						str.length - 1)
						+ "]";
				//alert(str);
				//alert(str);
				$('#seid')
						.combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(
											rec) {
										 var v = seids[rec.label];
								
									
										$(
												"input[name='seid_id']")
												.attr(
														"value",
														v.type_value);  
										$(
										"input[name='seid_name']")
										.attr(
												"value",
												v.type_content);  
									}
								});
				
				
				
			}
		});
		
		
		$
		.ajax({
			url : '${pageContext.request.contextPath}/admin/tstockinfo/getAllNeedPara',
			type : 'post',
			dataType : 'json',
			data:{"type_id":1129},
			success : function(result) {				
				var seids = result;
				var str = "[";
				for ( var i in seids) {
					str += "{label:'"
							+ i
							+ "',value:'"
							+ seids[i].type_value
							+ "--"
							+ seids[i].type_content
							+"'},";
				}
				str = str.substring(0,
						str.length - 1)
						+ "]";
				//alert(str);
				//alert(str);
				$('#stock_type')
						.combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(
											rec) {
										var v = seids[rec.label];
										
										
										$(
												"input[name='stock_type']")
												.attr(
														"value",
														v.type_value);  
										$(
										"input[name='stock_type_name']")
										.attr(
												"value",
												v.type_content);  
									}
								});
				
				
				
			}
		})
	
	
}
function save(){
	var data = $("#add").serializeArray();
	//alert(data);
	$
			.ajax({
				url : '${pageContext.request.contextPath}/admin/tstockinfo/addTstockinfo',
				type : 'post',
				dataType : 'json',
				data : data,
				success : function(result) {
					if (result.isAdded) {
						$.messager.alert('提示信息','添加成功');
						$("#dlg").dialog("close");
						$("#tstockinfoList_data").datagrid("load");
					}
				}
			});
}
</script>

<script type="text/javascript">
$(function(){
	$("#stock_code").blur(function(){
		$("input[name='stock_code']").attr("value",this.value);
	})
	$("#stock_name").blur(function(){
		$("input[name='stock_name']").attr("value",this.value);
	})
})
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="tstockinfoList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'请输入股票代码或者股票名称查询'"
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
				<label>股票代码 </label> <input id="stock_code"  class="easyui-validatebox"
					  required="true" />
			</div>
			<div class="fitem">
				<label>股票名称</label> <input id="stock_name" class="easyui-validatebox" 
					 required="true" />
			</div>
			<div class="fitem">
				<label>股票类型</label> <input id="stock_type" class="easyui-validatebox"
					required="true"  />
			</div>
			
			<div class="fitem">
				<label>市场名称</label> <input id="seid" class="easyui-validatebox"
					required="true"  />
			</div>
			
				<input type="hidden" name="action" id="hidtype" />
	<input type="hidden" name="ID" id="Nameid" />
	</form>
	</div>
	
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="save()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
	<div style="display: none;">
	<form id="add" >
		<input name="stock_code" />
		<input name="stock_name" />
		<input name="stock_type" />
		<input name="stock_type_name" />
		<input name="seid_id" />
		<input name="seid_name" />
	</form>
	</div>
	
</body>
</html>