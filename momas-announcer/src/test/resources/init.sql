# 如果不存在则创建数据库
CREATE DATABASE IF NOT EXISTS `announcer` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
# SHOW CREATE DATABASE announcer;
# SHOW DATABASES;

CREATE TABLE IF NOT EXISTS announce
(
    id                 INT AUTO_INCREMENT,
    title              VARCHAR(64)   NULL COMMENT '公告标题',
    title_image_url    VARCHAR(1024) NULL COMMENT '标题图片URL',
    content            VARCHAR(1024) NOT NULL COMMENT '公告内容',
    is_show            BOOLEAN       NULL COMMENT '是否显示',
    sort_no            INT           NULL COMMENT '排序编号',
    sender_name        VARCHAR(50)   NULL COMMENT '公告发送者名字',
    deprecate_datetime DATETIME      NULL COMMENT '公告过期时间',
    tag                VARCHAR(50)   NULL COMMENT '公告标签',
    insert_user_id     BIGINT        NULL COMMENT '审计字段,数据插入者用户ID',
    update_user_id     BIGINT        NULL COMMENT '审计字段,数据更新者用户ID',
    insert_datetime    DATETIME      NULL COMMENT '审计字段,数据插入时间',
    update_datetime    DATETIME      NULL COMMENT '审计字段,数据最后更新时间',
    CONSTRAINT ANNOUNCE_PK PRIMARY KEY (id)
) COMMENT '公告表' DEFAULT CHARACTER SET UTF8MB4 COLLATE UTF8MB4_BIN;
