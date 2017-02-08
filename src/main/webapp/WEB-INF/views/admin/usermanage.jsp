<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/md5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		$("#userlist_data").datagrid({
			pageSize : 50,//每页显示的记录条数，默认为10 
			pageList : [ 50, 100 ],//可以设置每页记录条数的列表  
			title : "用户信息管理",
			width : "100%",
			height : "auto",
			collapsible : false,//是否可折叠的 
			url : "${pageContext.request.contextPath}/admin/user/search",
			queryParams : {
				value : ''
			},
			idField : 'id',
			singleSelect : true,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号  
			remoteSort : false,
			columns : [ [ {
				field : 'id',
				title : '系统编号',
				width : 60,
				align : 'center',
			}, {
				field : 'username',
				title : '用户名',
				width : 70,
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
				field : 'idno',
				title : '身份证号',
				width : 150,
				align : 'center',
			}, {
				field : 'realname',
				title : '真实姓名',
				width : 60,
				align : 'center',
			}, {
				field : 'mobile',
				title : '手机号码',
				width : 100,
				align : 'center',
			}, {
				field : 'address',
				title : '地址',
				width : 100,
				align : 'center',
			}, {
				field : 'email',
				title : '邮箱',
				width : 150,
				align : 'center',
			}, {
				field : 'login_time',
				title : '最近登录时间',
				width : 150,
				align : 'center',
			}, {
				field : 'input_time',
				title : '注册时间',
				width : 150,
				align : 'center',
			} ] ],
			toolbar : "#toolbar"

		});

		var p = $('#userlist_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 10,//每页显示的记录条数，默认为10 
			//pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',

		});
	})

	function doSearch(value) {
		$("#userlist_data").datagrid("load", {
			value : value
		});
	}
</script>
<script type="text/javascript">
	var url;
	var type;
	function newuser() {
		//alert(1);
		$("#dlg").dialog("open").dialog('setTitle', '新建用户');
		;
		$("#fm").form("clear");
		$("input[name='idno']").removeAttr("readonly");
		$("input[name='realname']").removeAttr("readonly");
		$("input[name='password']").removeAttr("readonly");
		$("input[name='mobile']").removeAttr("readonly");
		url = "${pageContext.request.contextPath}/admin/user/save";
		document.getElementById("hidtype").value = "submit";
		type=1;
	}
	function edituser() {
		type=2;
		var row = $("#userlist_data").datagrid("getSelected");

		if (row) {
			$("#dlg").dialog("open").dialog('setTitle', '修改用户');
			$("#fm").form("load", row);
			$("input[name='idno']").attr("readonly", "readonly");
			$("input[name='realname']").attr("readonly", "readonly");
			$("input[name='password']").attr("readonly", "readonly");
			$("input[name='mobile']").attr("readonly", "readonly");
			url = "${pageContext.request.contextPath}/admin/user/update?id="
					+ row.id;
		}
	}
	function saveuser() {
		var flag=$("#fm").form("validate");
		if(!flag) return;
		if(type==1)
			$("input[name='password']").val(
					hex_md5($("input[name='password']").val()));
		
		$("#fm").form("submit", {
			url : url,
			onsubmit : function() {
				return $(this).form("validate");
			},
			success : function(result) {
				var obj = jQuery.parseJSON(result);
				//alert(obj.msg);
				if (obj.msg) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#userlist_data").datagrid("load");
				} else {
					$.messager.alert("提示信息", "操作失败");
				}
			}
		});
	}
	function destroyUser() {
		var row = $('#userlist_data').datagrid('getSelected');
		if (row) {
			$.messager
					.confirm(
							'Confirm',
							'确定删除？',
							function(r) {
								if (r) {
									$
											.post(
													'${pageContext.request.contextPath}/admin/user/delete',
													{
														id : row.id
													},
													function(result) {
														if (result.msg) {
															$('#userlist_data')
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
			 var username=this.value;
			if(type!=1) return;
			$.ajax({
				url:'${pageContext.request.contextPath}/admin/user/checkSameUsername',
				type:'post',
				data:{username:username},
				dataType:"json",
				success:function(result){
					if(!result.msg){
						$.messager.alert("提示信息", "用户名已存在");
						$("input[name='username']").val("");
					}
				}
			})  
			
		}); 
		$("input[name='password']").blur(function(){
			if(type!=1) return;
			var password=this.value;
			var reg=/^[a-zA-Z0-9]{8,16}$/;
			if(!reg.test(password)){
				$.messager.alert("提示信息", "密码只能由数字、字母组成。长度8~16");
				$(this).val("");
			}
		});
		$("input[name='idno']").blur(function(){
			if(type!=1) return;
			var idno=this.value;
			var reg=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
			if(!reg.test(idno)){
				$.messager.alert("提示信息", "身份证格式不正确");
				$(this).val("");
			}
		});
		
		$("input[name='mobile']").blur(function(){
			if(type!=1) return;
			var mobile=this.value;
			var reg=/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
			if(!reg.test(mobile)){
				$.messager.alert("提示信息", "手机号格式不正确");
				$(this).val("");
				return;
			}
			
			$.ajax({
				url:'${pageContext.request.contextPath}/admin/user/checkMobile',
				type:'post',
				data:{phone:mobile},
				dataType:'json',
				success:function(result){
					if(!result.msg){
						$.messager.alert("提示信息", "手机号码已存在");
						$("input[name='mobile']").val("");
					}
				}
			})
		});
		
		
		$("input[name='email']").blur(function(){
			var email=this.value;
			var reg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			if(!reg.test(email)){
				$.messager.alert("提示信息", "邮箱格式有误");
				$(this).val("");
			}
		});
		
	});
</script>
</head>
<body>

	<table id="userlist_data" align="center">

	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-add" onclick="newuser()" plain="true">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-edit" onclick="edituser()" plain="true">修改</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
		<div style="float: right; margin-right: 250px;">
			<input class="easyui-searchbox" data-options="prompt:'输入姓名或者身份证号码搜索'"
				style="width: 200px; vertical-align: middle;" searcher="doSearch"></input>

		</div>
	</div>



	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">信息编辑</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label> 用户名 </label> <input name="username"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label> 密码</label> <input name="password" type="password"
					class="easyui-validatebox" required="true"  readonly="readonly" />
			</div>
			<div class="fitem">
				<label> 身份证号码</label> <input name="idno" class="easyui-validatebox"
					required="true" readonly="readonly" />
			</div>
			<div class="fitem">
				<label> 真实姓名</label> <input name="realname"
					class="easyui-vlidatebox" required="true"  readonly="readonly" />
				<!--class="easyui-datebox"  -->
			</div>
			<div class="fitem">
				<label> 手机号码</label> <input name="mobile" class="easyui-vlidatebox"  readonly="readonly" />
			</div>
			<label>
				<div class="fitem">地址
			</label> <input name="address" class="easyui-vlidatebox" />
	</div>
	<label>
		<div class="fitem">邮箱
	</label>
	<input name="email" class="easyui-vlidatebox" />
	</div>
	<input type="hidden" name="action" id="hidtype" />
	<input type="hidden" name="ID" id="Nameid" />
	</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>


</body>
</html>