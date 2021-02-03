/*
Navicat MySQL Data Transfer

Source Server         : mysqldb
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : studentmanagement

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2021-02-03 14:20:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `provinceId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_city_provinceId` (`provinceId`),
  CONSTRAINT `fk_city_provinceId` FOREIGN KEY (`provinceId`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('18', '石家庄市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('19', '唐山市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('20', '邯郸市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('21', '保定市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('22', '沧州市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('23', '邢回台市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('24', '廊坊市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('25', '承德市答', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('26', '张家口市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('27', '衡水市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('28', '秦皇岛市', '2020-11-20 17:23:13', '5');
INSERT INTO `city` VALUES ('29', '太原市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('30', '大同市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('31', '阳泉市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('32', '长治市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('33', '晋城市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('34', '朔州市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('35', '晋中市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('36', '运城市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('37', '忻州市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('38', '临汾市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('39', '吕梁市', '2020-11-20 17:23:13', '6');
INSERT INTO `city` VALUES ('40', '广州市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('41', '深圳市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('42', '珠海市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('43', '汕头市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('44', '佛山市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('45', '韶关市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('46', '湛江市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('47', '肇庆市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('48', '江门市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('49', '茂名市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('50', '惠州市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('51', '梅州市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('52', '汕尾市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('53', '河源市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('54', '阳江市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('55', '清远市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('56', '东莞市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('57', '中山市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('58', '潮州市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('59', '揭阳市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('60', '云浮市', '2020-11-20 17:23:13', '19');
INSERT INTO `city` VALUES ('61', '呼和浩特市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('62', '包头市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('63', '乌海市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('64', '赤峰市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('65', '通辽市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('66', '鄂尔多斯市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('67', '呼伦贝尔市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('68', '巴彦淖尔市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('69', '乌兰察布市', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('70', '锡林郭勒盟', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('71', '兴安盟', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('72', '阿拉善盟', '2020-11-20 17:23:13', '28');
INSERT INTO `city` VALUES ('73', '东城区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('74', '西城区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('75', '朝阳区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('76', '崇文区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('77', '海淀区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('78', '宣武区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('79', '石景山区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('80', '门头沟区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('81', '丰台区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('82', '房山区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('83', '大兴区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('84', '通州区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('85', '顺义区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('86', '平谷区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('87', '昌平区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('88', '怀柔区', '2020-11-20 17:23:13', '33');
INSERT INTO `city` VALUES ('89', '中西区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('90', '湾仔区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('91', '东区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('92', '南区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('93', '油尖旺区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('94', '深水埗区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('95', '九龙城区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('96', '黄大仙区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('97', '观塘区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('98', '北区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('99', '大埔区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('100', '沙田区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('101', '西贡区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('102', '荃湾区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('103', '屯门区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('104', '元朗区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('105', '葵青区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('106', '离岛区', '2020-11-20 17:23:13', '37');
INSERT INTO `city` VALUES ('107', '花地玛堂区', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('108', '圣安多尼堂区', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('109', '大堂区', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('110', '望德堂区', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('111', '风顺堂区', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('112', '嘉模堂区(氹仔)', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('113', '圣方济各堂区(路环)', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('114', '路氹城', '2020-11-20 17:23:13', '38');
INSERT INTO `city` VALUES ('115', '黄浦区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('116', '徐汇区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('117', '长宁区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('118', '静安区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('119', '普陀区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('120', '虹口区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('121', '杨浦区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('122', '闵行区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('123', '宝山区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('124', '嘉定区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('125', '浦东区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('126', '金山区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('127', '松江区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('128', '青浦区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('129', '奉贤区', '2020-11-20 17:23:13', '35');
INSERT INTO `city` VALUES ('130', '崇明区', '2020-11-20 17:23:13', '35');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `sortNum` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '维护菜单', '/hjj/menu/menuManage', '', '0');
INSERT INTO `menu` VALUES ('2', '用户字典', '/hjj/user/userManage', '', '2');
INSERT INTO `menu` VALUES ('3', '角色字典', '/hjj/role/roleManage', '', '1');
INSERT INTO `menu` VALUES ('4', '学校字典', '/hjj/school/schoolManage', '', '8');
INSERT INTO `menu` VALUES ('5', '学生字典', '/hjj/student/studentManage', '', '9');
INSERT INTO `menu` VALUES ('6', '省份字典', '/hjj/province/provinceManage', '', '3');
INSERT INTO `menu` VALUES ('7', '城市字典', '/hjj/city/cityManage', '', '4');
INSERT INTO `menu` VALUES ('8', '地区字典', '/hjj/region/regionManage', '', '5');
INSERT INTO `menu` VALUES ('10', '学校类型', '/hjj/schoolType/schoolTypeManage', '', '7');
INSERT INTO `menu` VALUES ('11', '民族字典', '/hjj/nation/nationManage', '', '6');

-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nation
-- ----------------------------
INSERT INTO `nation` VALUES ('9', '汉族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('10', '满族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('11', '蒙古族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('12', '回族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('13', '藏族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('14', '维吾尔族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('15', '苗族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('16', '彝族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('17', '壮族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('18', '布依族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('19', '侗族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('20', '瑶族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('21', '白族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('22', '土家族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('23', '哈尼族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('24', '哈萨克族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('25', '傣族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('26', '黎族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('27', '傈僳族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('28', '佤族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('29', '畲族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('30', '高山族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('31', '拉祜族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('32', '水族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('33', '东乡族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('34', '纳西族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('35', '景颇族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('36', '柯尔克孜族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('37', '土族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('38', '达斡尔族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('39', '仫佬族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('40', '羌族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('41', '布朗族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('42', '撒拉族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('43', '毛南族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('44', '仡佬族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('45', '锡伯族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('46', '阿昌族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('47', '普米族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('48', '朝鲜族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('49', '塔吉克族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('50', '怒族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('51', '乌孜别克族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('52', '俄罗斯族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('53', '鄂温克族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('54', '德昂族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('55', '保安族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('56', '裕固族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('57', '京族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('58', '塔塔尔族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('59', '独龙族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('60', '鄂伦春族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('61', '赫哲族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('62', '门巴族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('63', '珞巴族', '2020-11-23 10:48:18');
INSERT INTO `nation` VALUES ('64', '基诺族', '2020-11-23 10:48:18');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('5', '河北省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('6', '山西省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('7', '辽宁省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('8', '吉林省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('9', '黑龙江省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('10', '江苏省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('11', '浙江省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('12', '安徽省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('13', '福建省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('14', '江西省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('15', '山东省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('16', '河南省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('17', '湖北省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('18', '湖南省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('19', '广东省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('20', '海南省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('21', '四川省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('22', '贵州省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('23', '云南省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('24', '陕西省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('25', '甘肃省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('26', '青海省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('27', '台湾省', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('28', '内蒙古自治区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('29', '广西壮族自治区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('30', '西藏自治区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('31', '宁夏回族自治区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('32', '新疆维吾尔自治区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('33', '北京市', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('34', '天津市', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('35', '上海市', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('36', '重庆市', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('37', '香港特别行政区', '2020-11-20 16:11:00');
INSERT INTO `province` VALUES ('38', '澳门特别行政区', '2020-11-20 16:11:00');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `cityId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_region_cityId` (`cityId`),
  CONSTRAINT `fk_region_cityId` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('9', '荔湾区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('10', '越秀区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('11', '海珠区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('12', '天河区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('13', '白云区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('14', '黄埔区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('15', '番禺区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('16', '花都区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('17', '南沙区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('18', '增城区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('19', '从化区', '2020-11-20 17:55:26', '40');
INSERT INTO `region` VALUES ('20', '禅城区', '2020-11-20 17:55:26', '44');
INSERT INTO `region` VALUES ('21', '南海区', '2020-11-20 17:55:26', '44');
INSERT INTO `region` VALUES ('22', '顺德区', '2020-11-20 17:55:26', '44');
INSERT INTO `region` VALUES ('23', '高明区', '2020-11-20 17:55:26', '44');
INSERT INTO `region` VALUES ('24', '三水区', '2020-11-20 17:55:26', '44');
INSERT INTO `region` VALUES ('25', '清城区', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('26', '清新区', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('27', '英德市', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('28', '连州市', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('29', '佛冈县', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('30', '阳山县', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('31', '连南瑶族自治县', '2020-11-20 17:55:26', '55');
INSERT INTO `region` VALUES ('32', '连山壮族瑶族自治县', '2020-11-20 17:55:26', '55');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '2020-11-12 12:00:00');
INSERT INTO `role` VALUES ('2', '普通用户', '2020-11-12 12:00:00');
INSERT INTO `role` VALUES ('3', '测试角色', '2020-11-17 10:06:44');
INSERT INTO `role` VALUES ('4', '测试角色2', '2020-11-17 10:07:33');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) DEFAULT NULL,
  `menuId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_menu_roleId` (`roleId`),
  KEY `fk_role_menu_menuId` (`menuId`),
  CONSTRAINT `fk_role_menu_menuId` FOREIGN KEY (`menuId`) REFERENCES `menu` (`id`),
  CONSTRAINT `fk_role_menu_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('32', '1', '1');
INSERT INTO `role_menu` VALUES ('33', '1', '2');
INSERT INTO `role_menu` VALUES ('34', '1', '3');
INSERT INTO `role_menu` VALUES ('35', '1', '4');
INSERT INTO `role_menu` VALUES ('36', '1', '5');
INSERT INTO `role_menu` VALUES ('44', '2', '4');
INSERT INTO `role_menu` VALUES ('45', '2', '5');
INSERT INTO `role_menu` VALUES ('46', '1', '6');
INSERT INTO `role_menu` VALUES ('47', '2', '6');
INSERT INTO `role_menu` VALUES ('48', '1', '7');
INSERT INTO `role_menu` VALUES ('49', '2', '7');
INSERT INTO `role_menu` VALUES ('50', '1', '8');
INSERT INTO `role_menu` VALUES ('51', '2', '8');
INSERT INTO `role_menu` VALUES ('52', '1', '10');
INSERT INTO `role_menu` VALUES ('53', '1', '11');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `regionId` int(10) DEFAULT NULL,
  `schoolTypeId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_school_regionId` (`regionId`),
  KEY `fk_school_schoolTypeId` (`schoolTypeId`),
  CONSTRAINT `fk_school_regionId` FOREIGN KEY (`regionId`) REFERENCES `region` (`id`),
  CONSTRAINT `fk_school_schoolTypeId` FOREIGN KEY (`schoolTypeId`) REFERENCES `schooltype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '东川路小学', '2020-11-23 10:54:34', '10', '2');

-- ----------------------------
-- Table structure for schooltype
-- ----------------------------
DROP TABLE IF EXISTS `schooltype`;
CREATE TABLE `schooltype` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schooltype
-- ----------------------------
INSERT INTO `schooltype` VALUES ('1', '幼儿园', '2020-11-18 16:24:25');
INSERT INTO `schooltype` VALUES ('2', '小学', '2020-11-18 16:24:31');
INSERT INTO `schooltype` VALUES ('3', '初中', '2020-11-18 16:24:38');
INSERT INTO `schooltype` VALUES ('4', '高中', '2020-11-18 16:24:44');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(13) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `nationId` int(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `addressRegionId` int(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `idNumber` varchar(20) DEFAULT NULL,
  `schoolId` int(10) DEFAULT NULL,
  `mobilePhoneNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_nationId` (`nationId`),
  KEY `fk_student_schoolId` (`addressRegionId`),
  CONSTRAINT `fk_student_nationId` FOREIGN KEY (`nationId`) REFERENCES `nation` (`id`),
  CONSTRAINT `fk_student_schoolId` FOREIGN KEY (`addressRegionId`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '2020-11-23 10:54:53', '男', '9', '1994-11-02', '10', '区庄哪里', '', '1', '12345678911');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '登录用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `roleId` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`),
  KEY `user_roleId` (`roleId`),
  CONSTRAINT `user_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'e0dd669bdfe0821b8083fe92b0689426', '超级管理员', 'admin@163.com', '2020-11-09 15:10:13', '1');
INSERT INTO `user` VALUES ('2', 'zhangsan', 'c2347dce7a75d18581b8dc129ec82dfc', '张三三', 'zhang@163.com', '2020-11-10 17:24:57', '2');
INSERT INTO `user` VALUES ('3', 'lisi', '174d8ee64f78e660ac496f34a37edee6', '李三', null, '2020-11-10 17:25:11', null);
INSERT INTO `user` VALUES ('4', 'wangwu', 'dbfbba9606016da9d6ba5ebc250831ed', '王五', null, '2020-11-10 17:25:25', null);
INSERT INTO `user` VALUES ('5', 'zhaoliu', 'b78d1d2ff7421c9cd6364a6869f6f6c5', '赵六', '123@qq.com', '2020-11-11 10:13:53', null);
INSERT INTO `user` VALUES ('12', 'Uzi', '83ceba15d36c15dd2b1d77ab5ab99fba', '乌兹', '', '2020-11-12 17:47:12', null);
INSERT INTO `user` VALUES ('13', '测试用户', '8503fe81c5a8f61b0abd26c84fb8970d', 'csyy', '', '2020-11-17 17:28:21', '4');
