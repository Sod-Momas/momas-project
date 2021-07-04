<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台首页</title>

		<script src="${pageContext.request.contextPath  }/easyui/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath  }/easyui/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath  }/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/easyui/themes/icon.css" />

		<script src="${pageContext.request.contextPath  }/commons/js/myDate.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath  }/commons/css/index.css" />
		
	</head>

	<body class="easyui-layout">
		<div id="nav-top" data-options="region:'north'">
			<div class="header">
				<div class="header-left"><img src="commons/img/logo.png" />
					<p>会员消费积分管理平台</p>
					<p>当前用户: <span>${LOGIN_USER.usersRealname}</span></p>
				</div>
				<div class="header-right">
					<p class="close"><a href="javascript:closeAll()">关闭全部</a></p>
					<p>
						<a class="manager" href="javascript:void(0)"></a>
					</p>
					<div id="manager-menu"  class="easyui-menu">
						<div>
							<a href="#" class="profile">修改个人资料</a>
						</div>
						<div>
							<a href="#" class="repassword">修改密码</a>
						</div>
						<div class="menu-sep"></div>   
						<div data-options="iconCls:'icon-remove'">
							<a href="${pageContext.request.contextPath }/user/logout">退出登录</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="nav-left" data-options="region:'west',title:'菜单导航',split:true">
			<div id="menus" >
				<div title="用户管理" >
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/shop/manage" >店铺管理</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/level/manage">会员等级管理</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/user/tomanage">用户管理</a>
						</li>
					</ul>
				</div>
				<div title="礼品管理">
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/gift/tomanage">礼品列表</a>
						</li>
					</ul>
				</div>
				<div title="会员管理">
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/member/tomanage">会员列表</a>
						</li>
					</ul>
				</div>
				<div title="会员消费">
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/consum/tofastconsum">快速消费</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/consum/toremovescore">会员减积分</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/consum/tohistory">消费历史记录</a>
						</li>
					</ul>
				</div>
				<div title="积分兑换">
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/exchange/toexchange">积分兑换礼品</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/exchange/toscoretomoney">积分反现</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/exchange/tohistory">兑换历史记录</a>
						</li>
					</ul>
				</div>
				<div title="统计中心">
					<ul>
						<li>
							<a data-url="${pageContext.request.contextPath }/statistics/tofastconsum">快速消费统计</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/statistics/toconsums">会员消费情况统计</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/statistics/toremovescore">减积分统计</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/statistics/toscore">积分返现统计</a>
						</li>
						<li>
							<a data-url="${pageContext.request.contextPath }/statistics/togiftex">礼品兑换统计</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div data-options="region:'center'">
			<div id="tabs"></div> 
		</div>
		<div data-options="region:'south'" style="height:50px;color:#FFF;text-align: center;background-color: #2e70cc;">
			<p>版权所有 &copy;2015 会员消费积分管理平台    <span id="date"></span></p>
			<script>
				setInterval("showTime()",1000);
				function showTime(){document.getElementById('date').innerText=myTime.showTime()}
			</script>
		</div>
		<div style="display: none; margin: 0 auto;">
			<iframe class="frm1" width="99%" height="99%" style="overflow: hidden;"  frameborder="0"></iframe>
		</div>
		<script>
			$(function() {
				$('#menus').accordion({
					animate: true,
					fit: true,
					border: false
				});
				$('.manager').menubutton({
					hasDownArrow: true,
					iconCls: 'icon-man',
					menu: '#manager-menu',
					text:'账号管理'
				});
				$('#tabs').tabs({    
				    border:false,
			    	closable:true,
				    fit: true,
				    onSelect:function(title){    
				        //alert(title+' is selected');    
				    }    
				}); 
				$(".profile").click(function() {
					$(".frm1").dialog({
						width : 400,
						height: 220
					}).dialog("setTitle", "修改个人资料").dialog("open");
					$(".frm1").attr("src", "${pageContext.request.contextPath}/user/personProfile");
				});
				
				$(".repassword").click(function() {
					$(".frm1").dialog({
						width : 350,
						height: 300
					}).dialog("setTitle", "修改密码").dialog("open");
					$(".frm1").attr("src", "${pageContext.request.contextPath }/user/toRepasswrod");
				});
				$("#menus ul li>a").click(function(){
					var src = $(this).attr("data-url");
					var title = $(this).text();
					var strHtml = '<iframe id="frmWorkArea" width="100%" height="99%" frameborder="0" scrolling="no" src="' + src + '"></iframe>';
					var isExists = $("#tabs").tabs('exists',title);
					if(!isExists){
						$("#tabs").tabs('add',{
							title:title,
							content: strHtml,
							iconCls: 'icon-ok',
							closable: true
						});
					}else{
						$('#tabs').tabs('select',title);
					}
				});
			})
		function closeAll(){
			var tabs = $("#tabs").tabs('tabs');
			for (var i = 0,length = tabs.length; i < length; i++) {
				$('#tabs').tabs('close',{which:i})
			}
		}
		</script>
	</body>

</html>