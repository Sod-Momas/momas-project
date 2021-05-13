<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
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
    axios.get('/news/news')
        .then(function (response) {
            var arr = response.data.data;
            var head = "<tr>" +
                "<th>id</th>" +
                "<th>标题</th>" +
                "<th>摘要</th>" +
                "<th>内容</th>" +
                "<th>类型id</th>" +
                "<th>状态值</th>" +
                "<th>创建时间</th>" +
                "<th>更新时间</th>" +
                "</tr>";
            var body = head + "<tbody>";
            arr.forEach(function (element) {
                var tr = "<tr>"
                    + "<td>" + element.id + "</td>"
                    + "<td>" + element.title + "</td>"
                    + "<td>" + element.summary + "</td>"
                    + "<td>" + element.content + "</td>"
                    + "<td>" + element.categoryId + "</td>"
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