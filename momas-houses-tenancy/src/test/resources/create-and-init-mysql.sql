create table USERS
(
  ID        INT not null PRIMARY KEY,
  `NAME`      VARCHAR(50),
  `PASSWORD`  VARCHAR(50),
  TELEPHONE VARCHAR(15),
  USERNAME  VARCHAR(50),
  ISADMIN   VARCHAR(5)
);
create table DISTRICT
(
  ID   INT not null PRIMARY KEY,
  NAME VARCHAR(50) not null
);
create table STREET
(
  ID          INT not null PRIMARY KEY,
  NAME        VARCHAR(50),
  DISTRICT_ID INT,
  FOREIGN KEY (DISTRICT_ID) REFERENCES DISTRICT(ID)
);
create table TYPES
(
  ID   INT not null PRIMARY KEY,
  NAME VARCHAR(10) not null
);
create table HOUSE
(
  ID          INT PRIMARY KEY,
  USER_ID     INT,
  TYPES_ID     INT,
  TITLE       NVARCHAR(50),
  DESCRIPTION NVARCHAR(2000),
  PRICE       INT,
  PUBDATE     DATE,
  FLOORAGE    INT,
  CONTACT     VARCHAR(100),
  STREET_ID   INT,
  FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
  FOREIGN KEY (TYPES_ID) REFERENCES TYPES(ID),
  FOREIGN KEY (STREET_ID) REFERENCES STREET(ID)  
);

insert into DISTRICT (ID, NAME) values (1001, '东城');
insert into DISTRICT (ID, NAME) values (1002, '西城');
insert into DISTRICT (ID, NAME) values (1003, '石景山');
insert into DISTRICT (ID, NAME) values (1006, '朝阳');
insert into DISTRICT (ID, NAME) values (1000, '丰台');
insert into DISTRICT (ID, NAME) values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID) values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID) values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID) values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID) values (1003, '朝阳路', 1006);

insert into TYPES (ID, NAME) values (1000, '一室一厅');
insert into TYPES (ID, NAME) values (1001, '一室两厅');
insert into TYPES (ID, NAME) values (1002, '两室一厅');
insert into TYPES (ID, NAME) values (1003, '两室两厅');
insert into TYPES (ID, NAME) values (1004, '三室一厅');
insert into TYPES (ID, NAME) values (1005, '三室两厅');
insert into TYPES (ID, NAME) values (1006, '四室一厅');
insert into TYPES (ID, NAME) values (1007, '四室两厅');
insert into TYPES (ID, NAME) values (1008, '四室三厅');

insert into USERS (ID, NAME) values (1001, 'aaaa');
insert into USERS (ID, NAME) values (1002, 'jbit');
insert into USERS (ID, NAME,PASSWORD) values (1000, 'admin','123');
insert into USERS (ID, NAME) values (60, 'ACCP6');
insert into USERS (ID, NAME) values (77, 'accp5');
insert into USERS (ID, NAME,PASSWORD) values (1003, '小明','123');

INSERT INTO house VALUES(1,1003,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(2,1000,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(3,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);
INSERT INTO house VALUES(4,1000,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(5,1002,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(6,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);
INSERT INTO house VALUES(7,1002,1007,'绝世好房，错过不再','地铁口，商圈房，学苑房',1000,SYSDATE,200,110,1002);
INSERT INTO house VALUES(8,1000,1002,'好房子人人都喜欢','环境优美',1200,SYSDATE,100,119,1003);
INSERT INTO house VALUES(9,1001,1003,'看了都喜欢','地铁口',1100,SYSDATE,80,110,1000);

