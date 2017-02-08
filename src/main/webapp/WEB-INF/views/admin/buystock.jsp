<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>清算操作</title>
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
	function buy() {
		var data = $("#buyorsale").serializeArray();
		alert(data);
		alert(JSON.stringify(data));
		//alert(data);
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/capitaloperation/buy',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(result) {
						if (result.isBuyd) {
							$.messager.alert('提示信息', '购买成功');

							setTimeout("javascript:window.location.reload()",
									2000);

						}
					}
				});
	}

	function sale() {
		var data = $("#buyorsale").serializeArray();
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/capitaloperation/sale',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(result) {
						if (result.isSaled) {
							$.messager.alert('提示信息', '卖出成功');
							setTimeout("javascript:window.location.reload()",
									2000);
						}
					}
				});
	}
	
	function getBuy(){
		$
		.ajax({
			url : '${pageContext.request.contextPath}/admin/capitaloperation/getAllShowTfundacctList',
			type : 'post',
			dataType : 'json',
			success : function(result) {
				var fundacctList = result;
				var str = "[";
				for ( var i in fundacctList) {
					str += "{label:'" + i + "',value:'"
							+ fundacctList[i].fund_acct + "--["
							+ fundacctList[i].realname + "--"
							+ fundacctList[i].idno + "--余额"
							+ fundacctList[i].fund_balance + "]"
							+ "'},";
				}
				if (str.length>1) str = str.substring(0, str.length - 1);
				str+="]";
				$('#fund_acc')
						.combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(rec) {
										var fund_id = fundacctList[rec.label].fund_id;
										$("input[name='fund_id']")
												.attr("value", fund_id);
										var v = $('#type').combobox(
												'getValue');
										var balance = String(rec.value)
												.split("余额")[1];
										balance = balance.substring(0,
												balance.length - 1);
										//alert(balance)
										$("#balance").attr("value",
												balance);
										if (v == 2) {
											getOwnStocks(fund_id);
										}
									}
								})
			}
		})
	}
	
	function getSale(){
		$
		.ajax({
			url : '${pageContext.request.contextPath}/admin/capitaloperation/getAllShowTfundacctList2',
			type : 'post',
			dataType : 'json',
			success : function(result) {
				var fundacctList = result;
				var str = "[";
				for ( var i in fundacctList) {
					str += "{label:'" + i + "',value:'"
							+ fundacctList[i].fund_acct + "--["
							+ fundacctList[i].realname + "--"
							+ fundacctList[i].idno + "--余额"
							+ fundacctList[i].fund_balance + "]"
							+ "'},";
				}
				if (str.length>1) str = str.substring(0, str.length - 1);
				str+="]";
				$('#fund_acc')
						.combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(rec) {
										var fund_id = fundacctList[rec.label].fund_id;
										$("input[name='fund_id']")
												.attr("value", fund_id);
										var v = $('#type').combobox(
												'getValue');
										var balance = String(rec.value)
												.split("余额")[1];
										balance = balance.substring(0,
												balance.length - 1);
										//alert(balance)
										$("#balance").attr("value",
												balance);
										if (v == 2) {
											getOwnStocks(fund_id);
										}
									}
								})
			}
		})
	}

	function init() {
	

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
						$('#buy').combobox(
								{

									valueField : 'label',
									textField : 'value',
									data : eval(str),
									onSelect : function(rec) {
										var stock = stocklist[rec.label];
										$("input[name='stock_code']").attr(
												"value", stock.stock_code);
										$("input[name='stock_name']").attr(
												"value", stock.stock_name);
										$("input[name='seid_id']").attr(
												"value", stock.seid_id);
										$("input[name='seid_name']").attr(
												"value", stock.seid_name);
									}
								});
					}
				})

	}

	function checkMoneyIsEnough(flag) {
		var sl = $('#sl').numberbox('getValue');
		sl = sl.length == 0 ? 0 : parseInt(sl);
		//alert(sl);

		var now_price = $('#now_price').numberbox('getValue');
		now_price = now_price.length == 0 ? 0 : parseFloat(now_price);
		//alert(now_price);
		var balance = parseFloat($("#balance").val());
		if (sl * now_price > balance) {
			//alert("超出余额");
			if (flag) {
				$('#sl').numberbox('setValue', parseInt(balance / now_price))
			} else {
				$('#now_price').numberbox('setValue', parseFloat(balance / sl));
			}
		}
	}

	$(function() {

		$("input", $("#sl").next("span")).blur(function() {
			/* alert($('#type').combobox('getValue'));
			alert(this.value);
			alert($("#max").val());
			alert(this.value>$("#max").val());
			alert(this.value<$("#max").val()); */
			//alert($('#type').combobox('getValue'));
			if ($('#type').combobox('getValue') == 2) {
				if (parseInt(this.value) > parseInt($("#max").val())) {
					$('#sl').numberbox('setValue', $("#max").val());
					$("input[name='sl']").attr("value", $("#max").val());
					return;
				}
			} else {
				checkMoneyIsEnough(true);
			}

			$("input[name='sl']").attr("value", this.value);
		})
		$("input", $("#now_price").next("span")).blur(function() {
			if ($('#type').combobox('getValue') == 2) {
				$("input[name='now_price']").attr("value", this.value);
				return;
			}
			checkMoneyIsEnough(false);
			$("input[name='now_price']").attr("value", this.value);
		})
		$("input", $("#occurrence_fund").next("span")).blur(function() {
			//alert(1);
			$("input[name='occurrence_fund']").attr("value", this.value);
		})

		$('#type').combobox({

			valueField : 'label',
			textField : 'value',
			//data : eval(str),//JSON字符串转为JSON对象
			onSelect : function(rec) {
				$("#fm").form("clear");
				var v = rec.label;
				if (v == 3) {
					$("#stocks").css("display", "none");
					$("#money").css("display", "block");
					$('#button').linkbutton({
						text : '资金划转'
					});
					$("#button").attr("onclick", "record()");
				} else {
					$('#sale').combobox('clear');
					$('#sl').numberbox('clear');
					$('#now_price').textbox('clear');
					//$('#bz').textbox('clear');

					$("#stocks").css("display", "block");
					$("#money").css("display", "none");
					if (v == 1) {
						$('#button').linkbutton({
							text : '股票买入'
						});
						//$("#button").html("股票买入");
						$("#button").attr("onclick", "buy()");
						$("#buystock").css("display", "block");
						$("#salestock").css("display", "none");
						getBuy();

					} else {
						$('#button').linkbutton({
							text : '股票卖出'
						});
						//$("#button").html("股票卖出");
						$("#button").attr("onclick", "sale()");
						$("#buystock").css("display", "none");
						$("#salestock").css("display", "block");
						getOwnStocks(null);
						getSale();

					}
				}
			}
		});

	});

	function getOwnStocks(fund_id) {
		fund_id = fund_id == null ? $('#fund_acc').combobox('getValue')
				: fund_id;
		//alert(fund_id.length);
		if (String(fund_id).length > 0) {
			//alert("资金账户已选择，且为股票卖出业务");
			//alert("马上加载该账户已购买股票");
			$
					.ajax({
						url : '${pageContext.request.contextPath}/admin/capitaloperation/getStockamountListByFund_id',
						type : 'post',
						dataType : 'json',
						data : {
							"fund_id" : fund_id
						},
						success : function(result) {
							//alert(result)
							var stockamount = result;
							var str = "[";
							if (stockamount.length == 0) {
								$.messager.alert('提示信息', "该账户暂未持有股票");
								$('#sale').combobox({
									valueField : 'label',
									textField : 'value',
									data : [],
								});
								$('#sl').numberbox('clear');
								$('#now_price').textbox('clear');
								//$('#bz').textbox('clear');
								return;
							}
							for ( var i in stockamount) {
								str += "{label:'" + i + "',value:'"
										+ stockamount[i].stock_code + "--"
										+ stockamount[i].stock_name + "--数量"
										+ +stockamount[i].balance + "'},";
							}
							str = str.substring(0, str.length - 1) + "]";
							//	alert(str);
							//alert(str);
							$('#sale').combobox(
									{

										valueField : 'label',
										textField : 'value',
										data : eval(str),
										onSelect : function(rec) {
											$('#sl').numberbox('clear');
											$('#now_price').textbox('clear');
											//$('#bz').textbox('clear');
											var stock = stockamount[rec.label];
											/*  $('#sl').numberbox({
											    min:0,
											   max:stock.balance
											});  */
											//$("#_easyui_textbox_input11").attr("id","_easyui_textbox_input5");
											/* $("#sl").attr("min",0);
											$("#sl").attr("max",stock.balance); */
											$("#max").attr("value",
													stock.balance);
											$("input[name='stock_code']").attr(
													"value", stock.stock_code);
											$("input[name='stock_name']").attr(
													"value", stock.stock_name);
											$("input[name='seid_id']").attr(
													"value", stock.seid_id);
											$("input[name='seid_name']").attr(
													"value", stock.seid_name);
										}
									});

						}
					})
		}

	}

	function record() {
		var data = $("#record").serializeArray();
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/capitaloperation/record',
					type : 'post',
					dataType : 'json',
					data : data,
					success : function(result) {
						if (result.isRecorded) {
							$.messager.alert('提示信息','划拨成功');
							//window.location.reload();
							setTimeout("javascript:window.location.reload()",
									2000);
						}
					}
				});
	}
</script>


<script>
	function add() {
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
							//$("#tstockinfoList_data").datagrid("load");
							window.location.reload();
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

	function trade_date(date) {
		var DateRegExp = /^[1-2]\d{3}-(0[1-9]|1[0-2]){1}-(0[1-9]|[1-2][0-9]|3[0-1]){1}$/g;
		if (!DateRegExp.test(date))
			return;
		$("input[name='trade_date']").attr("value",
				$("#trade_date").datebox("getValue").replace(/-/g, ''));
	}
</script>
</head>
<body onload="init()">
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



	<div style="display: none;">
		<form id="buyorsale">

			<input name="fund_id" /> <input name="stock_code" /> <input
				name="stock_name" /> <input name="sl" /> <input name="now_price" />
			<input name="seid_id" /> <input name="seid_name" /> <input
				name="bz" /> <input name="trade_date" />

		</form>

		<form id="record">
			<input name="fund_id" /> <input name="occurrence_fund" /> <input
				name="type" value="113208" /> <input name="bz" value="划拨" />
		</form>

	</div>

	<div style="margin: -10px 0;"></div>
	<div class="easyui-panel" title="清算操作"
		style="width: 400px; padding: 30px 60px">
		<div style="margin-bottom: 10px">
			<div>业务类型:</div>
			<select id="type" class="easyui-combobox" style="width: 100%;">
				<option value="1">股票买入</option>
				<option value="2">股票卖出</option>
				<option value="3">资金划转</option>
			</select>
		</div>

		<div style="margin-bottom: 10px">
			<div>资金账户:</div>
			<input id="fund_acc" style="width: 100%;" />
		</div>
		<div id="stocks">

			<div style="margin-bottom: 10px" id="buystock">
				<div>请选择需要购买的股票:</div>
				<input id="buy" class="easyui-combobox"
					style="width: 80%; height: 32px"><a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconcls="icon-add" onclick="add()" plain="true">添加</a>
			</div>

			<div style="margin-bottom: 10px" id="salestock">
				<div>请选择需要卖出的股票:</div>
				<input id="sale" class="easyui-combobox"
					style="width: 100%; height: 32px">
			</div>

			<div style="margin-bottom: 10px">
				<div>数量:</div>
				<input id="sl" class="easyui-numberbox"
					style="width: 100%; height: 32px">
			</div>
			<div style="margin-bottom: 10px">
				<div>价格：</div>
				<input id="now_price" type="text" class="easyui-numberbox"
					data-options="min:0,precision:2" style="width: 100%">
				<div>日期:</div>
				<input class=" easyui-datebox" id="trade_date"
					data-options=" onChange:trade_date" style="width: 100%" />
			</div>


		</div>

		<div id="money">
			<div style="margin-bottom: 10px">
				<div>金额：</div>
				<input id="occurrence_fund" data-options="min:0,precision:2"
					class="easyui-numberbox" style="width: 100%; height: 32px">
			</div>
		</div>
		<div>
			<a id="button" href="javascript:;" class="easyui-linkbutton"
				iconCls="icon-ok" style="width: 100%; height: 32px"></a>
		</div>
	</div>


	<input type="hidden" id="max" />
	<input type="hidden" id="balance" />
</body>
</html>