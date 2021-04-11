# momas-petshop

## 导入sql进MySQL

```shell
mysql -uroot -p --database petshop < petshop.sql
```

## 网页UI

启动tomcat插件,然后访问 http://localhost

```shell
mvn tomcat7:run
```

url                        | 用处
---|---
http://localhost/index.jsp | 首页
http://localhost/login.jsp | 展示宠物的页面

## CLI 命令行访问（功能更全）

(待补充)