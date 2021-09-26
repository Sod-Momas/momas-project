<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<base href="${pageContext.request.contextPath }/"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台首页</title>
		<%@include file="importJsAndCss.jsp" %>		
		<style type="text/css">
			.header {
				width: 100%;
				height: inherit;
				overflow: hidden;
				color: #000;
				overflow-wrap: break-word;
				font-size: 15px;
			}
			.header-left {
				height: inherit;
				display: inline-block;
			}
			.header-left>* {
				display: inline-block;
				margin-right: 20px;
				vertical-align: middle;
			}
			.header-right {
				float: right;
				height: inherit;
				display: inline-block;
			}
			.header-right>* {
				display: inline-block;
				margin-right: 15px;
				vertical-align: middle;
			}
			a{
				text-decoration: none;
				color: black;
			}
		</style>
	</head>

	<body class="easyui-layout">

		<div data-options="region:'north'">
			<div class="header">
				<div class="header-left"><img width="68px" height="55px" src="commons/img/logo.png" />
					<p>物流管理系统</p>
					<p>当前用户: <span>${LOGIN_USER.username}</span></p>
				</div>
				<div class="header-right">
					<p>
						<a class="easyui-menubutton" href="javascript:void(0)" data-options="menu:'#theme-menu',iconCls:'icon-edit'">切换主题</a>
					</p>
					<div id="theme-menu"  class="easyui-menu">
						<script type="text/javascript">
							function changetheme(str){
								$("body").fadeOut('fast',function(){
									var links = document.getElementsByTagName("link");
									var link = null;
									for (var i = 0; i < links.length; i++) {
										if(links[i].href.substr(-10) == "easyui.css"){
											link = links[i];
										}
									}
									link.href="${pageContext.request.contextPath}/statics/easyui/themes/"+str+"/easyui.css";
									
									//对iframe进行更换主题
									var iframes = document.getElementsByTagName('iframe');
									for (var i = 0; i < iframes.length; i++) {
										links = iframes[i].contentDocument.getElementsByTagName('link');
										for (var j = 0; j < links.length; j++) {
											if(links[j].href.substr(-10) == "easyui.css"){
												link = links[j];
											}
										}
										link.href="${pageContext.request.contextPath}/easyui/themes/"+str+"/easyui.css";
									}
									//删除变量降低内存占用
									i = null;
									j = null;
									links = null;
									link = null;
								});
								$("body").fadeIn();
							}
						</script>
						<div>
							<a href="javascript:void(0)" onclick="changetheme('default')" >默认主题</a>
						</div>
						<div>
							<a href="javascript:void(0)"  onclick="changetheme('ui-sunny')" >晴天主题</a>
						</div>
						<div>
							<a href="javascript:void(0)"  onclick="changetheme('metro')" >扁平主题</a>
						</div>
						<div>
							<a href="javascript:void(0)"  onclick="changetheme('bootstrap')" >bootstrap</a>
						</div>
						<div>
							<a href="javascript:void(0)"  onclick="changetheme('material')" >material</a>
						</div>
					</div>
					<p>
						<a class="easyui-menubutton" href="javascript:void(0)" data-options="menu:'#manager-menu',iconCls:'icon-edit'">账户管理</a>
					</p>
					<div id="manager-menu"  class="easyui-menu">
						<div>
							<a href="javascript:void(0)" >修改个人资料</a>
						</div>
						<div>
							<a href="javascript:void(0)" >修改密码</a>
						</div>
						<div class="menu-sep"></div>   
						<div data-options="iconCls:'icon-remove'">
							<a href="${pageContext.request.contextPath }/user/logout">退出登录</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div data-options="region:'west',title:'菜单导航',split:true" style="width:150px;">
			<!-- 西部区域  accordion折叠面板 -->
			<div class="easyui-accordion" data-options="fit:'true'">
				<!-- 使用div表示每个面板 -->
				<div  title="基本功能">
					<ul id="treeMenu" class="ztree"></ul>
				</div>
				<div  title="系统管理">
					<ul id="systemMgr" class="ztree"></ul>
				</div>
			</div>
		</div> 
		<div data-options="region:'center'">
			<!-- 中心区域 -->
			<div id="tabs" class="easyui-tabs" data-options="fit:true">
			<div title="消息中心">
				<div id="dd" class="easyui-draggable" data-options="handle:'#p'" style="width:100px;height:100px;">    
					<div id="p" class=" easyui-panel" title="My Panel"     
					        style="width:500px;height:150px;padding:10px;background:#fafafa;"   
					        data-options="iconCls:'icon-save',closable:true,    
					                collapsible:true,minimizable:true,maximizable:true">   
					    <p>panel content.</p>   
					    <p>panel content.</p>   
					</div>  
					
					<!-- 
					<div class="easyui-window" data-options="title:'消息中心',collapsible:false,minimizable:false,maximizable:false">
						<div style="width:300px;height:300px;">
							<p>消息内容</p>
						</div>
					</div> 
					-->
				</div>
			</div>
		</div>
		</div>
		<!-- 
		<div style="width:100px" data-options="region:'east'">
			东部区域
		</div>
		-->
		<div style="height:50px;" data-options="region:'south'">
			
			<p style="text-align: center;">沅有水兮澧有兰&copy;2010 - <%= new Date().toString() %></p>
		</div>
		<script type="text/javascript">
		$(function() {
			var setting = {
					data:{
						simpleData: {
							enable: true,
							idKey: "authFuctionId",
							pIdKey: "pid",
							rootPId: 0, 
						}
					},
					callback:{
						onClick : function(event,treeId,treeNode,clickFlag){
							//判断树菜单节点是否含有page属性
							if(treeNode.page != undefined&&treeNode.page!=""){
								var content =
									'<div style="width:100%;height:100%;overflow:hidden;"><iframe src="${pageContext.request.contextPath}/'
									+ treeNode.page
									+ '"scrolling="auto" style="width:100%;height:100%; scrolling:none;border:0;"></iframe></div>';
								if($("#tabs").tabs('exists',treeNode.name)){//判断tab是否存在
									$('#tabs').tabs('select',treeNode.name);//切换tab
									var tab = $("#tabs").tabs('getSelected');
									$('#tabs').tabs('update',{
										tab:tab,
										options:{
											title:treeNode.name,
											content : content
										}
									});
								}else{
									//开启一个新的tab页面
									$('#tabs').tabs('add',{
										title:treeNode.name,
										content : content,
										closable:true
									});
								}
							}
						}
					}
				};
			
				$.ajax({
					url : '${pageContext.request.contextPath}/function/findMenu',
					type : 'POST',
					dataType :'text',
					success : function(data){
						var zNodes = eval("("+data+")");
						$.fn.zTree.init($("#treeMenu"),setting,zNodes);
					},
					error:function(msg){
						$.messager.alert('警告','菜单加载异常');
					}
				});
				
				$.fn.zTree.init($("#systemMgr"),setting,[
								{
									"authFuctionId":1,
									"pid":"0",
									"name":"用户管理",
									"page":"index/system/user"
								},
									{
									"authFuctionId":2,
									"pid":"0",
									"name":"功能权限管理",
									"page":"index/system/authz"
								},
									{
									"authFuctionId":3,
									"pid":"0",
									"name":"角色管理",
									"page":"index/system/role"
								},
							]
				);
				
			})
			
			
		</script>
		
	</body>

</html>