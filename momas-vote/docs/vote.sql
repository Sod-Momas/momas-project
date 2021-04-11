/*  ���ļ��������ɱ���Ŀ����Ļ������ݿ�  */
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
   uid                  int not null comment '�û�id',
   uusername            char(255) comment '�û��� ',
   upassword            char(255) comment '�û�����',
   uemail               char(255) comment '�û�����',
   ustatus              integer comment '�û�״̬',
   primary key (uid)
);

alter table user comment '�û���';

/*==============================================================*/
/* Table: usertovote                                            */
/*==============================================================*/
create table usertovote
(
   uvid                 integer not null comment '��ϵid',
   uid                  int not null comment '�û�id',
   vid                  int not null comment 'ͶƱ����id',
   primary key (uvid)
);

alter table usertovote comment 'usertovote';

/*==============================================================*/
/* Table: vote                                                  */
/*==============================================================*/
create table vote
(
   vid                  int not null comment 'ͶƱ����id',
   vtitle               char(255) comment 'ͶƱ������',
   vtype                int comment 'ͶƱ����(��ѡ/��ѡ)',
   primary key (vid)
);

alter table vote comment 'vote';

/*==============================================================*/
/* Table: vote_option                                           */
/*==============================================================*/
create table voteOption
(
   void                 int not null comment 'ͶƱѡ��id',
   vid                  int comment 'ͶƱ����id',
   voname               char(255) comment 'ͶƱѡ������',
   primary key (void)
);

alter table vote_option comment 'vote_option';

alter table usertovote add constraint FK_usertovote foreign key (uid)
      references user (uid) on delete restrict on update restrict;

alter table usertovote add constraint FK_usertovote2 foreign key (vid)
      references vote (vid) on delete restrict on update restrict;

alter table vote_option add constraint FK_Relationship_2 foreign key (vid)
      references vote (vid) on delete restrict on update restrict;

