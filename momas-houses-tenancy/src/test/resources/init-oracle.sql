prompt PL/SQL Developer import file
prompt Created on 2011年3月11日 by nan.chen
set feedback off
set define off
prompt Disabling triggers for DISTRICT...
alter table DISTRICT disable all triggers;
prompt Disabling triggers for STREET...
alter table STREET disable all triggers;
prompt Disabling triggers for TYPES...
alter table TYPES disable all triggers;
prompt Disabling triggers for USERS...
alter table USERS disable all triggers;
prompt Disabling foreign key constraints for STREET...
alter table STREET disable constraint STREET_FK;
prompt Deleting USERS...
delete from USERS;
commit;
prompt Deleting TYPES...
delete from TYPES;
commit;
prompt Deleting STREET...
delete from STREET;
commit;
prompt Deleting DISTRICT...
delete from DISTRICT;
commit;
prompt Loading DISTRICT...
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');
commit;
prompt 6 records loaded
prompt Loading STREET...
insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);
commit;
prompt 4 records loaded
prompt Loading TYPES...
insert into TYPES (ID, NAME)
values (1000, '一室一厅');
insert into TYPES (ID, NAME)
values (1001, '一室两厅');
insert into TYPES (ID, NAME)
values (1002, '两室一厅');
insert into TYPES (ID, NAME)
values (1003, '两室两厅');
insert into TYPES (ID, NAME)
values (1004, '三室一厅');
insert into TYPES (ID, NAME)
values (1005, '三室两厅');
insert into TYPES (ID, NAME)
values (1006, '四室一厅');
insert into TYPES (ID, NAME)
values (1007, '四室两厅');
insert into TYPES (ID, NAME)
values (1008, '四室三厅');
commit;
prompt 9 records loaded
prompt Loading USERS...
insert into USERS (ID, NAME)
values (1001, 'aaaa');
insert into USERS (ID, NAME)
values (1002, 'jbit');
insert into USERS (ID, NAME,PASSWORD)
values (1000, 'admin','123');
insert into USERS (ID, NAME)
values (60, 'ACCP6');
insert into USERS (ID, NAME)
values (77, 'accp5');
insert into USERS (ID, NAME,PASSWORD)
values (1003, '小明','123');
commit;
prompt 5 records loaded
prompt Enabling foreign key constraints for STREET...
alter table STREET enable constraint STREET_FK;
prompt Enabling triggers for DISTRICT...
alter table DISTRICT enable all triggers;
prompt Enabling triggers for STREET...
alter table STREET enable all triggers;
prompt Enabling triggers for TYPES...
alter table TYPES enable all triggers;
prompt Enabling triggers for USERS...
alter table USERS enable all triggers;
set feedback on
set define on
prompt Done.

INSERT INTO house VALUES(1,1003,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(2,1000,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(3,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);
INSERT INTO house VALUES(4,1000,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(5,1002,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(6,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);
INSERT INTO house VALUES(7,1002,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(8,1000,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(9,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);

create sequence hibernate_sequence;


COMMIT;


