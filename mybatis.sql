/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-10-15 17:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float(10,1) DEFAULT NULL,
  `detail` text,
  `pic` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '铅笔', '1.0', '11111', '无', '2017-10-05 10:40:11');
INSERT INTO `items` VALUES ('2', '橡皮', '1.5', '22222', '无', '2017-10-05 10:40:47');
INSERT INTO `items` VALUES ('3', '铅包', '5.0', '33333', '无', '2017-10-05 10:41:18');
INSERT INTO `items` VALUES ('4', '书', '4.0', '4444', '无', '2017-10-05 10:41:39');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) DEFAULT NULL,
  `items_id` int(11) DEFAULT NULL,
  `items_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_id` (`orders_id`),
  KEY `items_id` (`items_id`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '3', '1', '10');
INSERT INTO `orderdetail` VALUES ('2', '3', '2', '40');
INSERT INTO `orderdetail` VALUES ('3', '4', '1', '20');
INSERT INTO `orderdetail` VALUES ('4', '4', '2', '30');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `number` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '1', '10000010', '2017-09-28 20:27:13', null);
INSERT INTO `orders` VALUES ('4', '1', '10000011', '2017-09-28 20:27:30', null);
INSERT INTO `orders` VALUES ('5', '2', '10000012', '2017-09-28 20:27:46', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '李四', '女', '2017-09-10 00:00:00', '济南');
INSERT INTO `user` VALUES ('2', '王五', '男', '2017-09-10 00:00:00', '南京');
INSERT INTO `user` VALUES ('3', '王小二', '男', '2017-09-10 20:25:33', '重庆');
INSERT INTO `user` VALUES ('4', '张三', '男', '2017-09-10 00:00:00', '烟台');
INSERT INTO `user` VALUES ('5', '刘四', '男', '2017-09-10 20:13:07', '上海');
INSERT INTO `user` VALUES ('6', '赵四', '男', '2017-09-23 20:13:07', '上海');
