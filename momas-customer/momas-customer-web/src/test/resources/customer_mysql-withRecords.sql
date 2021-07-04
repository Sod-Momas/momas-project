/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : customer

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-11-22 18:36:09
*/

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `customer`;
CREATE DATABASE `customer`;
USE customer;

-- ----------------------------
-- Table structure for `cardlevels`
-- ----------------------------
DROP TABLE IF EXISTS `cardlevels`;
CREATE TABLE `cardlevels` (
  `CARDLEVELS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级编号',
  `CARDLEVELS_LEVELNAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '等级名称',
  `CARDLEVELS_NEEDPOINT` int(7) DEFAULT NULL COMMENT '所需最大积分',
  `CARDLEVELS_POINT` float(3,2) DEFAULT NULL COMMENT '积分比例',
  `CARDLEVELS_PERCENT` float(3,2) DEFAULT NULL COMMENT '折扣比例',
  PRIMARY KEY (`CARDLEVELS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='会员等级';

-- ----------------------------
-- Records of cardlevels
-- ----------------------------
INSERT INTO `cardlevels` VALUES ('1', '初级', '10', '0.10', '0.90');
INSERT INTO `cardlevels` VALUES ('2', '中级', '100', '0.20', '0.80');
INSERT INTO `cardlevels` VALUES ('3', '高级', '1000', '0.30', '0.70');
INSERT INTO `cardlevels` VALUES ('4', '尊贵', '5000', '0.40', '0.60');
INSERT INTO `cardlevels` VALUES ('5', '至尊', '10000', '0.50', '0.50');

-- ----------------------------
-- Table structure for `categories`
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级编号',
  `CATEGORY_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别说明',
  `CATEGORY_TITLE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别标题',
  `CATEGORY_PID` int(11) DEFAULT NULL COMMENT '类别父ID',
  `CATEGORY_ISDEL` int(1) DEFAULT NULL COMMENT '类别状态 1 删除 0 正常',
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='会员等级';

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES ('1', '类别名1', '类别标题1', null, '0');
INSERT INTO `categories` VALUES ('2', '类别名2', '类别标题2', null, '0');
INSERT INTO `categories` VALUES ('3', '类别名1-1', '类别标题1-1', '1', '0');
INSERT INTO `categories` VALUES ('4', '类别名1-2', '类别标题1-2', '1', '0');
INSERT INTO `categories` VALUES ('5', '类别名1-3', '类别标题1-3', '1', '0');
INSERT INTO `categories` VALUES ('6', '类别名2-1', '类别标题2-1', '2', '0');
INSERT INTO `categories` VALUES ('7', '类别名2-2', '类别标题2-2', '2', '0');
INSERT INTO `categories` VALUES ('8', '类别名2-3', '类别标题2-3', '2', '0');
INSERT INTO `categories` VALUES ('9', null, null, null, null);

-- ----------------------------
-- Table structure for `consumeorders`
-- ----------------------------
DROP TABLE IF EXISTS `consumeorders`;
CREATE TABLE `consumeorders` (
  `CONSUMEORDERS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `USERS_ID` int(11) DEFAULT NULL COMMENT '用户编号',
  `CONSUMEORDERS_ORDERCODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单号',
  `CONSUMEORDERS_ORDERTYPE` int(11) DEFAULT NULL COMMENT '订单类型',
  `MEMCARDS_ID` int(11) DEFAULT NULL COMMENT '会员编号',
  `MEMCARDS_CARDID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员卡号',
  `EXCHANGGIFTS_ID` int(11) DEFAULT NULL COMMENT '礼品编号',
  `CONSUMEORDERS_TOTALMONEY` float(7,2) DEFAULT NULL COMMENT '额度',
  `CONSUMEORDERS_DISCOUNTMONEY` float(7,2) DEFAULT NULL COMMENT '实际支付',
  `CONSUMEORDERS_GAVEPOINT` int(5) DEFAULT NULL COMMENT '兑/减积分',
  `CONSUMEORDERS_RECASH` float(7,2) DEFAULT NULL COMMENT '积分返现',
  `CONSUMEORDERS_REMARK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `CONSUMEORDERS_CREATETIME` datetime DEFAULT NULL COMMENT '订单时间',
  `CONSUMEORDERS_ISDEL` int(1) DEFAULT NULL COMMENT '订单是否删除 1 删除 0正常',
  PRIMARY KEY (`CONSUMEORDERS_ID`),
  KEY `FK_CONSUMEO_RELATIONS_CATEGORI` (`CONSUMEORDERS_ORDERTYPE`),
  KEY `FK_CONSUMEO_RELATIONS_EXCHANGG` (`EXCHANGGIFTS_ID`),
  KEY `FK_CONSUMEO_RELATIONS_MEMCARDS` (`MEMCARDS_ID`),
  KEY `FK_CONSUMEO_RELATIONS_SHOPS` (`SHOP_ID`),
  KEY `FK_CONSUMEO_RELATIONS_USERS` (`USERS_ID`),
  CONSTRAINT `FK_CONSUMEO_RELATIONS_CATEGORI` FOREIGN KEY (`CONSUMEORDERS_ORDERTYPE`) REFERENCES `categories` (`CATEGORY_ID`),
  CONSTRAINT `FK_CONSUMEO_RELATIONS_EXCHANGG` FOREIGN KEY (`EXCHANGGIFTS_ID`) REFERENCES `exchanggifts` (`EXCHANGGIFTS_ID`),
  CONSTRAINT `FK_CONSUMEO_RELATIONS_MEMCARDS` FOREIGN KEY (`MEMCARDS_ID`) REFERENCES `memcards` (`MEMCARDS_ID`),
  CONSTRAINT `FK_CONSUMEO_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`),
  CONSTRAINT `FK_CONSUMEO_RELATIONS_USERS` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='消费订单';

-- ----------------------------
-- Records of consumeorders
-- ----------------------------

-- ----------------------------
-- Table structure for `exchanggifts`
-- ----------------------------
DROP TABLE IF EXISTS `exchanggifts`;
CREATE TABLE `exchanggifts` (
  `EXCHANGGIFTS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '礼品编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `EXCHANGGIFTS_GIFTCODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '礼品编码',
  `EXCHANGGIFTS_GIFTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '礼品名称',
  `EXCHANGGIFTS_PHOTO` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '礼品图片',
  `EXCHANGGIFTS_POINT` int(5) DEFAULT NULL COMMENT '所需积分',
  `EXCHANGGIFTS_INTEGER` int(5) DEFAULT NULL COMMENT '总数量',
  `EXCHANGGIFTS_EXCHANGNUM` int(5) DEFAULT NULL COMMENT '已兑换的数量',
  `EXCHANGGIFTS_REMARK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人',
  `EXCHANGGIFTS_STATE` int(1) DEFAULT NULL COMMENT '礼品状态',
  `EXCHANGGIFTS_ISDEL` int(1) DEFAULT NULL COMMENT '礼品是否删除 1 删除 0正常',
  PRIMARY KEY (`EXCHANGGIFTS_ID`),
  KEY `FK_EXCHANGG_RELATIONS_SHOPS` (`SHOP_ID`),
  CONSTRAINT `FK_EXCHANGG_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='礼品';

-- ----------------------------
-- Records of exchanggifts
-- ----------------------------
INSERT INTO `exchanggifts` VALUES ('1', '1', '1', '礼品名1', null, '1', null, null, '备注', '0', '0');
INSERT INTO `exchanggifts` VALUES ('2', '2', '2', '礼品名2', null, '2', null, null, '备注', '0', '0');

-- ----------------------------
-- Table structure for `exchanglogs`
-- ----------------------------
DROP TABLE IF EXISTS `exchanglogs`;
CREATE TABLE `exchanglogs` (
  `EXCHANGLOGS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `USERS_ID` int(11) DEFAULT NULL COMMENT '用户编号',
  `MEMCARDS_ID` int(11) DEFAULT NULL COMMENT '会员编号',
  `MEMCARDS_CARDID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员卡号',
  `MEMCARDS_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员姓名',
  `EXCHANGGIFTS_ID` int(11) DEFAULT NULL COMMENT '礼品编号',
  `EXCHANGGIFTS_GIFTCODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '礼品编码',
  `EXCHANGGIFTS_GIFTNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '礼品名称',
  `EXCHANGLOGS_NUMBER` int(5) DEFAULT NULL COMMENT '数量',
  `EXCHANGLOGS_POINT` int(7) DEFAULT NULL COMMENT '积分',
  `EXCHANGLOGS_CREATETIME` datetime DEFAULT NULL COMMENT '交易时间',
  `EXCHANGLOGS_ISDEL` int(1) DEFAULT NULL COMMENT '交易记录是否删除 1 删除 0正常',
  PRIMARY KEY (`EXCHANGLOGS_ID`),
  KEY `FK_EXCHANGL_RELATIONS_EXCHANGG` (`EXCHANGGIFTS_ID`),
  KEY `FK_EXCHANGL_RELATIONS_MEMCARDS` (`MEMCARDS_ID`),
  KEY `FK_EXCHANGL_RELATIONS_SHOPS` (`SHOP_ID`),
  KEY `FK_EXCHANGL_RELATIONS_USERS` (`USERS_ID`),
  CONSTRAINT `FK_EXCHANGL_RELATIONS_EXCHANGG` FOREIGN KEY (`EXCHANGGIFTS_ID`) REFERENCES `exchanggifts` (`EXCHANGGIFTS_ID`),
  CONSTRAINT `FK_EXCHANGL_RELATIONS_MEMCARDS` FOREIGN KEY (`MEMCARDS_ID`) REFERENCES `memcards` (`MEMCARDS_ID`),
  CONSTRAINT `FK_EXCHANGL_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`),
  CONSTRAINT `FK_EXCHANGL_RELATIONS_USERS` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='交易记录';

-- ----------------------------
-- Records of exchanglogs
-- ----------------------------
INSERT INTO `exchanglogs` VALUES ('1', '1', '1', '1', '1001', '会员姓名1', null, null, null, '1', '12', '2017-11-17 18:34:30', '0');
INSERT INTO `exchanglogs` VALUES ('2', '2', '1', '2', '1002', '会员姓名2', null, null, null, '2', null, '2017-11-01 18:35:00', '0');

-- ----------------------------
-- Table structure for `memcards`
-- ----------------------------
DROP TABLE IF EXISTS `memcards`;
CREATE TABLE `memcards` (
  `MEMCARDS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员编号',
  `CARDLEVELS_ID` int(11) DEFAULT NULL COMMENT '等级编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `MEMCARDS_CARDID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员卡号',
  `MEMCARDS_PASSWORD` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '卡片密码',
  `MEMCARDS_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员姓名',
  `MEMCARDS_SEX` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '会员性别',
  `MEMCARDS_MOBILE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `MEMCARDS_PHOTO` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '靓照',
  `MEMCARDS_BIRTHDAY_MONTH` int(2) DEFAULT NULL COMMENT '会员生日--月',
  `MEMCARDS_BIRTHDAY_DAY` int(2) DEFAULT NULL COMMENT '会员生日--日',
  `MEMCARDS_BIRTHDAYTYPE` int(1) DEFAULT NULL COMMENT '会员生日类型',
  `MEMCARDS_ISPAST` int(1) DEFAULT NULL COMMENT '是否设置卡片过期时间',
  `MEMCARDS_PASTTIME` date DEFAULT NULL COMMENT '卡片过期时间',
  `MEMCARDS_POINT` int(7) DEFAULT NULL COMMENT '当前积分',
  `MEMCARDS_MONEY` float(7,2) DEFAULT NULL COMMENT '卡片付费',
  `MEMCARDS_TOTALMONEY` float(10,2) DEFAULT NULL COMMENT '累计消费',
  `MEMCARDS_TOTALCOUNT` int(5) DEFAULT NULL COMMENT '累计消费次数',
  `MEMCARDS_STATE` int(11) DEFAULT NULL COMMENT '卡片状态',
  `MEMCARDS_ISPOINTAUTO` int(1) DEFAULT NULL COMMENT '积分是否可以自动换成等级',
  `MEMCARDS_REFERERID` int(11) DEFAULT NULL COMMENT '推荐人ID',
  `MEMCARDS_REFERERCARD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '推荐人卡号',
  `MEMCARDS_REFERERNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '推荐人姓名',
  `MEMCARDS_CREATETIME` datetime DEFAULT NULL COMMENT '登记日期',
  `MEMCARDS_ISDEL` int(1) DEFAULT NULL COMMENT '是否被删除',
  PRIMARY KEY (`MEMCARDS_ID`),
  KEY `FK_MEMCARDS_RELATIONS_CARDLEVE` (`CARDLEVELS_ID`),
  KEY `FK_MEMCARDS_RELATIONS_CATEGORI` (`MEMCARDS_STATE`),
  KEY `FK_MEMCARDS_RELATIONS_SHOPS` (`SHOP_ID`),
  CONSTRAINT `FK_MEMCARDS_RELATIONS_CARDLEVE` FOREIGN KEY (`CARDLEVELS_ID`) REFERENCES `cardlevels` (`CARDLEVELS_ID`),
  CONSTRAINT `FK_MEMCARDS_RELATIONS_CATEGORI` FOREIGN KEY (`MEMCARDS_STATE`) REFERENCES `categories` (`CATEGORY_ID`),
  CONSTRAINT `FK_MEMCARDS_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='会员';

-- ----------------------------
-- Records of memcards
-- ----------------------------
INSERT INTO `memcards` VALUES ('1', '2', '2', '1001', '1001', '会员姓名1', '男', '13200000000', null, '1', '1', '1', '0', null, '12', '133.00', '133.00', '1', '1', '1', '1', '', '', '2017-11-16 18:24:54', '0');
INSERT INTO `memcards` VALUES ('2', '1', '2', '1002', '1002', '会员姓名2', '女', '13400000000', null, '2', '2', '2', '0', null, '24', '12.00', '12.00', '1', '2', '1', '1', null, null, '2017-11-10 18:26:35', null);

-- ----------------------------
-- Table structure for `shops`
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops` (
  `SHOP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '店铺编号',
  `SHOP_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '店铺名称',
  `SHOP_CATEGORY_ID` int(11) DEFAULT NULL COMMENT '类别ID',
  `SHOP_CONTACTNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系人',
  `SHOP_CONTACTTEL` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `SHOP_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `SHOP_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `SHOP_ISHASSETADMIN` int(1) DEFAULT NULL COMMENT '是否已分配管理员',
  `SHOP_CREATETIME` datetime DEFAULT NULL COMMENT '加盟时间',
  `SHOP_ISDEL` int(1) DEFAULT NULL COMMENT '店铺状态 1 删除 0正常',
  PRIMARY KEY (`SHOP_ID`),
  KEY `FK_SHOPS_RELATIONS_CATEGORI` (`SHOP_CATEGORY_ID`),
  CONSTRAINT `FK_SHOPS_RELATIONS_CATEGORI` FOREIGN KEY (`SHOP_CATEGORY_ID`) REFERENCES `categories` (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='店铺';

-- ----------------------------
-- Records of shops
-- DELIMITER ;;
-- CREATE PROCEDURE proc4()
-- BEGIN
-- DECLARE y TINYINT DEFAULT 4;
-- WHILE y<100
-- DO 
-- INSERT INTO shops VALUES(y,CONCAT('店铺',y),3,CONCAT('联系人',Y),'13200000000','春和路997号',null,0,NOW(),0);
-- SET y=y+1;
-- END WHILE ;
-- COMMIT;
-- END ;;
-- CALL proc4;
-- ----------------------------
INSERT INTO `shops` VALUES ('1', '花山店', '1', '联系人1号', '13200000000', '花山', '备注', '0', '2010-02-03 18:05:36', '0');
INSERT INTO `shops` VALUES ('2', '长山店', '2', '联系人2号', '13300000000', '大长山路', '备注', '0', '2017-11-02 18:07:38', '0');
INSERT INTO `shops` VALUES ('3', '长江店', '4', '联系人3号', '13400000000', '长江大桥下', '备注', '1', '2015-01-30 18:08:47', '0');

-- ----------------------------
-- Table structure for `transferlogs`
-- ----------------------------
DROP TABLE IF EXISTS `transferlogs`;
CREATE TABLE `transferlogs` (
  `TRANSFERLOGS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `USERS_ID` int(11) DEFAULT NULL COMMENT '用户编号',
  `TRANSFERLOGS_FROMMC_ID` int(11) DEFAULT NULL,
  `TRANSFERLOGS_FROMMC_CARDID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TRANSFERLOGS_TOMC_ID` int(11) DEFAULT NULL,
  `TRANSFERLOGS_TOMC_CARDID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TRANSFERLOGS_TRANSFERMONEY` float(7,2) DEFAULT NULL,
  `TRANSFERLOGS_REMARK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TRANSFERLOGS_CREATETIME` date DEFAULT NULL,
  `TRANSFERLOGS_ISDEL` int(1) DEFAULT NULL COMMENT '记录是否删除 1 删除 0正常',
  PRIMARY KEY (`TRANSFERLOGS_ID`),
  KEY `FK_TRANSFER_RELATIONS_SHOPS` (`SHOP_ID`),
  KEY `FK_TRANSFER_RELATIONS_USERS` (`USERS_ID`),
  CONSTRAINT `FK_TRANSFER_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`),
  CONSTRAINT `FK_TRANSFER_RELATIONS_USERS` FOREIGN KEY (`USERS_ID`) REFERENCES `users` (`USERS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of transferlogs
-- ----------------------------
INSERT INTO `transferlogs` VALUES ('1', '2', '2', '8888', '8888', '8888', '8888', '8888.00', '备注', '2010-02-22', '0');
INSERT INTO `transferlogs` VALUES ('2', '3', '1', '8888', '8888', '88888', '8888', '88888.00', '备注', '2011-11-30', '0');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `USERS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `SHOP_ID` int(11) DEFAULT NULL COMMENT '店铺编号',
  `USERS_LOGINNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户登录名',
  `USERS_PASSWORD` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `USERS_REALNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `USERS_SEX` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `USERS_TELEPHONE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `USERS_ROLE` int(11) DEFAULT NULL COMMENT '角色',
  `USERS_CANDELETE` int(1) DEFAULT NULL COMMENT '用户编号',
  `USERS_ISDEL` int(1) DEFAULT NULL COMMENT '用户是否删除 1 删除 0正常',
  PRIMARY KEY (`USERS_ID`),
  KEY `FK_USERS_RELATIONS_CATEGORI` (`USERS_ROLE`),
  KEY `FK_USERS_RELATIONS_SHOPS` (`SHOP_ID`),
  CONSTRAINT `FK_USERS_RELATIONS_CATEGORI` FOREIGN KEY (`USERS_ROLE`) REFERENCES `categories` (`CATEGORY_ID`),
  CONSTRAINT `FK_USERS_RELATIONS_SHOPS` FOREIGN KEY (`SHOP_ID`) REFERENCES `shops` (`SHOP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '3', 'admin', 'admin', '真实姓名1', '女', '13200000000', '3', '1', '0');
INSERT INTO `users` VALUES ('2', '2', 'test', 'test', '真实姓名2', '男', '13400000000', '2', '2', '0');
