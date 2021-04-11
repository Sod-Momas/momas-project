# momas-news

新闻中心项目

## 导入sql
```shell
mysql -uroot -p --database news < news.sql
```

## 升级2.0
- 将ui与service分离
- 使用了servlet作为控制器
- 使用了JNDI共享资源
- 使用了DataSource连接池
- 修改news_users实现了权限控制