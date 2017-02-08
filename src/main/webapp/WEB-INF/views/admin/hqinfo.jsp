<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>股票行情</title>
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
		$("#hqinfo_data")
				.datagrid(
						{

							title : "股票行情表",
							width : "auto",
							height : "auto",
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/hqinfo/findHqinfoList",
							queryParams : {
								codeOrName : '',
								hq_date : 0
							},
							idField : 'id',
							singleSelect : true,//是否单选 
							pagination : true,//分页控件 
							rownumbers : true,//行号  
							columns : [ [ {
								field : 'serial_no',
								title : '记录编号',
								width : 100,
								align : 'center',
							}, {
								field : 'stock_id',
								title : '股票id',
								width : 100,
								align : 'center',
							}, {
								field : 'stock_code',
								title : '股票代码',
								width : 100,
								align : 'center',
							}, {
								field : 'stock_name',
								title : '股票名称',
								width : 100,
								align : 'center',
							}, {
								field : 'last_price',
								title : '收盘价格',
								width : 200,
								align : 'center',
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'now_price',
								title : '当前价格',
								width : 200,
								align : 'center',
								formatter : function(
										value) {

									return numFormat(value)
											+ "元";
								}
							}, {
								field : 'hq_date',
								title : '行情日期',
								width : 100,
								align : 'center',
							}, {
								field : 'hq_end_date',
								title : '行情结束时间',
								width : 100,
								align : 'center',
							}, {
								field : 'input_time',
								title : '更新时间',
								width : 100,
								align : 'center',
							}, ] ],

							//toolbar : "#toolbar"
							toolbar : "#toolbar",
							 pageSize : 50,//每页显示的记录条数，默认为10 
								pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

						});

		var p = $('#hqinfo_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		if (value != null)
			$("#codeOrName").val(value);
		var codeOrName = $("#codeOrName").val();
		//alert($("hq_date").val());
		var hq_date = $("#hq_date").val().length == 0 ? 0 : $("#hq_date").val();
		//alert(hq_date);
		$("#hqinfo_data").datagrid("load", {
			"codeOrName" : codeOrName,
			"hq_date" : hq_date
		});
	}

	function getDate() {
		$("#hq_date").val(
				(String($("#date").datebox("getValue")).replace(/-/g, '')));
		doSearch(null);
	}
</script>
<script type="text/javascript">
	function saveHqinfo() {
		var url="${pageContext.request.contextPath}/admin/hqinfo/add";
		if($("#hqform").form("validate")){
			var data = $("#hqinfoData").serializeArray();
			 ;
			//return;
			
			$.ajax({
				url:'${pageContext.request.contextPath}/admin/hqinfo/find',
				type:'post',
				data:{stock_code:$("input[name='stock_code']").val()},
				dataType:'json',
				success:function(result){
					//alert(result.msg);
					if(result.msg){
						if(confirm("今天已更新改股票行情，确定覆盖更新吗？")){
							url="${pageContext.request.contextPath}/admin/hqinfo/update";
						}else{
							return;
						}
					}
					$
					.ajax({
						url : url,
						type : 'post',
						dataType : 'json',
						data : data,
						success : function(result) {
							if (result.msg) {
								$.messager.alert('提示信息',"更新成功");
								$("#hqinfo").dialog("close");
								$("#hqinfo_data").datagrid("load");
							}
						}
					});
				}
			});
			//alert(data);
			
		}
	
	}

	function addHqinfo() {
		
		$("#hqinfo").dialog("open").dialog('setTitle', '更新行情');
		$("#hqform").form("clear");
		loadStock();
	}

	function loadStock() {
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/capitaloperation/getAllTstockinfo',
					type : 'post',
					dataType : 'json',
					success : function(result) {
						//alert(result)
						var stocklist = result;
						var str = "[";
						for ( var i in stocklist) {
							str += "{label:'" + i + "',value:'"
									+ stocklist[i].stock_code + "--"
									+ stocklist[i].stock_name + "'},";
						}
						str = str.substring(0, str.length - 1) + "]";
						//alert(str);
						$('#stock').combobox({

							valueField : 'label',
							textField : 'value',
							data : eval(str),
							onSelect : function(rec) {
								var stock = stocklist[rec.label];
								/* alert(stock.id);
								alert(stock.stock_code);
								alert(stock.stock_name); */
								$("input[name='stock_id']").val(stock.stock_id);
								$("input[name='stock_code']").val(stock.stock_code);
								$("input[name='stock_name']").val(stock.stock_name);
							},
							required:true
						});
					}
				})
	}
	$(function(){
		$("input", $("#now_price").next("span")).blur(function() {
			//alert(1);
			//$("input[name='occurrence_fund']").attr("value", this.value);
			$("input[name='now_price']").val(this.value);
			//alert(this.value);
		})
	})
</script>
<script>
	function addStock() {
		$("#dlg").dialog("open").dialog('setTitle', '添加股票信息');
		;
		$("#fm").form("clear");
		init2();

	}
	function init2() {

		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/tstockinfo/getAllNeedPara',
					type : 'post',
					dataType : 'json',
					data : {
						"type_id" : 1130
					},
					success : function(result) {
						var seids = result;
						var str = "[";
						for ( var i in seids) {
							str += "{label:'" + i + "',value:'"
									+ seids[i].type_value + "--"
									+ seids[i].type_content + "'},";
						}
						str = str.substring(0, str.length - 1) + "]";
						//alert(str);
						//alert(str);
						$('#seid').combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(rec) {
										var v = seids[rec.label];

										$("#seid_id_foradd").attr("value",
												v.type_value);
										$("#seid_name_foradd").attr("value",
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
					data : {
						"type_id" : 1129
					},
					success : function(result) {
						var seids = result;
						var str = "[";
						for ( var i in seids) {
							str += "{label:'" + i + "',value:'"
									+ seids[i].type_value + "--"
									+ seids[i].type_content + "'},";
						}
						str = str.substring(0, str.length - 1) + "]";
						//alert(str);
						//alert(str);
						$('#stock_type').combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(rec) {
										var v = seids[rec.label];

										$("#stock_type_foradd").attr("value",
												v.type_value);
										$("#stock_type_name_foradd").attr(
												"value", v.type_content);
									}
								});

					}
				})

	}
	function save() {
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
							loadStock();
						}
					}
				});
	}

	$(function() {
		$("#stock_code").blur(function() {
			$("#stock_code_foradd").attr("value", this.value);
		})
		$("#stock_name").blur(function() {
			$("#stock_name_foradd").attr("value", this.value);
		})
	})
</script>

</head>
<body>
	<input type="hidden" id="codeOrName" value="" />
	<input type="hidden" id="hq_date" value="" />
	<table id="hqinfo_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconcls="icon-add" onclick="addHqinfo()" plain="true">添加</a> <input
				class="easyui-searchbox" data-options="prompt:'请输入代码或名称查询'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
			<input id="date" class="easyui-datebox"
				data-options=" editable:false,onSelect:getDate" />

		</div>

	</div>
<div style="display: none;">
<form id="hqinfoData">
	<input name="stock_id" />
	<input name="stock_name" />
	<input name="stock_code" />
	<input name="now_price" />
</form>
</div>
	<div id="hqinfo" class="easyui-dialog" title="更新行情"
		style="width: 300px; height: 200px" buttons="#dlg-buttons"
		closable="true" closed="true" left="200px" top="130px">
		<div style="margin-bottom: 10px">
			<form id="hqform" >
				<div>选择股票</div>
				<input id="stock" class="easyui-combobox easyui-validatebox"
					style="width: 80%; height: 32px" ><a
					href="javascript:void(0)" class="easyui-linkbutton "
					iconcls="icon-add" onclick="addStock()" plain="true">添加</a>
				<div>当前价格</div>
				<input id="now_price" type="text" class="easyui-numberbox easyui-validatebox"
					data-options="min:0,precision:2" style="width: 80%"  required="true">
			</form>
		</div>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveHqinfo()" iconcls="icon-save">更新</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('.easyui-dialog').dialog('close')"
			iconcls="icon-cancel">取消</a>
	</div>













	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">

		<form id="fm" method="post">
			<div class="fitem">
				<label>股票代码 </label> <input id="stock_code"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>股票名称</label> <input id="stock_name"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>股票类型</label> <input id="stock_type"
					class="easyui-validatebox" required="true" />
			</div>

			<div class="fitem">
				<label>市场名称</label> <input id="seid" class="easyui-validatebox"
					required="true" />
			</div>

			<input type="hidden" name="action" id="hidtype" /> <input
				type="hidden" name="ID" id="Nameid" />
		</form>
	</div>


	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="save()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
	<div style="display: none;">
		<form id="add">
			<input name="stock_code" id="stock_code_foradd" /> <input
				name="stock_name" id="stock_name_foradd" /> <input
				name="stock_type" id="stock_type_foradd" /> <input
				name="stock_type_name" id="stock_type_name_foradd" /> <input
				name="seid_id" id="seid_id_foradd" /> <input name="seid_name"
				id="seid_name_foradd" />
		</form>
	</div>


</body>
</html>