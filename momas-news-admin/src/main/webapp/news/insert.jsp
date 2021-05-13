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
    <br/>
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" for="title">新闻标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title" lay-verify="required" lay-reqtext="标题是必填项，岂能为空？"
                       placeholder="请输入新闻标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="summary">新闻摘要</label>
            <div class="layui-input-block">
                <input type="text" name="summary" id="summary" lay-verify="required"
                       lay-reqtext="如果不想填摘要,则随便写点东西" placeholder="请输入新闻摘要" autocomplete="off"
                       class="layui-input" value="[summary]">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="categoryId">新闻分类</label>
            <div class="layui-input-inline">
                <input type="number" name="categoryId" id="categoryId" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label" for="content">新闻正文内容</label>
            <div class="layui-input-block">
                        <textarea placeholder="请输入新闻正文内容" name="content" id="content" lay-verify="required"
                                  class="layui-textarea"></textarea>
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
                method: 'post',
                url: '/news/news',
                params: data.field
            })
                .then(function (value) {
                    if (value.data.status !== 200) {
                        throw new Error(value.data.message)
                    }
                    alert("添加成功");
                })
                .catch(function (reason) {
                    alert("添加失败,原因:" + reason);
                });

            //阻止表单跳转。如果需要表单跳转，去掉这段即可。
            return false;
        });
    });

</script>
</body>
</html>