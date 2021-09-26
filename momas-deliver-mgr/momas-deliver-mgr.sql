/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : dms

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-12-20 10:32:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_function`
-- ----------------------------
DROP TABLE IF EXISTS `auth_function`;
CREATE TABLE `auth_function` (
  `auth_fuction_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `page` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `generatemenu` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  PRIMARY KEY (`auth_fuction_id`),
  KEY `FK33r6np87v1p6gge7t6rpcao5h` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of auth_function
-- ----------------------------
INSERT INTO `auth_function` VALUES ('11', '0', '基础数据', null, null, null, '1', '1');
INSERT INTO `auth_function` VALUES ('12', '0', '受理', null, null, null, '1', '6');
INSERT INTO `auth_function` VALUES ('13', '0', '调度', null, null, null, '1', '10');
INSERT INTO `auth_function` VALUES ('112', '11', '取派员设置', null, null, 'index/base/staff', '1', '2');
INSERT INTO `auth_function` VALUES ('113', '11', '区域设置', null, null, 'index/base/region', '1', '3');
INSERT INTO `auth_function` VALUES ('114', '11', '管理分区', null, null, 'index/base/subarea', '1', '4');
INSERT INTO `auth_function` VALUES ('115', '11', '管理定区/调试排班', null, null, 'index/base/decidedzone', '1', '5');
INSERT INTO `auth_function` VALUES ('121', '12', '业务受理', null, null, 'index/qupai/noticebill_add', '1', '7');
INSERT INTO `auth_function` VALUES ('122', '12', '工作单快速录入', null, null, 'index/qupai/quickworkorder', '1', '8');
INSERT INTO `auth_function` VALUES ('124', '12', '工作单导入', null, null, 'index/qupai/workorderimport', '1', '9');
INSERT INTO `auth_function` VALUES ('131', '13', '查台转单', null, null, 'index/qupai/noticebill', '1', '11');
INSERT INTO `auth_function` VALUES ('132', '13', '人工调度', null, null, 'index/qupai/diaodu', '1', '12');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES ('1', '管理员', '', null);
INSERT INTO `auth_role` VALUES ('2', '普通用户', null, null);

-- ----------------------------
-- Table structure for `bc_decidedzone`
-- ----------------------------
DROP TABLE IF EXISTS `bc_decidedzone`;
CREATE TABLE `bc_decidedzone` (
  `decidedzone_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`decidedzone_id`),
  KEY `fk_staff` (`staff_id`),
  CONSTRAINT `fk_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bc_decidedzone
-- ----------------------------
INSERT INTO `bc_decidedzone` VALUES ('1', '1', 'kw1');
INSERT INTO `bc_decidedzone` VALUES ('2', '2', 'e2');

-- ----------------------------
-- Table structure for `bc_region`
-- ----------------------------
DROP TABLE IF EXISTS `bc_region`;
CREATE TABLE `bc_region` (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `district` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postcode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shortcode` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `citycode` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bc_region
-- ----------------------------
INSERT INTO `bc_region` VALUES ('1', '北京市', '北京市', '东城区', '110101', 'BJBJDC', 'beijing');
INSERT INTO `bc_region` VALUES ('2', '北京市', '北京市', '西城区', '110102', 'BJBJXC', 'beijing');
INSERT INTO `bc_region` VALUES ('3', '北京市', '北京市', '朝阳区', '110105', 'BJBJCY', 'beijing');
INSERT INTO `bc_region` VALUES ('4', '北京市', '北京市', '丰台区', '110106', 'BJBJFT', 'beijing');
INSERT INTO `bc_region` VALUES ('5', '北京市', '北京市', '石景山区', '110107', 'BJBJSJS', 'beijing');
INSERT INTO `bc_region` VALUES ('6', '北京市', '北京市', '海淀区', '110108', 'BJBJHD', 'beijing');
INSERT INTO `bc_region` VALUES ('7', '北京市', '北京市', '门头沟区', '110109', 'BJBJMTG', 'beijing');
INSERT INTO `bc_region` VALUES ('8', '北京市', '北京市', '房山区', '110111', 'BJBJFS', 'beijing');
INSERT INTO `bc_region` VALUES ('9', '北京市', '北京市', '通州区', '110112', 'BJBJTZ', 'beijing');
INSERT INTO `bc_region` VALUES ('10', '北京市', '北京市', '顺义区', '110113', 'BJBJSY', 'beijing');
INSERT INTO `bc_region` VALUES ('11', '北京市', '北京市', '昌平区', '110114', 'BJBJCP', 'beijing');
INSERT INTO `bc_region` VALUES ('12', '北京市', '北京市', '大兴区', '110115', 'BJBJDX', 'beijing');
INSERT INTO `bc_region` VALUES ('13', '北京市', '北京市', '怀柔区', '110116', 'BJBJHR', 'beijing');
INSERT INTO `bc_region` VALUES ('14', '北京市', '北京市', '平谷区', '110117', 'BJBJPG', 'beijing');
INSERT INTO `bc_region` VALUES ('15', '北京市', '北京市', '密云县', '110228', 'BJBJMY', 'beijing');
INSERT INTO `bc_region` VALUES ('16', '北京市', '北京市', '延庆县', '110229', 'BJBJYQ', 'beijing');
INSERT INTO `bc_region` VALUES ('17', '河北省', '石家庄市', '长安区', '130102', 'HBSJZZA', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('18', '河北省', '石家庄市', '桥东区', '130103', 'HBSJZQD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('19', '河北省', '石家庄市', '桥西区', '130104', 'HBSJZQX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('20', '河北省', '石家庄市', '新华区', '130105', 'HBSJZXH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('21', '河北省', '石家庄市', '井陉矿区', '130107', 'HBSJZJXK', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('22', '河北省', '石家庄市', '裕华区', '130108', 'HBSJZYH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('23', '河北省', '石家庄市', '井陉县', '130121', 'HBSJZJX', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('24', '河北省', '石家庄市', '正定县', '130123', 'HBSJZZD', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('25', '河北省', '石家庄市', '栾城县', '130124', 'HBSJZLC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('26', '河北省', '石家庄市', '行唐县', '130125', 'HBSJZXT', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('27', '河北省', '石家庄市', '灵寿县', '130126', 'HBSJZLS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('28', '河北省', '石家庄市', '高邑县', '130127', 'HBSJZGY', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('29', '河北省', '石家庄市', '深泽县', '130128', 'HBSJZSZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('30', '河北省', '石家庄市', '赞皇县', '130129', 'HBSJZZH', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('31', '河北省', '石家庄市', '无极县', '130130', 'HBSJZWJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('32', '河北省', '石家庄市', '平山县', '130131', 'HBSJZPS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('33', '河北省', '石家庄市', '元氏县', '130132', 'HBSJZYS', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('34', '河北省', '石家庄市', '赵县', '130133', 'HBSJZZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('35', '河北省', '石家庄市', '辛集市', '130181', 'HBSJZXJ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('36', '河北省', '石家庄市', '藁城市', '130182', 'HBSJZGC', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('37', '河北省', '石家庄市', '晋州市', '130183', 'HBSJZJZ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('38', '河北省', '石家庄市', '新乐市', '130184', 'HBSJZXL', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('39', '河北省', '石家庄市', '鹿泉市', '130185', 'HBSJZLQ', 'shijiazhuang');
INSERT INTO `bc_region` VALUES ('40', '天津市', '天津市', '和平区', '120101', 'TJTJHP', 'tianjin');
INSERT INTO `bc_region` VALUES ('41', '天津市', '天津市', '河东区', '120102', 'TJTJHD', 'tianjin');
INSERT INTO `bc_region` VALUES ('42', '天津市', '天津市', '河西区', '120103', 'TJTJHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('43', '天津市', '天津市', '南开区', '120104', 'TJTJNK', 'tianjin');
INSERT INTO `bc_region` VALUES ('44', '天津市', '天津市', '河北区', '120105', 'TJTJHB', 'tianjin');
INSERT INTO `bc_region` VALUES ('45', '天津市', '天津市', '红桥区', '120106', 'TJTJHQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('46', '天津市', '天津市', '滨海新区', '120116', 'TJTJBHX', 'tianjin');
INSERT INTO `bc_region` VALUES ('47', '天津市', '天津市', '东丽区', '120110', 'TJTJDL', 'tianjin');
INSERT INTO `bc_region` VALUES ('48', '天津市', '天津市', '西青区', '120111', 'TJTJXQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('49', '天津市', '天津市', '津南区', '120112', 'TJTJJN', 'tianjin');
INSERT INTO `bc_region` VALUES ('50', '天津市', '天津市', '北辰区', '120113', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('51', '天津市', '天津市', '武清区', '120114', 'TJTJWQ', 'tianjin');
INSERT INTO `bc_region` VALUES ('52', '天津市', '天津市', '宝坻区', '120115', 'TJTJBC', 'tianjin');
INSERT INTO `bc_region` VALUES ('53', '天津市', '天津市', '宁河县', '120221', 'TJTJNH', 'tianjin');
INSERT INTO `bc_region` VALUES ('54', '天津市', '天津市', '静海县', '120223', 'TJTJJH', 'tianjin');
INSERT INTO `bc_region` VALUES ('55', '天津市', '天津市', '蓟县', '120225', 'TJTJJ', 'tianjin');
INSERT INTO `bc_region` VALUES ('56', '山西省', '太原市', '小店区', '140105', 'SXTYXD', 'taiyuan');
INSERT INTO `bc_region` VALUES ('57', '山西省', '太原市', '迎泽区', '140106', 'SXTYYZ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('58', '山西省', '太原市', '杏花岭区', '140107', 'SXTYXHL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('59', '山西省', '太原市', '尖草坪区', '140108', 'SXTYJCP', 'taiyuan');
INSERT INTO `bc_region` VALUES ('60', '山西省', '太原市', '万柏林区', '140109', 'SXTYWBL', 'taiyuan');
INSERT INTO `bc_region` VALUES ('61', '山西省', '太原市', '晋源区', '140110', 'SXTYJY', 'taiyuan');
INSERT INTO `bc_region` VALUES ('62', '山西省', '太原市', '清徐县', '140121', 'SXTYQX', 'taiyuan');
INSERT INTO `bc_region` VALUES ('63', '山西省', '太原市', '阳曲县', '140122', 'SXTYYQ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('64', '山西省', '太原市', '娄烦县', '140123', 'SXTYLF', 'taiyuan');
INSERT INTO `bc_region` VALUES ('65', '山西省', '太原市', '古交市', '140181', 'SXTYGJ', 'taiyuan');
INSERT INTO `bc_region` VALUES ('66', '湖北省', '武汉市', '洪山区', '430070', 'HBWHHS', 'wuhan');
INSERT INTO `bc_region` VALUES ('67', '湖北省', '武汉市', '江夏区', '430071', 'HBWHJX', 'wuhan');
INSERT INTO `bc_region` VALUES ('68', '湖北省', '武汉市', '武昌区', '430072', 'HBWHWC', 'wuhan');
INSERT INTO `bc_region` VALUES ('69', '湖北省', '武汉市', '硚口区', '430073', 'HBWHQK', 'wuhan');
INSERT INTO `bc_region` VALUES ('70', '湖北省', '武汉市', '江岸区', '430074', 'HBWHJA', 'wuhan');
INSERT INTO `bc_region` VALUES ('71', '湖北省', '武汉市', '黄陂区', '430075', 'HBWHHP', 'wuhan');
INSERT INTO `bc_region` VALUES ('72', '湖北省', '武汉市', '江汉区', '430076', 'HBWHJH', 'wuhan');
INSERT INTO `bc_region` VALUES ('73', '湖北省', '武汉市', '东西湖区', '430077', 'HBWHDXH', 'wuhan');
INSERT INTO `bc_region` VALUES ('74', '湖北省', '武汉市', '东湖高新区', '430078', 'HBWHDHGX', 'wuhan');
INSERT INTO `bc_region` VALUES ('75', '湖北省', '武汉市', '蔡甸区', '430079', 'HBWHCD', 'wuhan');

-- ----------------------------
-- Table structure for `bc_staff`
-- ----------------------------
DROP TABLE IF EXISTS `bc_staff`;
CREATE TABLE `bc_staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `haspda` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deltag` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `station` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `standard` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bc_staff
-- ----------------------------
INSERT INTO `bc_staff` VALUES ('1', '陈伟明', '13299737787', '1', '0', '广东揭阳', '10kg');
INSERT INTO `bc_staff` VALUES ('2', '牛总', '17988888888', '1', '0', 'ff', '50kg');
INSERT INTO `bc_staff` VALUES ('3', '拉拉', '133888888888', '1', '0', '给胡', '90');

-- ----------------------------
-- Table structure for `bc_subarea`
-- ----------------------------
DROP TABLE IF EXISTS `bc_subarea`;
CREATE TABLE `bc_subarea` (
  `subarea_id` int(11) NOT NULL AUTO_INCREMENT,
  `decidedzone_id` int(11) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  `addresskey` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startnum` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endnum` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `single` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `position` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`subarea_id`),
  KEY `fk_region` (`region_id`),
  KEY `fk_decidedzone` (`decidedzone_id`),
  CONSTRAINT `fk_decidedzone` FOREIGN KEY (`decidedzone_id`) REFERENCES `bc_decidedzone` (`decidedzone_id`),
  CONSTRAINT `fk_region` FOREIGN KEY (`region_id`) REFERENCES `bc_region` (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bc_subarea
-- ----------------------------
INSERT INTO `bc_subarea` VALUES ('3', null, '2', '关键12', '001', '009', '0', '公交车');

-- ----------------------------
-- Table structure for `qp_noticebill`
-- ----------------------------
DROP TABLE IF EXISTS `qp_noticebill`;
CREATE TABLE `qp_noticebill` (
  `noticebill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `customer_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `delegater` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pickaddress` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `arrivecity` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pickdate` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `volume` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ordertype` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`noticebill_id`),
  KEY `fk_noticebill_user` (`user_id`),
  KEY `fk_noticebill_staff` (`staff_id`),
  CONSTRAINT `fk_noticebill_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`staff_id`),
  CONSTRAINT `fk_noticebill_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of qp_noticebill
-- ----------------------------

-- ----------------------------
-- Table structure for `qp_workbill`
-- ----------------------------
DROP TABLE IF EXISTS `qp_workbill`;
CREATE TABLE `qp_workbill` (
  `workbill_id` int(11) NOT NULL AUTO_INCREMENT,
  `noticebill_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pickstate` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `buildtime` datetime NOT NULL,
  `attachbilltimes` int(11) DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`workbill_id`),
  KEY `fk_workbill_notice` (`noticebill_id`),
  KEY `fk_workbill_staff` (`staff_id`),
  CONSTRAINT `fk_workbill_notice` FOREIGN KEY (`noticebill_id`) REFERENCES `qp_noticebill` (`noticebill_id`),
  CONSTRAINT `fk_workbill_staff` FOREIGN KEY (`staff_id`) REFERENCES `bc_staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of qp_workbill
-- ----------------------------

-- ----------------------------
-- Table structure for `qp_workordermanage`
-- ----------------------------
DROP TABLE IF EXISTS `qp_workordermanage`;
CREATE TABLE `qp_workordermanage` (
  `workordermanage_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrivecity` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `floadreqr` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prodtimelimit` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prodtype` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sendername` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senderphone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senderaddr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receivername` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiverphone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiveraddr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `feeitemnum` int(11) DEFAULT NULL,
  `actlweit` double DEFAULT NULL,
  `vol` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `managerCheck` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`workordermanage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of qp_workordermanage
-- ----------------------------

-- ----------------------------
-- Table structure for `role_function`
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `role_function_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`role_function_id`),
  KEY `fk_rolefunction_auth_fucntion` (`role_function_id`),
  CONSTRAINT `fk_rolefunction_auth_fucntion` FOREIGN KEY (`role_function_id`) REFERENCES `auth_function` (`auth_fuction_id`),
  CONSTRAINT `fk_rolefunction_role` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES ('11', '1');
INSERT INTO `role_function` VALUES ('11', '2');
INSERT INTO `role_function` VALUES ('12', '1');
INSERT INTO `role_function` VALUES ('13', '1');
INSERT INTO `role_function` VALUES ('112', '1');
INSERT INTO `role_function` VALUES ('112', '2');
INSERT INTO `role_function` VALUES ('113', '1');
INSERT INTO `role_function` VALUES ('114', '1');
INSERT INTO `role_function` VALUES ('114', '2');
INSERT INTO `role_function` VALUES ('115', '1');
INSERT INTO `role_function` VALUES ('121', '1');
INSERT INTO `role_function` VALUES ('122', '1');
INSERT INTO `role_function` VALUES ('124', '1');
INSERT INTO `role_function` VALUES ('131', '1');
INSERT INTO `role_function` VALUES ('132', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `salary` double DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `station` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'jack', 'e10adc3949ba59abbe56e057f20f883e', '2000', '2017-12-07 20:34:58', '2', '111', '444', 'bbb');
INSERT INTO `t_user` VALUES ('3', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '10000', '2017-12-12 00:00:00', '男', '总公司', '110', null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_userrole_role` (`role_id`),
  CONSTRAINT `fk_userrole_role` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`),
  CONSTRAINT `fk_userrole_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '3');
INSERT INTO `user_role` VALUES ('2', '2');
