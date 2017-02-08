<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作员信息</title>
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
		$("#operator_data").datagrid({
			
			title : "操作员信息",
			width : "auto",
			height : "auto",
			border : true,
			collapsible : false,//是否可折叠的 
			url : "${pageContext.request.contextPath}/admin/operator/find",
			queryParams:{value:''},
			idField : 'id',
			singleSelect : true,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号  
			remoteSort : false,
			columns : [ [ {
				field : 'id',
				title : '系统编号',
				width : 100,
				align : 'center',
			}, {
				field : 'opcode',
				title : '工号',
				width : 100,
				align : 'center',
			}, {
				field : 'username',
				title : '用户名',
				width : 100,
				align : 'center',
			}, {
				field : 'password',
				title : '密码',
				width : 100,
				align : 'center',
				formatter:function(){
					return "********";
				}
			}, {
				field : 'realname',
				title : '真实姓名',
				width : 100,
				align : 'center',
			} , {
				field : 'login_time',
				title : '最新登录时间',
				width : 100,
				align : 'center',
			}, {
				field : 'input_time',
				title : '录入时间',
				width : 100,
				align : 'center',
			}] ],
			toolbar : "#toolbar",
			pageSize : 50,//每页显示的记录条数，默认为10 
			pageList : [ 50, 100 ],//可以设置每页记录条数的列表  

		});

		var p = $('#operator_data').datagrid('getPager');
		$(p).pagination({
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		$("#operator_data").datagrid("load", {
			"value" : value
		});
	}
</script>


<script>
var url;
	function add() {
		$("#dlg").dialog("open").dialog('setTitle', '新增操作员');
		$("#fm").form("clear");
		url="${pageContext.request.contextPath}/admin/operator/add";
	}

	function save() {
		$("#fm").form("submit", {
			url : url,
			onsubmit : function() {
				return $(this).form("validate");
			},
			success : function(result) {
				var obj = jQuery.parseJSON(result);
				if (obj.msg) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#operator_data").datagrid("load");
				} else {
					$.messager.alert("提示信息", "操作失败");
				}
			}
		});
	}
	
	function edit(){
		var row = $("#operator_data").datagrid("getSelected");
		if(!row) return;
		$("#dlg").dialog("open").dialog('setTitle', '修改信息');
		$("#fm").form("load", row);
		url = "${pageContext.request.contextPath}/admin/operator/update?id="
			+ row.id;
		
	}
	function del(){
		var row = $('#operator_data').datagrid('getSelected');
		if (row) {
			$.messager
					.confirm(
							'Confirm',
							'确定删除？',
							function(r) {
								if (r) {
									$
											.post(
													'${pageContext.request.contextPath}/admin/operator/delete',
													{
														id : row.id
													},
													function(result) {
														if (result.msg) {
															$('#operator_data')
																	.datagrid(
																			'reload'); // reload the user data  
														} else {
															$.messager
																	.show({ // show error message  
																		title : 'Error',
																		msg : result.errorMsg
																	});
														}
													}, 'json');
								}
							});
		}
	}
</script>
<script type="text/javascript">
$(function(){
	$("input[name='username']").blur(function(){
		//alert(this.value);
		$.ajax({
			url:"${pageContext.request.contextPath}/admin/operator/checkSame?username="+this.value,
			type:"post",
			dataType:"json",
			success:function(result){
				if(!result.msg){
					$.messager.alert("提示信息", "用户名已存在");
					$("input[name='username']").val("");
				}
			}
		})
	})
})
</script>
</head>
<body>
	<input type="hidden" id="param" value="" />
	<table id="operator_data" align="center">

	</table>

	<div id="toolbar">

		<div>
			<input class="easyui-searchbox" data-options="prompt:'请输入真实姓名或者用户名查询'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconcls="icon-add" onclick="add()" plain="true">新增</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton" 
				 iconcls="icon-edit" onclick="edit()" plain="true">修改</a>
				 <a href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-remove" plain="true" onclick="del()">删除</a>

		</div>

	</div>



	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">

		<form id="fm" method="post">
		<div class="fitem">
				<label>工号 </label> <input name="opcode"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>用户名</label> <input name="username"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>密码 </label> <input name="password"
					class="easyui-validatebox" type="password" required="true" />
			</div>
			<div class="fitem">
				<label>真实姓名 </label> <input name="realname"
					class="easyui-validatebox" required="true" />
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