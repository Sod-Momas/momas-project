<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>登录页</title>
    <%@include file="../module/common-css.jsp" %>
</head>
<body>

<div class="layui-container">
    <%@include file="../module/banner.jsp" %>
    <br/>
    <form class="layui-form" lay-filter="form_login" method="post" action="/news/auth">
        <div class="layui-form-item">
            <label class="layui-form-label" for="username">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" id="username" value="admin" lay-verify="required"
                       autocomplete="off" placeholder="请输入用户名" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="password">密码框</label>
            <div class="layui-input-block">
                <input type="password" name="password" id="password" value="admin" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit>登录</button>
            </div>
        </div>
    </form>
</div>

<%@include file="../module/common-javascript.jsp" %>
</body>
</html>