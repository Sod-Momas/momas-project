select * from t_user;
insert into t_user VALUES(1,'admin',md5('123456'),2000,now(),2,111,444,'bbb');
insert into t_user VALUES(2,'jack',md5('123456'),2000,now(),2,111,444,'bbb');

INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid) VALUES ('11', '��������', 'jichudangan', null, null, '1', '0', null);
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('112', '���ɱ�׼', 'standard', null, 'index/base/standard', '1', '1', '11');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('113', 'ȡ��Ա����', 'staff', null, 'index/base/staff', '1', '2', '11');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('114', '��������', 'region', null, 'index/base/region', '1', '3', '11');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('115', '�������', 'subarea', null, 'index/base/subarea', '1', '4', '11');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('116', '������/�����Ű�', 'decidedzone', null, 'index/base/decidedzone', '1', '5', '11');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('12', '����', 'shouli', null, null, '1', '1', null);
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('121', 'ҵ������', 'noticebill', null, 'index/qupai/noticebill_add', '1', '0', '12');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('122', '����������¼��', 'quickworkordermanage', null, 'index/qupai/quickworkorder', '1', '1', '12');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('124', '����������', 'workordermanageimport', null, 'index/qupai/workorderimport', '1', '3', '12');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('13', '����', 'diaodu', null, null, '1', '2', null);
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('131', '��̨ת��', 'changestaff', null, null, '1', '0', '13');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('132', '�˹�����', 'personalassign', null, 'index/qupai/diaodu', '1', '1', '13');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('14', '�����������̹���', 'zhongzhuan', null, null, '1', '3', null);
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('141', '������������', 'start', null, 'workOrderManageAction/list', '1', '0', '14');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('142', '�鿴��������', 'personaltask', null, 'taskAction/findPersonalTask', '1', '1', '14');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('143', '�鿴�ҵ�������', 'grouptask', null, 'taskAction/findGroupTask', '1', '2', '14');
INSERT INTO `auth_function`(auth_fuction_id,name,code,description,page,generatemenu,zindex,pid)VALUES ('144', 'ɾ��ȡ��Ա', 'staff.delete', 'xxx', 'staffAction/delete', '0', '1', '113');

insert into auth_role values(1,'����Ա','admin',null);
insert into auth_role values(2,'ҵ�����Ա','noticeadmin',null);

insert into role_function values(11,1);
insert into role_function values(112,1);
insert into role_function values(113,1);
insert into role_function values(114,1);
insert into role_function values(115,1);
insert into role_function values(116,1);
insert into role_function values(12,1);
insert into role_function values(121,1);
insert into role_function values(122,1);
insert into role_function values(124,1);
insert into role_function values(13,1);
insert into role_function values(131,1);
insert into role_function values(132,1);
insert into role_function values(14,1);
insert into role_function values(141,1);
insert into role_function values(142,1);
insert into role_function values(143,1);
insert into role_function values(144,1);

insert into role_function values(12,2);
insert into role_function values(121,2);
insert into role_function values(122,2);
insert into role_function values(124,2);