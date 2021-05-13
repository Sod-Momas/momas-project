<%-- 这个文件存放公共的javascript资源引入标签 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="/webjars/layui/2.5.7/js/layui.all.js"></script>
<script src="/webjars/axios/0.19.2/js/axios.min.js"></script>

<script>
    // 标记是否登录的键名
    var name = "X-LOGIN";
    var arr;
    var reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    var login = (arr = document.cookie.match(reg)) ? unescape(arr[2]) : null;
    if (login === "success") {
        document.title += '[已登录]';
    } else {
        document.title += '[未登录]';
    }
</script>
