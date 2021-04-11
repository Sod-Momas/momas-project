<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	if (null != session.getAttribute("LOGIN_USER")) {
		response.sendRedirect(request.getContextPath()
				+ "/controller/doQuerypage.jsp?pageNo=1");
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
	</head>

	<body>
		<form
			action="<%=request.getContextPath() + "/controller/doLogin.jsp"%>"
			method="post"
			style="width: 300px; margin: 0 auto; text-align: center;">
			<table>
				<tr>
					<td>
						<label for="uname">
							用户名
						</label>
					</td>
					<td>
						<input type="text" name="uname" id="uname" value="" />
					</td>
				</tr>
				<tr>
					<td>
						<label for="upwd">
							密 码
						</label>
					</td>
					<td>
						<input type="password" name="upwd" id="upwd" value="" />
					</td>
				</tr>
				<!-- 
					<tr>
						<td colspan="2">
							<input type="checkbox" name="rememberme" id="rememberme" value="" />
							<label for="rememberme">
								记住我(暂时无效)
							</label>
						</td>
					</tr> 
				-->
				<%
					
					if (null != request.getParameter("err")) {
				%>
				<tr>
					<td colspan="2">
						<strong><font color="red">用户名或密码错误!</font>
						</strong>
					</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="登录" />
						<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>