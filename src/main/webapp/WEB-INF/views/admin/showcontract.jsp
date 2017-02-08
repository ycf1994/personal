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
										formatter : function(value) {

											return numFormat(value) + "元";
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
										formatter : function(value) {
											return parseFloat(value * 100)
													.toFixed(2)
													+ '%';
										}
									}, {
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
									}, {
										field : 'invest_gain',
										title : '预期收益',
										width : 200,
										align : 'center',
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									}, {
										field : 'sum_gain',
										title : '累计收益',
										width : 200,
										align : 'center',
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									}, {
										field : 'check_name',
										title : '审核人',
										width : 100,
										align : 'center',
									}, {
										field : 'check_time',
										title : '审核时间',
										width : 100,
										align : 'center',
									}, {
										field : 'fund_id',
										title : '资金账户ID',
										width : 100,
										align : 'center',
									}, {
										field : 'fund_acc',
										title : '资金账户',
										width : 100,
										align : 'center',
									}, {
										field : 'investment_account_no',
										title : '投资账户编号',
										width : 200,
										align : 'center',
									} ] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar"

						});

		var p = $('#showContractList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		var user = "";
		var cust = "";

		var vs = value.split("/");
		if (vs.length == 2) {
			user = vs[0];
			cust = vs[1];
		} else if (vs.length == 1) {
			if (value.indexOf("/") == 0) {
				cust = vs[0];
			} else {
				user = vs[0]
			}

		} else {
			$.messager.alert('提示信息', "查询格式不正确");
		}

		$("#showContractList_data")
				.datagrid(
						{

							title : "合同信息",
							width : "auto",
							height : "auto",
							nowrap : false,
							striped : true,
							border : true,
							collapsible : false,//是否可折叠的 
							url : "${pageContext.request.contextPath}/admin/showContract/searchShowContract?user="
									+ user + "&cust=" + cust,
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
										width : 100
									},
									{
										field : 'user',
										title : '出资方',
										width : 100
									},
									{
										field : 'cust',
										title : '借款方',
										width : 100
									},
									{
										field : 'contract_money',
										title : '借款金额',
										width : 100,
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									},{
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
										width : 100
									},
									{
										field : 'start_date',
										title : '开始日期',
										width : 100
									},
									{
										field : 'end_date',
										title : '结束日期',
										width : 100
									},
									{
										field : 'investment_rate',
										title : '投资利率',
										width : 100,
										formatter : function(value) {
											return parseFloat(value * 100)
													.toFixed(2)
													+ '%';
										}
									}, {
										field : 'states',
										title : '合同状态',
										width : 100,
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
									}, {
										field : 'invest_gain',
										title : '预期收益',
										width : 100,
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									}, {
										field : 'sum_gain',
										title : '累计收益',
										width : 100,
										formatter : function(value) {

											return numFormat(value) + "元";
										}
									}, {
										field : 'check_name',
										title : '审核人',
										width : 100
									}, {
										field : 'check_time',
										title : '审核时间',
										width : 100
									}, {
										field : 'fund_id',
										title : '资金账户ID',
										width : 100
									}, {
										field : 'fund_acc',
										title : '资金账户',
										width : 100
									}, {
										field : 'investment_account_no',
										title : '投资账户编号',
										width : 100
									} ] ],
							//toolbar : "#toolbar"
							toolbar : "#toolbar",
							pageSize : 50,//每页显示的记录条数，默认为10 
							pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
						});

		var p = $('#showContractList_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});

	}

	function add() {
		$("#dlg").dialog("open").dialog('setTitle', '录入合同');
		$("#fm").form("clear");

		$('#investment_account_no').combobox({
			valueField : 'id',
			textField : 'realname',
			data : [],
		});
		$("#cust_id")
				.combobox(
						{

							valueField : 'id',
							textField : 'realname',
							url : "${pageContext.request.contextPath}/admin/showContract/getAllCustList",
							formatter : function(row) {
								//var opts = $(this).combobox('options');
								return row.realname + "[" + row.idno + "]";
							},
							onSelect : function(rec) {
								$("input[name='cust_id']")
										.attr("value", rec.id);
							}
						});

		$
				.ajax({
					url : "${pageContext.request.contextPath}/admin/showInvestment_account/findUsers",
					type : "post",
					dataType : "json",
					success : function(result) {
						var str = "[";
						for ( var i in result) {
							str += "{\"value\":\"" + result[i].id
									+ "\",\"text\":\"" + result[i].username
									+ "[" + result[i].realname + "]" + "\"},"
						}
						if (str.length > 1)
							str = str.substring(0, str.length - 1);
						str += "]";
						$("#user_id").combobox({

							valueField : 'value',
							textField : 'text',
							data : eval(str),
							onSelect : function(rec) {
								//	alert(rec.value);
								$("input[name='user_id']").val(rec.value);
								search(rec.value);
							}
						});

					}
				})

	}

	function search(user_id) {

		$
				.ajax({
					url : "${pageContext.request.contextPath}/admin/showContract/getInvestmentAccountsByUser_id",
					type : "post",
					dataType : "json",
					data : {
						"user_id" : user_id
					},
					success : function(result) {
						//alert(result.msg);
						//alert(result.id);
						if (result.msg == 'success') {
							//var id = result.id;
							var list = result.list;
							var str = "[";

							//$("input[name='user_id']").attr("value", id);

							for ( var i in list) {
								str += "{label:'"
										+ (list[i].investment_account_no)
										+ "',value:'"
										+ list[i].investment_account_no + " 余额"
										+ list[i].balance + "'"
										+ (i == 0 ? ",selected:true" : "")
										+ "},";
							}
							str = str.substring(0, str.length - 1) + "]";

							$('#investment_account_no')
									.combobox(
											{

												valueField : 'label',
												textField : 'value',
												data : eval(str),//JSON字符串转为JSON对象
												onSelect : function(rec) {
													$(
															"input[name='investment_account_no']")
															.attr("value",
																	rec.label);
													$("#balance")
															.attr(
																	"value",
																	String(
																			rec.value)
																			.split(
																					"余额")[1]);
													$("#contract_money")
															.val(
																	String(
																			rec.value)
																			.split(
																					"余额")[1]);
													$(
															"input[name='contract_money']")
															.attr(
																	"value",
																	String(
																			rec.value)
																			.split(
																					"余额")[1]);
												}
											});

							//document.getElementById("investmentAccount").innerHtml=str;
						} else if (result.msg == 'IDNULL') {
							$.messager.alert('提示信息', "没有该用户");
						} else {
							$.messager.alert('提示信息', "该用户暂无投资账户");
							$("#fm").form("clear");
							$('#investment_account_no').combobox({
								valueField : 'id',
								textField : 'realname',
								data : [],
							});
						}
					}
				});
	}
</script>


<script type="text/javascript">
	$(function() {
		$("#contract_no").blur(function(){
			
			var contract_no=this.value;
			$.ajax({
				url:'${pageContext.request.contextPath}/admin/contract/checkSameContract_no',
				type:'post',
				data:{contract_no:contract_no},
				dataType:'json',
				success:function(result){
					if(result.msg){
						//alert(1);
						$("input[name='contract_no']").val(contract_no);
					}else{
						$.messager.alert("提示信息", "合同号已存在");
						$("#contract_no").val("");
					}
				}
			})
			
			
			
			
			
		})
		$("#earnest_money").blur(function(){
			$("input[name='earnest_money']").attr("value", this.value);
		})
		$("#sum_money").blur(function(){
			$("input[name='sum_money']").attr("value", this.value);
		})
		$("#contract_money").blur(function() {
			var value = this.value;
			//alert(value);
			//alert(parseFloat($("#balance").val()));
			if (parseFloat(value) > parseFloat($("#balance").val())) {
				//alert("超出余额");
				value = parseFloat($("#balance").val());
				//alert(value);
				$("#contract_money").val(value);
			}

			$("input[name='contract_money']").attr("value", value);
		})
		$("input", $("#investment_rate").next("span")).blur(function() {
			//alert(2);
			$("input[name='investment_rate']").attr("value", parseFloat(this.value)/100);
		})
		$("#fund_acc").blur(function() {

			$("input[name='fund_acc']").attr("value", this.value);
		})
	})

	function sign_date(date) {
		var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;
		if (!DateRegExp.test(date))
			return;
		$("input[name='sign_date']").attr("value",
				$("#sign_date").datebox("getValue"));
	}
	function start_date(date) {
		var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;
		if (!DateRegExp.test(date))
			return;
		
		$("input[name='start_date']").attr("value",
				$("#start_date").datebox("getValue"));
	}
	function end_date(date) {
		var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;
		if (!DateRegExp.test(date))
			return;
		$("input[name='end_date']").attr("value",
				$("#end_date").datebox("getValue"));
	}

	function input() {
		
		var data = $("form").serializeArray();
		
		if(!$("#fm").form("validate")) return;
		
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/showContract/input',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(result) {
						
						if(result.error=='error'){
							$.messager.alert('提示信息', '合同开始日期不得早于资金计息开始日期');
							return;
						}
						$("#dlg").dialog("close");
						if (result.isInputed) {
							$.messager.alert('提示信息', '录入成功');
							$("#showContractList_data").datagrid("load");
						}
					}
				});
	}
</script>
</head>
<body>
	<div style="display: none;">
		<form>
			<input name="user_id" required /> <input
				name="investment_account_no" required /> <input name="cust_id"
				required /> <input name="contract_money" required /> <input
				name="fund_acc" required /> <input name="sign_date" required /> <input
				name="start_date" required /> <input name="end_date" required /> <input
				name="investment_rate" required />
				<input name="contract_no" required />
				<input name="earnest_money" required/><input name="sum_money" required/>

		</form>

	</div>

	<input type="hidden" id="param" value="" />
	<table id="showContractList_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'查询格式：出资方/借款方'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconcls="icon-add" onclick="add()" plain="true">新增</a>

		</div>

	</div>




	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 300px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">

		<form id="fm" method="post">
			<div class="fitem">
				<label>合同编号 </label> <input id="contract_no" required="true" class="easyui-validatebox"  />
			</div>
			<div class="fitem">
				<label>出资方用户名: </label> <input id="user_id" required="true" />
			</div>
			<div class="fitem">
				<label>出资方投资资金</label> <input id="investment_account_no"
					class="easyui-combobox" />
			</div>
			<div class="fitem">
				<label>借款方</label> <input id="cust_id" />
			</div>
			<div class="fitem">
				<label>资金账户</label> <input id="fund_acc" class="easyui-validatebox"
					required="true" />
			</div>
			<div class="fitem">
				<label>借款金额</label> <input id="contract_money"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>保证金</label> <input id="earnest_money"
					class="easyui-validatebox" required="true"/>
			</div>
			<div class="fitem">
				<label>总金额</label> <input id="sum_money"
					class="easyui-validatebox" required="true"/>
			</div>
			<div class="fitem">
				<label>签署日期</label> <input class="easyui-datebox" required="true"
					id="sign_date" data-options="onChange:sign_date" />
			</div>
			<div class="fitem">
				<label>开始日期</label> <input class=" easyui-datebox" required="true"
					id="start_date" data-options=" onChange:start_date" />
			</div>
			<div class="fitem">
				<label>结束日期</label> <input class=" easyui-datebox" required="true"
					id="end_date" data-options=" onChange:end_date" />
			</div>
			<div class="fitem">
				<label>借款利率</label> <input id="investment_rate"
					class="easyui-validatebox easyui-numberbox"
					data-options="min:0,precision:2" required="true" />%
			</div>


		</form>
	</div>


	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="input()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>

	<input type="hidden" id="balance" />
</body>
<script type="text/javascript">
	/* $(function(){
	 $("#sign_date").datebox({  
	 parser:function(s){ 
	 //alert(s);
	 //格式为yyyy-mm-dd  
	 var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;  
	 var flag=DateRegExp.test(s);
	 if(flag){
	
	 $("input[name='sign_date']").val($("#sign_date").datebox("getValue"));
	 }
	 //字符转日期   
	
	 }  
	 });  
	 $("#start_date").datebox({  
	 parser:function(s){ 
	 // alert(s);
	 //格式为yyyy-mm-dd  
	 var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;  
	
	 if(DateRegExp.test(s)){  
	 alert(s);
	 $("input[name='start_date']").val(s);
	 }else{  
	 return null;  
	 }  
	 //字符转日期   
	
	 }  
	 });  
	 $("#end_date").datebox({  
	 parser:function(s){ 
	 // alert(s);
	 //格式为yyyy-mm-dd  
	 var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;  
	
	 if(DateRegExp.test(s)){  
	 $("input[name='end_date']").val(s);
	 }else{  
	 return null;  
	 }  
	 //字符转日期   
	
	 }  
	 });  
	 }) */
</script>
</html>