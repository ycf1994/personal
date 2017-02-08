<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同录入</title>
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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.json-2.3.min.js"></script>
<script type="text/javascript">
	function doSearch(value) {
		//	$.ajaxSettings.async = false;//设置为同步加载
		$
				.ajax({
					url : "${pageContext.request.contextPath}/admin/capitaloperation/getInvestmentAccountsByUsername",
					type : "post",
					dataType : "json",
					data : {
						"username" : value
					},
					success : function(result) {
						alert(result.msg);
						alert(result.id);
						if (result.msg == 'success') {
							var id = result.id;
							var list = result.list;
							var str = "[";

							$("input[name='user_id']").attr("value", id);

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

							$('#investmentAccount')
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
												}
											});

							//document.getElementById("investmentAccount").innerHtml=str;
						} else if (result.msg == 'IDNULL') {
							alert("没有该用户");
						} else {
							alert("该用户暂无投资账户");
						}
					}
				});

	}

	$(function() {
		$("input", $("#custid").next("span"))
				.blur(
						function() {
							var custname = $("#cust").val();
							var custidno = $("#custid").val();
							$
									.ajax({
										url : "${pageContext.request.contextPath}/admin/capitaloperation/getIdByRealnameAndIdno",
										type : 'post',
										dataType : 'json',
										data : {
											realname : custname,
											idno : custidno
										},
										success : function(result) {
											var id = result.id;
											if (id == 'null') {
												alert("姓名和身份证不匹配，请核实！");
											} else {
												alert("身份信息正确");
												$("input[name='cust_id']")
														.attr("value", id);
											}

										}
									})
						})

		$("input", $("#contract_money").next("span")).blur(
				function() {
					$("input[name='contract_money']").attr("value",
							$("#contract_money").val());
				})
		$("input", $("#fund_id").next("span")).blur(function() {
			$("input[name='fund_id']").attr("value", $("#fund_id").val());
		})
		$("input", $("#fund_acc").next("span")).blur(function() {
			$("input[name='fund_acc']").attr("value", $("#fund_acc").val());
		})
		/*   $("input",$("#sign_date").next("span")).blur(function(){
		   alert($("#sign_date").datebox("getValue"));
		 $("input[name='sign_date']").attr("value",$("#sign_date").val());
		})
		  $("input",$("#start_date").next("span")).blur(function(){
		 $("input[name='start_date']").attr("value",$("#start_date").val());
		})
		  $("input",$("#end_date").next("span")).blur(function(){
		 $("input[name='end_date']").attr("value",$("#end_date").val());
		}) */
		$("input", $("#investment_rate").next("span")).blur(
				function() {
					$("input[name='investment_rate']").attr("value",
							$("#investment_rate").val());
				})
	})

	function input() {
		var data = $("form").serializeArray();
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/capitaloperation/input',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(result) {
						if (result.isInputed) {
							alert('录入成功');
							//window.location.reload();
						}
					}
				});
	}

	function sign_date(date) {
		$("input[name='sign_date']").attr("value",
				$("#sign_date").datebox("getValue"));
	}
	function start_date(date) {
		$("input[name='start_date']").attr("value",
				$("#start_date").datebox("getValue"));
	}
	function end_date(date) {
		$("input[name='end_date']").attr("value",
				$("#end_date").datebox("getValue"));
	}
</script>
</head>
<body>
	<div style="display: none;">
		<form>
			<input name="user_id" required /> <input
				name="investment_account_no" required /> <input name="cust_id"
				required /> <input name="contract_money" required /> <input
				name="fund_id" required /> <input name="fund_acc" required /> <input
				name="sign_date" required /> <input name="start_date" required />
			<input name="end_date" required /> <input name="investment_rate"
				required />

		</form>

	</div>

	<div style="margin: -10px 0;"></div>
	<div class="easyui-panel" title=InputContract
		style="width: 400px; padding: 30px 60px">
		<div style="margin-bottom: 10px">
			<div>出资方用户名:</div>
			<input class="easyui-searchbox" data-options="prompt:'输入用户名搜索'"
				style="width: 100%; vertical-align: middle;" searcher="doSearch" />
		</div>
		<div style="margin-bottom: 10px">
			<div>出资方投资资金:</div>
			<input id="investmentAccount" style="width: 100%">
		</div>
		<div style="margin-bottom: 10px">
			<div>借款方姓名:</div>
			<input id="cust" class="easyui-textbox"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 10px">
			<div>借款方身份证号码:</div>
			<input id="custid" class="easyui-textbox"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin-bottom: 10px">
			<div>资金账户ID</div>
			<input id="fund_id" type="text" class="easyui-textbox"
				data-options="min:0,precision:2" style="width: 100%">
		</div>
		<div style="margin-bottom: 10px">
			<div>资金账户</div>
			<input id="fund_acc" type="text" class="easyui-textbox"
				data-options="min:0,precision:2" style="width: 100%">
		</div>
		<div style="margin-bottom: 10px">
			<div>借款金额</div>
			<input id="contract_money" type="text" class="easyui-numberbox"
				data-options="min:0,precision:2" style="width: 100%">
		</div>
		<div style="margin-bottom: 10px">
			<div>签署日期</div>
			<input id="sign_date" class="easyui-datebox" style="width: 100%"
				data-options="onSelect:sign_date" />
		</div>

		<div style="margin-bottom: 10px">
			<div>开始日期</div>
			<input id="start_date" class="easyui-datebox" style="width: 100%"
				data-options="onSelect:start_date" />
		</div>

		<div style="margin-bottom: 10px">
			<div>结束日期</div>
			<input id="end_date" class="easyui-datebox" style="width: 100%"
				data-options="onSelect:end_date" />
		</div>

		<div style="margin-bottom: 10px">
			<div>借款利率</div>
			<input id="investment_rate" type="text" class="easyui-numberbox"
				data-options="min:0,precision:3" style="width: 100%">
		</div>

		<div>
			<a href="javascript:;" class="easyui-linkbutton" iconCls="icon-ok"
				style="width: 100%; height: 32px" onclick="input()">录入</a>
		</div>
	</div>
</body>
</html>