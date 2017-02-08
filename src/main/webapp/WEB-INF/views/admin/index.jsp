<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>私人定制后台管理系统</title>
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
<script type="text/javascript">
	$(function() {
		//动态菜单数据

		var treeData = [ {
			text : "菜单",
			children : [
					{
						text : "用户管理",
						attributes : {
							url : '${pageContext.request.contextPath}/admin/user/manage'
						}
					},
					{
						text : "操作员管理",
						attributes : {
							url : '${pageContext.request.contextPath}/admin/operator/operator'
						}
					},
					{
						text : "资金管理",
						//state : "closed",
						children : [
								{
									text : "账户信息",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showAccount/showAccount"
									}
								},
								{
									text : "资金变动",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showInvestment_account/showInvestment_account"
									}
								},
								{
									text : "流水日志",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showFlow/showFlow"
									}
								},
								{
									text : "资金收益",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showInterest/showInterest"
									}
								},
								{
									text : "提现审核",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/userCarry/userCarry"
									}
								} ],
					},
					{
						text : "投资管理",
						//state : "closed",
						children : [
								{
									text : "合同信息",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showContract/showContract"
									}
								},
								{
									text : "借款人信息",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/cust/cust"
									}
								},
								{
									text : "合同审核",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showContract/checkContract"
									}
								} ]
					},
					{
						text : "清算管理",
						//state : "closed",
						children : [
								{
									text : "股票信息",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/tstockinfo/tstockinfo"
									}
								},
								{
									text : "资金账户",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/tfundacct/tfundacct"
									}
								},
								{
									text : "清算操作",
									attributes : {
										url : " ${pageContext.request.contextPath}/admin/capitaloperation/buystock"
									}
								},
								{
									text : "股票买卖明细",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/showStock/showStock"
									}
								},
								{
									text : "股票行情",
									attributes : {
										url : "${pageContext.request.contextPath}/admin/hqinfo/hqinfo"
									}
								} ],
					} ]
		} ];

		$("#tree").tree({
			data : treeData,
			lines : true,
			onClick : function(node) {
				if (node.attributes) {
					Open(node.text, node.attributes.url);
				}
			}
		});

		//绑定tabs的右键菜单
		$("#tabs").tabs({
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#tabsMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);
			}
		});

		//实例化menu的onClick事件
		$("#tabsMenu").menu({
			onClick : function(item) {
				CloseTab(this, item.name);
			}
		});
	});

	//在右边center区域打开菜单，新增tab
	function Open(text, url) {
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		if ($("#tabs").tabs('exists', text)) {
			$('#tabs').tabs('select', text);
			var currTab = $('#tabs').tabs('getTab', text);
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : content,
					closable : true
				}
			});
		} else {
			$('#tabs').tabs('add', {
				title : text,
				closable : true,
				content : content
			});
		}
	}

	//几个关闭事件的实现
	function CloseTab(menu, type) {
		var curTabTitle = $(menu).data("tabTitle");
		var tabs = $("#tabs");

		if (type === "close") {
			tabs.tabs("close", curTabTitle);
			return;
		}

		var allTabs = tabs.tabs("tabs");
		var closeTabsTitle = [];

		$.each(allTabs, function() {
			var opt = $(this).panel("options");
			if (opt.closable && opt.title != curTabTitle && type === "Other") {
				closeTabsTitle.push(opt.title);
			} else if (opt.closable && type === "All") {
				closeTabsTitle.push(opt.title);
			}
		});

		for (var i = 0; i < closeTabsTitle.length; i++) {
			tabs.tabs("close", closeTabsTitle[i]);
		}
	}
</script>
</head>
<body>
	<h2 align="center">
		私人定制后台管理系统<br />
		<h3 align="right" style="margin-right: 200px;">
			<span><c:if test="${admin!=null}">admin 已登录</c:if> <c:if
					test="${operator!=null}">${operator.realname} 已登录  最近登录时间 ${operator.login_time}</c:if></span>
			<a style="margin-left: 30px;"
				href="${pageContext.request.contextPath}/admin/logout"
				class="easyui-linkbutton" iconCls="icon-no">注销</a>
		</h3>
	</h2>

	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 800px;">



		<div data-options="region:'west',split:true" title="菜单栏"
			style="width: 150px;">
			<ul id="tree"></ul>
		</div>
		<div
			data-options="region:'center',iconCls:'icon-star_bronze_half_grey'">
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
				<div title="首页">
					<h1>欢迎使用私人定制后台管理系统</h1>

				</div>

			</div>
		</div>
	</div>
	<div id="tabsMenu" class="easyui-menu" style="width: 120px;">
		<div name="close">关闭</div>
		<div name="Other">关闭其他</div>
		<div name="All">关闭所有</div>
	</div>
</body>
</html>