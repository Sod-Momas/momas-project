<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>租房 - 用户管理</title>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.12.4.js"></script>
		<script type="text/javascript">function toUrl(url){window.location.href=url;}</script>
		<script>
			var ctx = '${ctx}';
			var isSearch = true;
			//这一段是为了刷新页面也不丢失选中值而写的
			var selectDistrictId = '${qb.districtId}';
			var selectStreetId =  '${qb.streetId}';
			var selectType = '${qb.typesId}';
		</script>
		<script>
			$(function(){
				loadTypes();
				$("#price").val('${qb.price}');
				$("#floorage").val('${qb.floorAge}');
			})
			
			function doSearch(pageNo){
				$("#pageNo").val(pageNo);
				$("#sform")[0].submit();
			}
		</script>
		<script type="text/javascript" src="${ctx}/js/commoms.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="${ctx}/images/logo.gif" />
				<div>
					欢迎登录，${sessionScope.LOGIN_USER.name}
				</div>
			</div>

			<div class="search">
				<label class="ui-green">
					<input
						onclick="toUrl('${ctx}/house/housetoAdd')"
						type="button" name="search" value="发布房屋信息" />
				</label>
				<label class="ui-green">
					<input type="button" name="search" value="退       出"
						onclick="toUrl('${ctx}/users/userlogout')" />
				</label>
			</div>
		</div>


		<div id="navbar" class="wrap">

			<form method="post" action="${ctx}/house/housesearch" id="sform">
				<input type='hidden' id='pageNo' name='pager.pageNo' value='1' />
				<dl class="search clearfix">

					<dd style="width: 300px">
						<ul>
							<li class="bold">
								房屋信息
							</li>
							<li>
								标题：
								<input type="text" class="text" placeholder="不限"
									value='<s:property value="qb.title"/>' name="qb.title" />
								<label class="ui-blue">
									<input type="button" onclick='doSearch(1)' name="search"
										value="搜索房屋" />
								</label>
							</li>
						</ul>
					</dd>
					<dd>
						<ul>
							<li class="first">
								价格
							</li>
							<li>
								<select name='qb.price' id='price'>
									<option value=''>
										不限
									</option>
									<option value='0-1000'>
										1000元以下
									</option>
									<option value='1000-2000'>
										1000元—2000元
									</option>
									<option value='2000-1000000'>
										2000元以上
									</option>
								</select>
							</li>
						</ul>
					</dd>
					<dd id="district" style="width: 250px; padding: 0 0 0 20px">
						<ul>
							<li class="first">
								房屋位置
							</li>
							<li>
								区：
								<select class="text" name="qb.districtId" id="district_id">
									<option value=''>
										不限
									</option>
								</select>
								街：
								<select class="text" name="qb.streetId" id="street_id">
									<option value=''>
										不限
									</option>
								</select>
							</li>
						</ul>
					</dd>
					<dd>
						<ul>
							<li class="first">
								房型
							</li>
							<li>
								<select name='qb.typesId' id='housetype'>
									<option value=''>
										不限
									</option>
								</select>
							</li>
						</ul>
					</dd>
					<dd>
						<ul>
							<li class="first">
								面积
							</li>
							<li>
								<select name='qb.floorAge' id='floorage'>
									<option value=''>
										不限
									</option>
									<option value='0-200'>
										200以下
									</option>
									<option value='200-300'>
										200-300
									</option>
									<option value='300-1000000'>
										300以上
									</option>
								</select>
							</li>
						</ul>
					</dd>


				</dl>
			</form>
		</div>


		<div class="main wrap">
			<table class="house-list">
				<s:if test="pager.list.size() eq 0">
					<tr>
						<td>
							无租房信息
						</td>
					</tr>
				</s:if>
				<s:else>
					<s:iterator value="pager.list" var="h">
						<tr>
							<td class="house-thumb">
								<span>
									<a href="show?id='#">
										<s:if test="#h.pic eq null">
											<img src="${ctx}/images/thumb_house.gif" />
										</s:if>
										<s:else>
											<img src="${ctx}/upload/house/small_${h.pic}" />
										</s:else>
									</a>
								</span>
							</td>
							<td>
								<dl>
									<dt>
										<a href="#"><s:property value="#h.title"/> </a>
									</dt>
									<dd>街区名:<s:property value="#h.street.district.name"/></dd>
									<dd>街道名：<s:property value="#h.street.name"/></dd>
									<dd>面积：<s:property value="#h.floorage"/></dd>
									<dd>联系方式：<s:property value="#h.contact" /></dd>
								</dl>
							</td>
							<td class="house-type">
								<s:property value="#h.types.name" />
							</td>
							<td class="house-price">
								<s:property value="#h.price" />元/月
							</td>
						</tr>
					
					</s:iterator>
					
				</s:else>
			
			</table>
			
			<div class="pager">
				<ul>
					<s:if test="pager.pageNo eq 1">
						<li class="current"><a href="#">首页</a></li>
						<li><a href="#">上一页</a></li>
					</s:if>
					<s:else>
						<li class="current"><a href="javascript:doSearch(1)">首页</a></li>
						<li><a href="javascript:doSearch(${pager.pageNo - 1})">上一页</a></li>
					</s:else>
					
					<s:if test="pager.pageNo eq pager.totalPageCount">
						<li><a href="#">下一页</a></li>
						<li class="current"><a>末页</a></li>
					</s:if>
					<s:else>
						<li><a href="javascript:doSearch(${pager.pageNo + 1})">下一页</a></li>
						<li><a href="javascript:doSearch(${pager.totalPageCount})">末页</a></li>
					</s:else>
						
				</ul>
				<span class="total">
					当前第${pager.pageNo}页/共<s:property value="pager.totalPageCount" />页
				</span>
			</div>
			
		</div>
		<div id="footer" class="wrap">
			<dl>
				<dt>
					租房 &copy; 2010 京ICP证1000001号
				</dt>
				<dd>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</dd>
			</dl>
		</div>
	</body>
</html>
