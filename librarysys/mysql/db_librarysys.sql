/*
Navicat MySQL Data Transfer

Source Server         : cz
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : db_librarysys

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2018-08-24 23:02:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_bookcase
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookcase`;
CREATE TABLE `tb_bookcase` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_bookcase
-- ----------------------------
INSERT INTO `tb_bookcase` VALUES ('4', '左A-1');
INSERT INTO `tb_bookcase` VALUES ('5', '左A-2');
INSERT INTO `tb_bookcase` VALUES ('6', '右A-1');

-- ----------------------------
-- Table structure for tb_bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookinfo`;
CREATE TABLE `tb_bookinfo` (
  `barcode` varchar(30) default NULL,
  `bookname` varchar(70) default NULL,
  `typeid` int(10) unsigned default NULL,
  `author` varchar(30) default NULL,
  `translator` varchar(30) default NULL,
  `ISBN` varchar(20) default NULL,
  `price` float(8,2) default NULL,
  `page` int(10) unsigned default NULL,
  `bookcase` int(10) unsigned default NULL,
  `inTime` date default NULL,
  `operator` varchar(30) default NULL,
  `del` tinyint(1) default '0',
  `id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_bookinfo
-- ----------------------------
INSERT INTO `tb_bookinfo` VALUES ('9787302210337', 'Java Web开发实战宝典', '4', '王国辉', '', '302', '89.00', '834', '4', '2011-02-24', 'mr', '0', '7');
INSERT INTO `tb_bookinfo` VALUES ('9787115195975', 'Java Web开发典型模块大全', '4', '王国辉、王毅、王殊宇', '', '115', '89.00', '752', '5', '2011-02-24', 'mr', '0', '8');
INSERT INTO `tb_bookinfo` VALUES ('4521212', 'njknjn', '5', 'mnm', '', '115', '11.00', '0', '4', '2011-02-24', 'mr', '1', '9');
INSERT INTO `tb_bookinfo` VALUES ('gf', 'gfhgf', '4', '', '', '111', '26.00', '0', '4', '2011-02-24', 'mr', '1', '10');

-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `tb_booktype`;
CREATE TABLE `tb_booktype` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `typename` varchar(30) default NULL,
  `days` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_booktype
-- ----------------------------
INSERT INTO `tb_booktype` VALUES ('4', '网络编程', '20');
INSERT INTO `tb_booktype` VALUES ('5', '数据库开发', '15');

-- ----------------------------
-- Table structure for tb_borrow
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE `tb_borrow` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `readerid` int(10) unsigned default NULL,
  `bookid` int(10) default NULL,
  `borrowTime` date default NULL,
  `backTime` date default NULL,
  `operator` varchar(30) default NULL,
  `ifback` tinyint(1) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('7', '4', '7', '2011-02-24', '2011-03-16', 'mr', '1');
INSERT INTO `tb_borrow` VALUES ('8', '4', '7', '2011-02-24', '2011-03-16', 'mr', '0');
INSERT INTO `tb_borrow` VALUES ('9', '5', '8', '2011-02-24', '2011-04-05', 'mr', '0');

-- ----------------------------
-- Table structure for tb_giveback
-- ----------------------------
DROP TABLE IF EXISTS `tb_giveback`;
CREATE TABLE `tb_giveback` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `readerid` int(11) default NULL,
  `bookid` int(11) default NULL,
  `backTime` date default NULL,
  `operator` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_giveback
-- ----------------------------
INSERT INTO `tb_giveback` VALUES ('3', '4', '7', '2011-02-24', 'mr');

-- ----------------------------
-- Table structure for tb_library
-- ----------------------------
DROP TABLE IF EXISTS `tb_library`;
CREATE TABLE `tb_library` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `libraryname` varchar(50) default NULL,
  `curator` varchar(10) default NULL,
  `tel` varchar(20) default NULL,
  `address` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `url` varchar(100) default NULL,
  `createDate` date default NULL,
  `introduce` text,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_library
-- ----------------------------
INSERT INTO `tb_library` VALUES ('1', '?????', 'mr', '18327864132', '???????????', '3196614820@qq.com', 'http://www.360doc.com/content/16/0610/07/31073618_566416814.shtml', '2018-07-06', '?????????????????');

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `PWD` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('1', 'mr', '201540410101');
INSERT INTO `tb_manager` VALUES ('12', 'chenzheng', '408496');
INSERT INTO `tb_manager` VALUES ('9', 'admin', '111');

-- ----------------------------
-- Table structure for tb_parameter
-- ----------------------------
DROP TABLE IF EXISTS `tb_parameter`;
CREATE TABLE `tb_parameter` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `cost` int(10) unsigned default NULL,
  `validity` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_parameter
-- ----------------------------
INSERT INTO `tb_parameter` VALUES ('1', '30', '6');

-- ----------------------------
-- Table structure for tb_publishing
-- ----------------------------
DROP TABLE IF EXISTS `tb_publishing`;
CREATE TABLE `tb_publishing` (
  `ISBN` varchar(20) NOT NULL COMMENT 'ISBN号',
  `pubname` varchar(30) default NULL COMMENT '出版社名称',
  PRIMARY KEY  (`ISBN`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_publishing
-- ----------------------------
INSERT INTO `tb_publishing` VALUES ('111', '机械工业出版社');
INSERT INTO `tb_publishing` VALUES ('115', '人民邮电出版社');
INSERT INTO `tb_publishing` VALUES ('302', '清华大学出版社');

-- ----------------------------
-- Table structure for tb_purview
-- ----------------------------
DROP TABLE IF EXISTS `tb_purview`;
CREATE TABLE `tb_purview` (
  `id` int(11) NOT NULL,
  `sysset` tinyint(1) default '0',
  `readerset` tinyint(1) default '0',
  `bookset` tinyint(1) default '0',
  `borrowback` tinyint(1) default '0',
  `sysquery` tinyint(1) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_purview
-- ----------------------------
INSERT INTO `tb_purview` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `tb_purview` VALUES ('12', '1', '1', '1', '1', '1');
INSERT INTO `tb_purview` VALUES ('9', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `sex` varchar(4) default NULL,
  `barcode` varchar(30) default NULL,
  `vocation` varchar(50) default NULL,
  `birthday` date default NULL,
  `paperType` varchar(10) default NULL,
  `paperNO` varchar(20) default NULL,
  `tel` varchar(20) default NULL,
  `email` varchar(100) default NULL,
  `createDate` date default NULL,
  `operator` varchar(30) default NULL,
  `remark` text,
  `typeid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('4', '琦琦', '女', '20110224000001', '学生', '2010-07-10', '身份证', '220104201007100001', '84978981', 'wgh717@sohu.com', '2011-02-24', 'mr', '无', '4');
INSERT INTO `tb_reader` VALUES ('5', 'wgh', '女', '20110224000002', '程序员', '1980-07-10', '工作证', '20010228', '84978981', 'wgh717@sohu.com', '2011-02-24', 'mr', '无', '4');
INSERT INTO `tb_reader` VALUES ('6', 'uui', '男', 'iuoui', '', null, '身份证', 'iuoi', '', 'nmb', '2011-02-24', 'mr', '', '4');

-- ----------------------------
-- Table structure for tb_readertype
-- ----------------------------
DROP TABLE IF EXISTS `tb_readertype`;
CREATE TABLE `tb_readertype` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `number` int(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_readertype
-- ----------------------------
INSERT INTO `tb_readertype` VALUES ('4', '学生', '1');
INSERT INTO `tb_readertype` VALUES ('6', '1', '5');
