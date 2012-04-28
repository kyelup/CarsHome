/*
Navicat MySQL Data Transfer

Source Server         : myslq
Source Server Version : 50135
Source Host           : localhost:3306
Source Database       : carshome

Target Server Type    : MYSQL
Target Server Version : 50135
File Encoding         : 65001

Date: 2012-04-27 18:14:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `carshome_brand`
-- ----------------------------
DROP TABLE IF EXISTS `carshome_brand`;
CREATE TABLE `carshome_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_desc` varchar(20) DEFAULT NULL,
  `brand_icon` varchar(50) DEFAULT NULL,
  `brand_country_id` int(10) DEFAULT NULL,
  `brand_sort_c` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_country_id` (`brand_country_id`),
  CONSTRAINT `brand_country_id` FOREIGN KEY (`brand_country_id`) REFERENCES `carshome_key_country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of carshome_brand
-- ----------------------------
INSERT INTO `carshome_brand` VALUES ('7', '比亚迪', 'ImagesUpload/201204271019058比亚迪.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('8', '北京汽车', 'ImagesUpload/201204271021022北京汽车.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('9', '北汽威旺', 'ImagesUpload/201204271021045北汽威旺.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('10', '北汽制造', 'ImagesUpload/201204271021059北汽制造.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('11', '奔腾', 'ImagesUpload/201204271022008奔腾.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('12', '宝骏汽车', 'ImagesUpload/201204271022024宝骏汽车.jpg', '1', 'B');
INSERT INTO `carshome_brand` VALUES ('13', '昌河', 'ImagesUpload/201204271022035昌河.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('14', '长安汽车', 'ImagesUpload/201204271022057长安汽车.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('15', '长城', 'ImagesUpload/201204271023049长城.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('16', '长安商用', 'ImagesUpload/201204271024002长安商用.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('17', '长丰', 'ImagesUpload/201204271024013长丰.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('18', '川汽野马', 'ImagesUpload/201204271024024川汽野马.jpg', '1', 'C');
INSERT INTO `carshome_brand` VALUES ('19', '东风', 'ImagesUpload/201204271024044东风.jpg', '1', 'D');
INSERT INTO `carshome_brand` VALUES ('20', '东风风神', 'ImagesUpload/201204271024053东风风神.jpg', '1', 'D');
INSERT INTO `carshome_brand` VALUES ('21', '东南', 'ImagesUpload/201204271025005东南.jpg', '1', 'D');
INSERT INTO `carshome_brand` VALUES ('22', '帝豪', 'ImagesUpload/201204271025017帝豪.jpg', '1', 'D');
INSERT INTO `carshome_brand` VALUES ('23', '大通', 'ImagesUpload/201204271025025大通.jpg', '1', 'D');
INSERT INTO `carshome_brand` VALUES ('24', '福田', 'ImagesUpload/201204271025035福田.jpg', '1', 'F');
INSERT INTO `carshome_brand` VALUES ('25', '广汽', 'ImagesUpload/201204271025049广汽.jpg', '1', 'G');
INSERT INTO `carshome_brand` VALUES ('26', '海马', 'ImagesUpload/201204271026002海马.jpg', '1', 'H');
INSERT INTO `carshome_brand` VALUES ('27', '华泰', 'ImagesUpload/201204271026013华泰.jpg', '1', 'H');
INSERT INTO `carshome_brand` VALUES ('28', '哈飞', 'ImagesUpload/201204271026024哈飞.jpg', '1', 'H');
INSERT INTO `carshome_brand` VALUES ('29', '黄海汽车', 'ImagesUpload/201204271026034黄海汽车.jpg', '1', 'H');
INSERT INTO `carshome_brand` VALUES ('30', '红旗', 'ImagesUpload/201204271026045红旗.jpg', '1', 'H');
INSERT INTO `carshome_brand` VALUES ('31', '江淮', 'ImagesUpload/201204271026058江淮.jpg', '1', 'J');
INSERT INTO `carshome_brand` VALUES ('32', '广汽吉奥', 'ImagesUpload/201204271027011广汽吉奥.jpg', '1', 'G');
INSERT INTO `carshome_brand` VALUES ('33', '吉利', 'ImagesUpload/201204271027022吉利.jpg', '1', 'J');
INSERT INTO `carshome_brand` VALUES ('34', '金杯', 'ImagesUpload/201204271027030金杯.jpg', '1', 'J');
INSERT INTO `carshome_brand` VALUES ('35', '江铃', 'ImagesUpload/201204271027041江铃.jpg', '1', 'J');
INSERT INTO `carshome_brand` VALUES ('36', '开瑞', 'ImagesUpload/201204271027054开瑞.jpg', '1', 'K');
INSERT INTO `carshome_brand` VALUES ('37', '力帆', 'ImagesUpload/201204271028010力帆.jpg', '1', 'L');
INSERT INTO `carshome_brand` VALUES ('38', '陆风', 'ImagesUpload/201204271028034陆风.jpg', '1', 'L');
INSERT INTO `carshome_brand` VALUES ('39', 'MG', 'ImagesUpload/201204271028050MG.jpg', '1', 'M');
INSERT INTO `carshome_brand` VALUES ('40', '纳智捷', 'ImagesUpload/201204271029012纳智捷.jpg', '1', 'N');
INSERT INTO `carshome_brand` VALUES ('41', '欧朗', 'ImagesUpload/201204271029025欧朗.png', '1', 'O');
INSERT INTO `carshome_brand` VALUES ('42', '奇瑞', 'ImagesUpload/201204271029038奇瑞.jpg', '1', 'Q');
INSERT INTO `carshome_brand` VALUES ('43', '全球鹰', 'ImagesUpload/201204271029048全球鹰.jpg', '1', 'Q');
INSERT INTO `carshome_brand` VALUES ('44', '荣威', 'ImagesUpload/201204271029059荣威.jpg', '1', 'R');
INSERT INTO `carshome_brand` VALUES ('45', '瑞麒', 'ImagesUpload/201204271030013瑞麒.jpg', '1', 'R');
INSERT INTO `carshome_brand` VALUES ('46', '双环', 'ImagesUpload/201204271030024双环.jpg', '1', 'S');
INSERT INTO `carshome_brand` VALUES ('47', '威麟', 'ImagesUpload/201204271030049威麟.jpg', '1', 'W');
INSERT INTO `carshome_brand` VALUES ('48', '五菱汽车', 'ImagesUpload/201204271030058五菱汽车.jpg', '1', 'W');
INSERT INTO `carshome_brand` VALUES ('49', '中国一汽', 'ImagesUpload/201204271031009中国一汽.jpg', '1', 'Z');
INSERT INTO `carshome_brand` VALUES ('50', '英伦汽车', 'ImagesUpload/201204271031021英伦汽车.jpg', '1', 'Y');
INSERT INTO `carshome_brand` VALUES ('51', '永源汽车', 'ImagesUpload/201204271031031永源汽车.jpg', '1', 'Y');
INSERT INTO `carshome_brand` VALUES ('52', '中华', 'ImagesUpload/201204271031041中华.jpg', '1', 'Z');
INSERT INTO `carshome_brand` VALUES ('53', '众泰', 'ImagesUpload/201204271031053众泰.jpg', '1', 'Z');
INSERT INTO `carshome_brand` VALUES ('54', '中兴', 'ImagesUpload/201204271032005中兴.jpg', '1', 'Z');
INSERT INTO `carshome_brand` VALUES ('55', '别克', 'ImagesUpload/201204271035005别克.jpg', '2', 'B');
INSERT INTO `carshome_brand` VALUES ('56', '道奇', 'ImagesUpload/201204271035015道奇.jpg', '2', 'D');
INSERT INTO `carshome_brand` VALUES ('57', '福特', 'ImagesUpload/201204271035025福特.jpg', '2', 'F');
INSERT INTO `carshome_brand` VALUES ('58', '悍马', 'ImagesUpload/201204271035044悍马.jpg', '2', 'H');
INSERT INTO `carshome_brand` VALUES ('59', 'Jeep', 'ImagesUpload/201204271035054jeep.jpg', '2', 'J');
INSERT INTO `carshome_brand` VALUES ('60', '凯迪拉克', 'ImagesUpload/201204271036006凯迪拉克.jpg', '2', 'K');
INSERT INTO `carshome_brand` VALUES ('61', '克莱斯勒', 'ImagesUpload/201204271036016克莱斯勒.jpg', '2', 'K');
INSERT INTO `carshome_brand` VALUES ('62', '林肯', 'ImagesUpload/201204271036026林肯.jpg', '2', 'L');
INSERT INTO `carshome_brand` VALUES ('63', '雪佛兰', 'ImagesUpload/201204271036036雪佛兰.jpg', '2', 'X');
INSERT INTO `carshome_brand` VALUES ('64', '奥迪', 'ImagesUpload/201204271037037奥迪.jpg', '3', 'O');
INSERT INTO `carshome_brand` VALUES ('65', '宝马', 'ImagesUpload/201204271037050宝马.jpg', '3', 'B');
INSERT INTO `carshome_brand` VALUES ('66', '奔驰', 'ImagesUpload/201204271037059奔驰.jpg', '3', 'B');
INSERT INTO `carshome_brand` VALUES ('67', '保时捷', 'ImagesUpload/201204271038017保时捷.jpg', '3', 'B');
INSERT INTO `carshome_brand` VALUES ('68', '大众', 'ImagesUpload/201204271038029大众.jpg', '3', 'D');
INSERT INTO `carshome_brand` VALUES ('69', '劳伦士', 'ImagesUpload/201204271038042劳伦士.jpg', '3', 'L');
INSERT INTO `carshome_brand` VALUES ('70', '迈巴赫', 'ImagesUpload/201204271038052迈巴赫.jpg', '3', 'M');
INSERT INTO `carshome_brand` VALUES ('71', '欧宝', 'ImagesUpload/201204271039005欧宝.jpg', '3', 'O');
INSERT INTO `carshome_brand` VALUES ('72', 'smart', 'ImagesUpload/201204271039017smart.jpg', '3', 'S');
INSERT INTO `carshome_brand` VALUES ('73', '中欧房车', 'ImagesUpload/201204271039028中欧房车.jpg', '3', 'Z');
INSERT INTO `carshome_brand` VALUES ('74', '本田', 'ImagesUpload/201204271039053本田.jpg', '4', 'B');
INSERT INTO `carshome_brand` VALUES ('75', '丰田', 'ImagesUpload/201204271040004丰田.jpg', '4', 'F');
INSERT INTO `carshome_brand` VALUES ('76', '光冈', 'ImagesUpload/201204271040013光冈.jpg', '4', 'G');
INSERT INTO `carshome_brand` VALUES ('77', '铃木', 'ImagesUpload/201204271040028铃木.jpg', '4', 'L');
INSERT INTO `carshome_brand` VALUES ('78', '雷克萨斯', 'ImagesUpload/201204271040038雷克萨斯.jpg', '4', 'L');
INSERT INTO `carshome_brand` VALUES ('79', '马自达', 'ImagesUpload/201204271040048马自达.jpg', '4', 'M');
INSERT INTO `carshome_brand` VALUES ('80', '讴歌', 'ImagesUpload/201204271040059讴歌.jpg', '4', 'O');
INSERT INTO `carshome_brand` VALUES ('81', '日产', 'ImagesUpload/201204271041009日产.jpg', '4', 'R');
INSERT INTO `carshome_brand` VALUES ('82', '三菱', 'ImagesUpload/201204271041018三菱.jpg', '4', 'S');
INSERT INTO `carshome_brand` VALUES ('83', '斯巴鲁', 'ImagesUpload/201204271041029斯巴鲁.jpg', '4', 'S');
INSERT INTO `carshome_brand` VALUES ('84', '英菲尼迪', 'ImagesUpload/201204271041039英菲尼迪.jpg', '4', 'Y');
INSERT INTO `carshome_brand` VALUES ('85', '起亚', 'ImagesUpload/201204271041054起亚.jpg', '5', 'Q');
INSERT INTO `carshome_brand` VALUES ('86', '双龙', 'ImagesUpload/201204271042001双龙.jpg', '5', 'S');
INSERT INTO `carshome_brand` VALUES ('87', '现代', 'ImagesUpload/201204271042011现代.jpg', '5', 'X');
INSERT INTO `carshome_brand` VALUES ('88', '标致', 'ImagesUpload/201204271042028标致.jpg', '6', 'B');
INSERT INTO `carshome_brand` VALUES ('89', '雷诺', 'ImagesUpload/201204271042038雷诺.jpg', '6', 'L');
INSERT INTO `carshome_brand` VALUES ('90', '雪铁龙', 'ImagesUpload/201204271042046雪铁龙.jpg', '6', 'X');
INSERT INTO `carshome_brand` VALUES ('91', '阿斯顿马丁', 'ImagesUpload/201204271043059阿斯顿马丁.jpg', '7', 'A');
INSERT INTO `carshome_brand` VALUES ('92', '宾利', 'ImagesUpload/201204271044007宾利.jpg', '7', 'B');
INSERT INTO `carshome_brand` VALUES ('93', '捷豹', 'ImagesUpload/201204271044017捷豹.jpg', '7', 'J');
INSERT INTO `carshome_brand` VALUES ('94', '劳斯莱斯', 'ImagesUpload/201204271045003劳斯莱斯.jpg', '7', 'L');
INSERT INTO `carshome_brand` VALUES ('95', '路虎', 'ImagesUpload/201204271045012路虎.jpg', '7', 'L');
INSERT INTO `carshome_brand` VALUES ('96', '路特斯', 'ImagesUpload/201204271045020路特斯.jpg', '7', 'L');
INSERT INTO `carshome_brand` VALUES ('97', 'MINI', 'ImagesUpload/201204271045029MINI.jpg', '7', 'M');
INSERT INTO `carshome_brand` VALUES ('98', '阿尔法罗米欧', 'ImagesUpload/201204271046009阿尔法罗米欧.jpg', '8', 'A');
INSERT INTO `carshome_brand` VALUES ('99', '布嘉迪', 'ImagesUpload/201204271046018布加迪.jpg', '8', 'B');
INSERT INTO `carshome_brand` VALUES ('100', '法拉利', 'ImagesUpload/201204271046040法拉利.jpg', '8', 'F');
INSERT INTO `carshome_brand` VALUES ('101', '菲亚特', 'ImagesUpload/201204271046048菲亚特.jpg', '8', 'F');
INSERT INTO `carshome_brand` VALUES ('102', '兰博基尼', 'ImagesUpload/201204271046056兰博基尼.jpg', '8', 'L');
INSERT INTO `carshome_brand` VALUES ('103', '玛莎拉蒂', 'ImagesUpload/201204271048008玛莎拉蒂.jpg', '8', 'M');
INSERT INTO `carshome_brand` VALUES ('104', '柯尼赛格', 'ImagesUpload/201204271048031柯尼赛格.jpg', '9', 'K');
INSERT INTO `carshome_brand` VALUES ('105', '帕加尼', 'ImagesUpload/201204271048044帕加尼.jpg', '9', 'P');
INSERT INTO `carshome_brand` VALUES ('106', '萨博', 'ImagesUpload/201204271048054萨博.jpg', '9', 'S');
INSERT INTO `carshome_brand` VALUES ('107', '沃尔沃', 'ImagesUpload/201204271049003沃尔沃.jpg', '9', 'W');
INSERT INTO `carshome_brand` VALUES ('108', '莲花汽车', 'ImagesUpload/201204271049018莲花汽车.jpg', '9', 'L');
INSERT INTO `carshome_brand` VALUES ('109', '斯柯达', 'ImagesUpload/201204271049034斯柯达.jpg', '9', 'S');
INSERT INTO `carshome_brand` VALUES ('110', '世爵', 'ImagesUpload/201204271049045世爵.jpg', '9', 'S');
INSERT INTO `carshome_brand` VALUES ('111', '西雅特', 'ImagesUpload/201204271049056西雅特.jpg', '9', 'X');

-- ----------------------------
-- Table structure for `carshome_brand_model`
-- ----------------------------
DROP TABLE IF EXISTS `carshome_brand_model`;
CREATE TABLE `carshome_brand_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_model_name` varchar(100) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `brand_id` FOREIGN KEY (`brand_id`) REFERENCES `carshome_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of carshome_brand_model
-- ----------------------------
INSERT INTO `carshome_brand_model` VALUES ('5', '比亚迪', '7');
INSERT INTO `carshome_brand_model` VALUES ('6', '北京汽车', '8');
INSERT INTO `carshome_brand_model` VALUES ('7', '北汽威旺', '9');
INSERT INTO `carshome_brand_model` VALUES ('8', '北汽制造', '10');
INSERT INTO `carshome_brand_model` VALUES ('9', '奔腾', '11');
INSERT INTO `carshome_brand_model` VALUES ('10', '宝骏汽车', '12');
INSERT INTO `carshome_brand_model` VALUES ('11', '昌河汽车', '13');
INSERT INTO `carshome_brand_model` VALUES ('12', '长安汽车', '14');
INSERT INTO `carshome_brand_model` VALUES ('13', '长城汽车', '15');
INSERT INTO `carshome_brand_model` VALUES ('14', '长安商用', '16');
INSERT INTO `carshome_brand_model` VALUES ('15', '广汽长丰', '17');
INSERT INTO `carshome_brand_model` VALUES ('16', '川汽野马', '18');
INSERT INTO `carshome_brand_model` VALUES ('17', '东风风行', '19');
INSERT INTO `carshome_brand_model` VALUES ('18', '东风汽车', '19');
INSERT INTO `carshome_brand_model` VALUES ('19', '东风-郑州日产', '19');
INSERT INTO `carshome_brand_model` VALUES ('20', '东风小康', '19');
INSERT INTO `carshome_brand_model` VALUES ('21', '东风风神', '20');
INSERT INTO `carshome_brand_model` VALUES ('22', '东南汽车', '21');
INSERT INTO `carshome_brand_model` VALUES ('23', '帝豪', '22');
INSERT INTO `carshome_brand_model` VALUES ('24', '大通', '23');
INSERT INTO `carshome_brand_model` VALUES ('25', '福田汽车', '24');
INSERT INTO `carshome_brand_model` VALUES ('26', '广汽乘用车', '25');
INSERT INTO `carshome_brand_model` VALUES ('27', '海马汽车', '26');
INSERT INTO `carshome_brand_model` VALUES ('28', '华泰汽车', '27');
INSERT INTO `carshome_brand_model` VALUES ('29', '哈飞汽车', '28');
INSERT INTO `carshome_brand_model` VALUES ('30', '黄海汽车', '29');
INSERT INTO `carshome_brand_model` VALUES ('31', '一汽红旗', '30');
INSERT INTO `carshome_brand_model` VALUES ('32', '江淮汽车', '31');
INSERT INTO `carshome_brand_model` VALUES ('33', '广汽吉奥', '32');
INSERT INTO `carshome_brand_model` VALUES ('34', '吉利', '33');
INSERT INTO `carshome_brand_model` VALUES ('35', '华晨金杯', '34');
INSERT INTO `carshome_brand_model` VALUES ('36', '江铃汽车', '35');
INSERT INTO `carshome_brand_model` VALUES ('37', '开瑞', '36');
INSERT INTO `carshome_brand_model` VALUES ('38', '力帆汽车', '37');
INSERT INTO `carshome_brand_model` VALUES ('39', '陆风汽车', '38');
INSERT INTO `carshome_brand_model` VALUES ('40', '上海汽车-MG', '39');
INSERT INTO `carshome_brand_model` VALUES ('41', '纳智捷', '40');
INSERT INTO `carshome_brand_model` VALUES ('42', '欧朗', '41');
INSERT INTO `carshome_brand_model` VALUES ('43', '奇瑞', '42');
INSERT INTO `carshome_brand_model` VALUES ('44', '全球鹰', '43');
INSERT INTO `carshome_brand_model` VALUES ('45', '上海汽车-荣威', '44');
INSERT INTO `carshome_brand_model` VALUES ('46', '瑞麒', '45');
INSERT INTO `carshome_brand_model` VALUES ('47', '双环汽车', '46');
INSERT INTO `carshome_brand_model` VALUES ('48', '威麟', '47');
INSERT INTO `carshome_brand_model` VALUES ('49', '上汽通用五菱', '48');
INSERT INTO `carshome_brand_model` VALUES ('50', '一汽天津', '49');
INSERT INTO `carshome_brand_model` VALUES ('51', '一汽吉林', '49');
INSERT INTO `carshome_brand_model` VALUES ('52', '英伦汽车', '50');
INSERT INTO `carshome_brand_model` VALUES ('53', '永源汽车', '51');
INSERT INTO `carshome_brand_model` VALUES ('54', '华晨中华', '52');
INSERT INTO `carshome_brand_model` VALUES ('55', '众泰汽车', '53');
INSERT INTO `carshome_brand_model` VALUES ('56', '中兴汽车', '54');
INSERT INTO `carshome_brand_model` VALUES ('57', '上海通用别克', '55');
INSERT INTO `carshome_brand_model` VALUES ('58', '进口别克', '55');
INSERT INTO `carshome_brand_model` VALUES ('59', '道奇(东南汽车)', '56');
INSERT INTO `carshome_brand_model` VALUES ('60', '进口道奇', '56');
INSERT INTO `carshome_brand_model` VALUES ('61', '长安福特', '57');
INSERT INTO `carshome_brand_model` VALUES ('62', '进口福特', '57');
INSERT INTO `carshome_brand_model` VALUES ('63', '悍马', '58');
INSERT INTO `carshome_brand_model` VALUES ('64', 'Jeep', '59');
INSERT INTO `carshome_brand_model` VALUES ('65', '上海通用凯迪拉克', '60');
INSERT INTO `carshome_brand_model` VALUES ('66', '进口凯迪拉克', '60');
INSERT INTO `carshome_brand_model` VALUES ('67', '进口克莱斯勒', '61');
INSERT INTO `carshome_brand_model` VALUES ('68', '克莱斯勒(东南汽车)', '61');
INSERT INTO `carshome_brand_model` VALUES ('69', '北京奔驰-戴克', '61');
INSERT INTO `carshome_brand_model` VALUES ('70', '林肯', '62');
INSERT INTO `carshome_brand_model` VALUES ('71', '上汽通用五菱雪佛兰', '63');
INSERT INTO `carshome_brand_model` VALUES ('72', '上海通用雪佛兰', '63');
INSERT INTO `carshome_brand_model` VALUES ('73', '雪佛兰', '63');
INSERT INTO `carshome_brand_model` VALUES ('74', '一汽奥迪', '64');
INSERT INTO `carshome_brand_model` VALUES ('75', '进口奥迪', '64');
INSERT INTO `carshome_brand_model` VALUES ('76', '华晨宝马', '65');
INSERT INTO `carshome_brand_model` VALUES ('77', '进口宝马', '65');
INSERT INTO `carshome_brand_model` VALUES ('78', 'BMW M', '65');
INSERT INTO `carshome_brand_model` VALUES ('79', '北京奔驰', '66');
INSERT INTO `carshome_brand_model` VALUES ('80', '进口奔驰', '66');
INSERT INTO `carshome_brand_model` VALUES ('81', '福建奔驰', '66');
INSERT INTO `carshome_brand_model` VALUES ('82', 'AMG', '66');
INSERT INTO `carshome_brand_model` VALUES ('83', '保时捷', '67');
INSERT INTO `carshome_brand_model` VALUES ('84', '上海大众', '68');
INSERT INTO `carshome_brand_model` VALUES ('85', '一汽大众', '68');
INSERT INTO `carshome_brand_model` VALUES ('86', '进口大众', '68');
INSERT INTO `carshome_brand_model` VALUES ('87', '进口劳伦士', '69');
INSERT INTO `carshome_brand_model` VALUES ('88', '迈巴赫', '70');
INSERT INTO `carshome_brand_model` VALUES ('89', '欧宝', '71');
INSERT INTO `carshome_brand_model` VALUES ('90', 'Smart', '72');
INSERT INTO `carshome_brand_model` VALUES ('91', '中欧房车', '73');
INSERT INTO `carshome_brand_model` VALUES ('92', '东风本田', '74');
INSERT INTO `carshome_brand_model` VALUES ('93', '广汽本田', '74');
INSERT INTO `carshome_brand_model` VALUES ('94', '进口本田', '74');
INSERT INTO `carshome_brand_model` VALUES ('95', '广汽丰田', '75');
INSERT INTO `carshome_brand_model` VALUES ('96', '一汽丰田', '75');
INSERT INTO `carshome_brand_model` VALUES ('97', '进口丰田', '75');
INSERT INTO `carshome_brand_model` VALUES ('98', '光冈', '76');
INSERT INTO `carshome_brand_model` VALUES ('99', '昌河铃木', '77');
INSERT INTO `carshome_brand_model` VALUES ('100', '长安铃木', '77');
INSERT INTO `carshome_brand_model` VALUES ('101', '进口铃木', '77');
INSERT INTO `carshome_brand_model` VALUES ('102', '雷克萨斯', '78');
INSERT INTO `carshome_brand_model` VALUES ('103', '一汽马自达', '79');
INSERT INTO `carshome_brand_model` VALUES ('104', '进口马自达', '79');
INSERT INTO `carshome_brand_model` VALUES ('105', '长安马自达', '79');
INSERT INTO `carshome_brand_model` VALUES ('106', '进口讴歌', '80');
INSERT INTO `carshome_brand_model` VALUES ('107', '东风日产', '81');
INSERT INTO `carshome_brand_model` VALUES ('108', '进口日产', '81');
INSERT INTO `carshome_brand_model` VALUES ('109', '郑州日产', '81');
INSERT INTO `carshome_brand_model` VALUES ('110', '东南三菱', '82');
INSERT INTO `carshome_brand_model` VALUES ('111', '进口三菱', '82');
INSERT INTO `carshome_brand_model` VALUES ('112', '斯巴鲁', '83');
INSERT INTO `carshome_brand_model` VALUES ('113', '英菲尼迪', '84');
INSERT INTO `carshome_brand_model` VALUES ('114', '东风悦达起亚', '85');
INSERT INTO `carshome_brand_model` VALUES ('115', '进口起亚', '85');
INSERT INTO `carshome_brand_model` VALUES ('116', '双龙', '86');
INSERT INTO `carshome_brand_model` VALUES ('117', '北京现代', '87');
INSERT INTO `carshome_brand_model` VALUES ('118', '进口现代', '87');
INSERT INTO `carshome_brand_model` VALUES ('119', '东风标致', '88');
INSERT INTO `carshome_brand_model` VALUES ('120', '进口标致', '88');
INSERT INTO `carshome_brand_model` VALUES ('121', '雷诺', '89');
INSERT INTO `carshome_brand_model` VALUES ('122', '东风雪铁龙', '90');
INSERT INTO `carshome_brand_model` VALUES ('123', '雪铁龙', '90');
INSERT INTO `carshome_brand_model` VALUES ('124', '阿斯顿马丁', '91');
INSERT INTO `carshome_brand_model` VALUES ('125', '宾利', '92');
INSERT INTO `carshome_brand_model` VALUES ('126', '捷豹', '93');
INSERT INTO `carshome_brand_model` VALUES ('127', '劳斯莱斯', '94');
INSERT INTO `carshome_brand_model` VALUES ('128', '路虎', '95');
INSERT INTO `carshome_brand_model` VALUES ('129', '路特斯', '96');
INSERT INTO `carshome_brand_model` VALUES ('130', 'MINI', '97');
INSERT INTO `carshome_brand_model` VALUES ('131', '阿尔法罗米欧', '98');
INSERT INTO `carshome_brand_model` VALUES ('132', '布嘉迪', '99');
INSERT INTO `carshome_brand_model` VALUES ('133', '法拉利', '100');
INSERT INTO `carshome_brand_model` VALUES ('134', '南京菲亚特', '101');
INSERT INTO `carshome_brand_model` VALUES ('135', '进口菲亚特', '101');
INSERT INTO `carshome_brand_model` VALUES ('136', '兰博基尼', '102');
INSERT INTO `carshome_brand_model` VALUES ('137', '玛莎拉蒂', '103');
INSERT INTO `carshome_brand_model` VALUES ('138', '柯尼赛格', '104');
INSERT INTO `carshome_brand_model` VALUES ('139', '帕加尼', '105');
INSERT INTO `carshome_brand_model` VALUES ('140', '萨博', '106');
INSERT INTO `carshome_brand_model` VALUES ('141', '进口沃尔沃', '107');
INSERT INTO `carshome_brand_model` VALUES ('142', '长安沃尔沃', '107');
INSERT INTO `carshome_brand_model` VALUES ('143', '莲花汽车', '108');
INSERT INTO `carshome_brand_model` VALUES ('144', '上海大众斯柯达', '109');
INSERT INTO `carshome_brand_model` VALUES ('145', '世爵', '110');
INSERT INTO `carshome_brand_model` VALUES ('146', '进口西雅特', '111');

-- ----------------------------
-- Table structure for `carshome_brand_model_car`
-- ----------------------------
DROP TABLE IF EXISTS `carshome_brand_model_car`;
CREATE TABLE `carshome_brand_model_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(20) DEFAULT NULL,
  `car_price_min` float(20,0) DEFAULT NULL,
  `car_price_max` float(20,0) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `model_id` (`model_id`),
  CONSTRAINT `model_id` FOREIGN KEY (`model_id`) REFERENCES `carshome_brand_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of carshome_brand_model_car
-- ----------------------------

-- ----------------------------
-- Table structure for `carshome_key_country`
-- ----------------------------
DROP TABLE IF EXISTS `carshome_key_country`;
CREATE TABLE `carshome_key_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of carshome_key_country
-- ----------------------------
INSERT INTO `carshome_key_country` VALUES ('1', '中国');
INSERT INTO `carshome_key_country` VALUES ('2', '美国');
INSERT INTO `carshome_key_country` VALUES ('3', '德国');
INSERT INTO `carshome_key_country` VALUES ('4', '日本');
INSERT INTO `carshome_key_country` VALUES ('5', '韩国');
INSERT INTO `carshome_key_country` VALUES ('6', '法国');
INSERT INTO `carshome_key_country` VALUES ('7', '英国');
INSERT INTO `carshome_key_country` VALUES ('8', '意大利');
INSERT INTO `carshome_key_country` VALUES ('9', '其他');

-- ----------------------------
-- Table structure for `carshome_key_pricescope`
-- ----------------------------
DROP TABLE IF EXISTS `carshome_key_pricescope`;
CREATE TABLE `carshome_key_pricescope` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prices_cope` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of carshome_key_pricescope
-- ----------------------------
INSERT INTO `carshome_key_pricescope` VALUES ('1', '5万以下');
INSERT INTO `carshome_key_pricescope` VALUES ('2', '5-10万');
INSERT INTO `carshome_key_pricescope` VALUES ('3', '10-15万');
INSERT INTO `carshome_key_pricescope` VALUES ('4', '15-20万');
INSERT INTO `carshome_key_pricescope` VALUES ('5', '20-30万');
INSERT INTO `carshome_key_pricescope` VALUES ('6', '30-50万');
INSERT INTO `carshome_key_pricescope` VALUES ('7', '50万以上');
