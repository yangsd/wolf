/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : wolf

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-11-04 23:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `seq` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_resource
-- ----------------------------

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `seq` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role
-- ----------------------------

-- ----------------------------
-- Table structure for auth_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_resource`;
CREATE TABLE `auth_role_resource` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `loginid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleid` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `weixinid` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('1', '1@qq.com', '1', '581099e0624630c689178f5b95620cbd', '1', '06f01f914dc1dae4b67dcd2bef5d2a23', 'sdyang', '\0', null, null, null);
INSERT INTO `auth_user` VALUES ('4', '2', '2', '86b95b3e02b6614e52c291f526673b24', '1', 'f7b346729f5c1370a065bab47726c2e0', '2', '\0', null, null, null);

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sql_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_sql_config`;
CREATE TABLE `sys_sql_config` (
  `id` int(11) NOT NULL,
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `dialect` varchar(255) DEFAULT NULL,
  `dr` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_sql_config
-- ----------------------------
