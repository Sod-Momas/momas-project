# momas-announcer

一个公告系统, 本项目目的在于编写一个公告系统, 作为插件嵌入各个业务系统中运行

## 项目功能

**作为一个可选插件加入到您的系统里**

## 项目启动方法

- 如果您使用 maven, 可以直接使用 maven 命令启动:

    ```bash
    mvn spring-boot:run
    ```

- 如果您把项目导入了 IDE, 您可以直接启动主类 `cc.momas.announcer.MomasAnnouncerApplication`

启动完成后, 请访问以下 url 测试是否启动成功, 页面有显示就是成功
> `http://localhost/test/ping` 定义在 `cc.momas.announcer.controller.TestController`里  
> `http://localhost/test/kt?name=world!` 定义在 `cc.momas.announcer.controller.KotlinTestController` 里

[项目需求文档](docs/prd.md)

## 项目贡献方案

1. fork 本项目
2. 添加/修改
3. push 到仓库
4. 提交一个 pull request

## 参考资料

参照 [引用文献](docs/reference.md)