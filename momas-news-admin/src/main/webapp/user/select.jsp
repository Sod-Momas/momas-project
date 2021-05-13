<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>查找</title>
    <%@include file="../module/common-css.jsp" %>
</head>
<body>
<div class="layui-container">
    <%@include file="../module/banner.jsp" %>
    <br>
    <table class="layui-table" id="show_table" lay-filter="data-table"></table>
</div>
<%@include file="../module/common-javascript.jsp" %>
<script>
    axios.get('/news/user')
        .then(function (response) {
            var arr = response.data.data;
            var head = "<tr>" +
                "<th>id</th>" +
                "<th>用户名</th>" +
                "<th>密码</th>" +
                "<th>是否为管理员</th>" +
                "<th>状态值</th>" +
                "<th>创建时间</th>" +
                "<th>更新时间</th>" +
                "</tr>";
            var body = head + "<tbody>";
            arr.forEach(function (element) {
                var tr = "<tr>"
                    + "<td>" + element.id + "</td>"
                    + "<td>" + element.username + "</td>"
                    + "<td>" + element.password + "</td>"
                    + "<td>" + element.isAdmin + "</td>"
                    + "<td>" + element.status + "</td>"
                    + "<td>" + element.createtime + "</td>"
                    + "<td>" + element.updatetime + "</td>"
                    + "</tr>";
                body += tr;
            });
            body += "</tbody>";
            document.querySelector("#show_table").innerHTML = body;
        })
        .catch(function (error) {
            alert(error)
        });
</script>
</body>
</html>
