<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="layui-nav layui-bg-green">
    <li class="layui-nav-item">
        <a href="/news/index.jsp">莫莫砂新闻中心</a>
    </li>
    <!--        <li class="layui-nav-item layui-this">-->
    <li class="layui-nav-item">
        <a href="javascript:">身份验证</a>
        <dl class="layui-nav-child">
            <dd><a href="/news/auth/login.jsp">登录</a></dd>
            <dd><a href="/news/auth">退出</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:">用户管理</a>
        <dl class="layui-nav-child">
            <dd><a href="/news/user/insert.jsp">添加用户</a></dd>
            <dd><a href="/news/user/select.jsp">查找用户</a></dd>
            <dd><a href="/news/user/update.jsp">修改用户</a></dd>
            <dd><a href="/news/user/delete.jsp">删除用户</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:">新闻管理</a>
        <dl class="layui-nav-child">
            <dd><a href="/news/news/insert.jsp">添加新闻</a></dd>
            <dd><a href="/news/news/select.jsp">查找新闻</a></dd>
            <dd><a href="/news/news/update.jsp">修改新闻</a></dd>
            <dd><a href="/news/news/delete.jsp">删除新闻</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:">新闻评论</a>
        <dl class="layui-nav-child">
            <dd><a href="/news/comment/insert.jsp">添加评论</a></dd>
            <dd><a href="/news/comment/select.jsp">查找评论</a></dd>
            <dd><a href="/news/comment/update.jsp">修改评论</a></dd>
            <dd><a href="/news/comment/delete.jsp">删除评论</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:">新闻分类</a>
        <dl class="layui-nav-child">
            <dd><a href="/news/category/insert.jsp">添加分类</a></dd>
            <dd><a href="/news/category/select.jsp">查找分类</a></dd>
            <dd><a href="/news/category/update.jsp">修改分类</a></dd>
            <dd><a href="/news/category/delete.jsp">删除分类</a></dd>
        </dl>
    </li>
</ul>
