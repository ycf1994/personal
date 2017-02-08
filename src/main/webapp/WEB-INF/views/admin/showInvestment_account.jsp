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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/numFormat.js"></script>
<script type="text/javascript">
	$(function() {
		//linkUrl = $("#linkUrl").val();
		//alert(linkUrl);
		$("#showInvestment_account_data").datagrid({
			pageSize : 50,//每页显示的记录条数，默认为10 
			pageList : [ 50, 100 ],//可以设置每页记录条数的列表  ,
			title : "用户投资资金信息",
			width : "auto",
			height : "auto",
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			url : "${pageContext.request.contextPath}/admin/showInvestment_account/getAllShowInvestment_accountList",
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
				field : 'investment_account_no',
				title : '资金编号',
				width : 110,
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
			},  {
				field : 'idno',
				title : '身份证号',
				width : 160,
				align:'center', 
			},{
				field : 'money',
				title : '入账金额',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'balance',
				title : '余额',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'ytx',
				title : '已提现',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'dsh',
				title : '待审核',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'interest_rate',
				title : '活期利率',
				width : 100,
				align:'center', 
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
				align:'center', 
			}, {
				field : 'start_date',
				title : '开始日期',
				width : 100,
				align:'center', 
			}, {
				field : 'end_date',
				title : '结束日期',
				width : 100,
				align:'center', 
			}, {
				field : 'hetong',
				title : '合同明细',
				width : 100,
				align:'center', 
				formatter:function(value, row, index){  
					
					if(row.money==(row.balance+row.ytx+row.dsh)) return "暂无合同";
					  return '<a href="javascript:;" name="opera" class="easyui-linkbutton" iconCls="icon-tip" onclick="findContract(\''+row.investment_account_no +'\',1)"  >查看合同</a>';  
					 
				}
			}] ],
			onLoadSuccess:function(data,row,index){  
				
		        $("a[name='opera']").linkbutton({plain:true}); 

				
		},
			//toolbar : "#toolbar"
			toolbar : "#toolbar"

		});

		var p = $('#showInvestment_account_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})
	
	function doSearch(value){
		$("#showInvestment_account_data").datagrid({

			title : "用户投资资金信息",
			width : "auto",
			height : "auto",
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			url : "${pageContext.request.contextPath}/admin/showInvestment_account/searchShowInvestment_account?value="+value,
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
				field : 'investment_account_no',
				title : '资金编号',
				width : 110,
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
			},  {
				field : 'idno',
				title : '身份证号',
				width : 160,
				align:'center', 
			},{
				field : 'money',
				title : '入账金额',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'balance',
				title : '余额',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'ytx',
				title : '已提现',
				width : 200,
				align:'center', 
				formatter : function(
						value) {
					return parseFloat(
							value * 100)
							.toFixed(2)
							+ '%';
				}
			}, {
				field : 'dsh',
				title : '待审核',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			}, {
				field : 'interest_rate',
				title : '活期利率',
				width : 100,
				align:'center', 
				formatter : function(
						value) {
					return parseFloat(
							value * 100)
							+ '%';
				}
			}, {
				field : 'input_time',
				title : '录入时间',
				width : 100,
				align:'center', 
			}, {
				field : 'start_date',
				title : '开始日期',
				width : 100,
				align:'center', 
			}, {
				field : 'end_date',
				title : '结束日期',
				width : 100,
				align:'center', 
			}, {
				field : 'hetong',
				title : '合同明细',
				width : 100,
				align:'center', 
				formatter:function(value, row, index){  
					
					if(row.money==(row.balance+row.ytx+row.dsh)) return "暂无合同";
					  return '<a href="javascript:;" name="opera" class="easyui-linkbutton" iconCls="icon-tip" onclick="findContract(\''+row.investment_account_no +'\',1)"  >查看合同</a>';  
					 
				}
			}] ],
			onLoadSuccess:function(data,row,index){  
				
		        $("a[name='opera']").linkbutton({plain:true}); 

				
		},
			//toolbar : "#toolbar"
			toolbar : "#toolbar",
			pageSize : 50,//每页显示的记录条数，默认为10 
			pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

		});

		var p = $('#showInvestment_account_data').datagrid('getPager');
		$(p).pagination({
		//	pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
		
	}
</script>
<script type="text/javascript">
	function findContract(investment_account_no){
		$("#showContract").dialog("open");
		$("#showContract_data").datagrid({
			pageSize : 50,//每页显示的记录条数，默认为10 
			pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
			title : "合同",
			width : "1280px",
			height : "auto",
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			url : "${pageContext.request.contextPath}/admin/contract/searchContract?investment_account_no="+investment_account_no,
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
				field : 'contract_no',
				title : '合同编号',
				width : 122,
				align:'center', 
			}, {
				field : 'cust_id',
				title : '借款ID',
				width : 50,
				align:'center', 
			}, {
				field : 'contract_money',
				title : '投资金额',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
			},  {
				field : 'sign_date',
				title : '签署日期',
				width : 85,
				align:'center', 
			},{
				field : 'start_date',
				title : '开始日期',
				width : 85,
				align:'center', 
			}, {
				field : 'end_date',
				title : '结束日期',
				width : 85,
				align:'center', 
			}, {
				field : 'investment_rate',
				title : '投资利率',
				width : 100,
				align:'center', 
				formatter : function(
						value) {
					return parseFloat(
							value * 100)
							.toFixed(3)
							+ '%';
				}
			}, {
				field : 'states',
				title : '合同状态',
				width : 60,
				align:'center', 
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
						return "作废";
					}
				}
			}, {
				field : 'check_time',
				title : '审核时间',
				width : 85,
				align:'center', 
				
			}, {
				field : 'check_name',
				title : '审核人',
				width : 80,
				align:'center', 
				
			}, {
				field : 'wanjie_time',
				title : '完结时间',
				width : 85,
				
			}, {
				field : 'iscontinue',
				title : '进行中？',
				width : 50,
				
			}, {
				field : 'input_time',
				title : '录入时间',
				width : 85,
				
			}, {
				field : 'invest_gain',
				title : '预期收益',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
				
			}, {
				field : 'sum_gain',
				title : '累计收益',
				width : 200,
				align:'center', 
				formatter : function(
						value) {

					return numFormat(value)
							+ "元";
				}
				
			},
			{
				field : 'fund_id',
				title : '查看',
				width : 100,
				align:'center', 
				formatter : function(value) {
					return '<a href="javascript:;" name="opera" class="easyui-linkbutton" iconCls="icon-star" onclick="findStock(\''+value +'\',1)"  >查看股票</a>';  
				}
				
			}
			] ],
			onLoadSuccess:function(data,row,index){  
				
		        $("a[name='opera']").linkbutton({plain:true}); 

				
		},
			
		});

		var p = $('#showContract_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	}
	
</script>


<script type="text/javascript">
function findStock(fund_id){
	//alert(fund_id);
	$("#showStock").dialog("open");
	$("#showStock_data").datagrid({
		pageSize : 50,//每页显示的记录条数，默认为10 
		pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
		title : "合同",
		width : "600px",
		height : "auto",
		nowrap : false,
		striped : true,
		border : true,
		collapsible : false,//是否可折叠的 
		url : "${pageContext.request.contextPath}/admin/stockamount/searchStockamount?fund_id="+fund_id,
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
			field : 'seid_id',
			title : '市场编号',
			width : 100,
			align:'center', 
		},  {
			field : 'seid_name',
			title : '市场名称',
			width : 100,
			align:'center', 
		},{
			field : 'balance',
			title : '持有数量',
			width : 100,
			align:'center', 
		}
		] ],
	
		
	});

	var p = $('#showStock_data').datagrid('getPager');
	$(p).pagination({
		//pageSize : 10,//每页显示的记录条数，默认为10 
		//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
		beforePageText : '第',//页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

	});
}

</script>

<script type="text/javascript">
function add() {
	$("#dlg").dialog("open").dialog('setTitle', '新增资金');
	$("#fm").form("clear");
	$.ajax({
		url:"${pageContext.request.contextPath}/admin/showInvestment_account/findUsers",
		type:"post",
		dataType:"json",
		success:function(result){
			var str="[";
			for(var i in result){
				str+="{\"value\":\""+result[i].id+"\",\"text\":\""+result[i].username+"["+result[i].realname+"]"+"\"},"
			}
			if(str.length>1) str=str.substring(0,str.length-1);
			str+="]";
			$("input[name='user_id']")
			.combobox(
					{

						valueField : 'value',
						textField : 'text',
						data:eval(str),
						onSelect : function(rec) {
							
						}
					});
			
			
		}
	})
	
	
	$("#end_date").datebox("setValue","2099-12-31");
	
	
}

function save(){
	$("#fm").form("submit", {
		url : "${pageContext.request.contextPath}/admin/showInvestment_account/addInvestment_account",
		onsubmit : function() {
			return $(this).form("validate");
		},
		success : function(result) {
			var obj = jQuery.parseJSON(result);
			//alert(obj.msg);
			if (obj.msg) {
				$.messager.alert("提示信息", "操作成功");
				$("#dlg").dialog("close");
				$("#showInvestment_account_data").datagrid("load");
			} else {
				$.messager.alert("提示信息", "操作失败");
			}
		}
	});
}
</script>
</head>
<body>
<table id="showInvestment_account_data" align="center">

	</table>
	
	
	<div id="toolbar">
		
			<div>
		<input class="easyui-searchbox" data-options="prompt:'输入姓名或者用户名搜索'" style="width:200px;vertical-align:middle;" searcher="doSearch"></input>  
              <a href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-add" onclick="add()" plain="true">新增</a> 
               </div>  
              
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div title="查看合同" id="showContract" class="easyui-dialog"
		style="width: 1250px; height:auto; padding: 10px 20px;" closed="true">
		<table id="showContract_data" align="center"></table>
	</div>
	
	
	<div title="查看股票" id="showStock" class="easyui-dialog"
		style="width: 600px; height:auto; padding: 10px 20px;" closed="true">
		<table id="showStock_data" align="center"></table>
	</div>
	
	
	
	
	
	
	
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">新增资金</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label> 用户名 </label> <input name="user_id"
					  required="true" />
			</div>
			<div class="fitem">
				<label> 金额</label> <input name="money" class="easyui-numberbox" precision="2"
					 required="true" />
			</div>
			<div class="fitem">
				<label> 银行卡号</label> <input name="bank_card" class="easyui-validatebox"
					required="true"  />
			</div>
			<div class="fitem">
				<label> 银行名称</label> <input name="bank_name" class="easyui-vlidatebox"
					required="true" />   <!--class="easyui-datebox"  -->
			</div>
			<div class="fitem">
				<label> 活期利率</label> <input name="interest_rate" class="easyui-numberbox" precision="2" required="true" />%
			</div>
			<div class="fitem" >
				<label>计息起始日期</label><input class="easyui-datebox" required="true"
					id="start_date" data-options="onChange:start_date" />
			</div>
			<div class="fitem" >
				<label>计息结束日期</label><input class="easyui-datebox" required="true"
					id="end_date" data-options="onChange:end_date" />
			</div>
			<input name="start_date" type="hidden" required="true"  />
			<input name="end_date" type="hidden" required="true" value="2099-12-31" />
			
	</form>
	</div>
	
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="save()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
	
	
	
</body>

<script type="text/javascript">
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
</script>
</html>