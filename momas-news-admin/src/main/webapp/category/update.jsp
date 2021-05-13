<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>修改</title>
    <%@include file="../module/common-css.jsp" %>
</head>
<body>
<div class="layui-container">
    <%@include file="../module/banner.jsp" %>
    <form class="layui-form">
        <br>
        <div class="layui-form-item">
            <label class="layui-form-label">id</label>
            <div class="layui-input-block">
                <input name="id" placeholder="请输入id" class="layui-input" type="number">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">类型名</label>
            <div class="layui-input-block">
                <input name="name" placeholder="请输入类型名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父分类id</label>
            <div class="layui-input-block">
                <input name="parentId" placeholder="请输入类型父id" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分类状态值</label>
            <div class="layui-input-block">
                <input name="status" placeholder="请输入状态值" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="commitButton">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<%@include file="../module/common-javascript.jsp" %>
<script>
    layui.use('form', function () {
        var form = layui.form;
        // 监听 commitButton 提交按钮
        form.on('submit(commitButton)', function (data) {

            //当前容器的全部表单字段，名值对形式：{name: value}
            console.log(data.field);

            axios({
                method: 'PUT',
                url: '/news/category',
                params: data.field
            })
                .then(function (value) {
                    if (value.data.status !== 200) {
                        throw new Error(value.data.message)
                    }
                    alert("修改成功");
                })
                .catch(function (reason) {
                    alert("修改失败,原因:" + reason);
                });

            //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            return false;
        });
    });

</script>
</body>
</html>
