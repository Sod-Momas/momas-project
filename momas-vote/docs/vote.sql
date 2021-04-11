/*  本文件用于生成本项目所需的基本数据库  */
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/25 17:53:14                           */
/*==============================================================*/
drop database if exists vote;

create database vote;

use vote;

drop table if exists user;

drop table if exists usertovote;

drop table if exists vote;

drop table if exists vote_option;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  int not null comment '用户id',
   uusername            char(255) comment '用户名 ',
   upassword            char(255) comment '用户密码',
   uemail               char(255) comment '用户邮箱',
   ustatus              integer comment '用户状态',
   primary key (uid)
);

alter table user comment '用户表';

/*==============================================================*/
/* Table: usertovote                                            */
/*==============================================================*/
create table usertovote
(
   uvid                 integer not null comment '关系id',
   uid                  int not null comment '用户id',
   vid                  int not null comment '投票主题id',
   primary key (uvid)
);

alter table usertovote comment 'usertovote';

/*==============================================================*/
/* Table: vote                                                  */
/*==============================================================*/
create table vote
(
   vid                  int not null comment '投票主题id',
   vtitle               char(255) comment '投票主题名',
   vtype                int comment '投票类型(单选/多选)',
   primary key (vid)
);

alter table vote comment 'vote';

/*==============================================================*/
/* Table: vote_option                                           */
/*==============================================================*/
create table voteOption
(
   void                 int not null comment '投票选项id',
   vid                  int comment '投票主题id',
   voname               char(255) comment '投票选项内容',
   primary key (void)
);

alter table vote_option comment 'vote_option';

alter table usertovote add constraint FK_usertovote foreign key (uid)
      references user (uid) on delete restrict on update restrict;

alter table usertovote add constraint FK_usertovote2 foreign key (vid)
      references vote (vid) on delete restrict on update restrict;

alter table vote_option add constraint FK_Relationship_2 foreign key (vid)
      references vote (vid) on delete restrict on update restrict;

