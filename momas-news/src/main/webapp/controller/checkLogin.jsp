<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("LOGIN_USER") == null) {
		response.sendRedirect(request.getContextPath() + "/");
	}
%>