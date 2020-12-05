/*
 Navicat Premium Data Transfer

 Source Server         : 47.98.63.50
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 47.98.63.50:3306
 Source Schema         : shop_goods

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 05/12/2020 14:09:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_permission
-- ----------------------------
DROP TABLE IF EXISTS `app_permission`;
CREATE TABLE `app_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `permission_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `permission_order` int(11) DEFAULT NULL,
  `permission_type` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_permission
-- ----------------------------
BEGIN;
INSERT INTO `app_permission` VALUES (1, 0, 'USER_MGR', '用户管理', '', 'el-icon-s-custom', 1, 1);
INSERT INTO `app_permission` VALUES (2, 1, 'USER_LIST', '用户列表', '/users', NULL, 1, 1);
INSERT INTO `app_permission` VALUES (3, 0, 'PERMISSION_MGR', '权限管理', NULL, 'el-icon-s-management', 2, 1);
INSERT INTO `app_permission` VALUES (4, 3, 'ROLE_LIST', '角色列表', '/roles', NULL, 1, 1);
INSERT INTO `app_permission` VALUES (5, 3, 'PERMISSION_LIST', '权限列表', '/permissions', NULL, 2, 1);
INSERT INTO `app_permission` VALUES (6, 2, 'ADD_USER', '添加用户', NULL, NULL, 1, 2);
INSERT INTO `app_permission` VALUES (7, 2, 'EDIT_USER', '修改用户', NULL, NULL, 2, 2);
INSERT INTO `app_permission` VALUES (8, 2, 'DEL_USER', '删除用户', NULL, NULL, 3, 2);
INSERT INTO `app_permission` VALUES (9, 4, 'ADD_ROLE', '添加角色', NULL, NULL, 3, 2);
INSERT INTO `app_permission` VALUES (10, 4, 'DEL_ROLE', '删除角色', NULL, NULL, 3, 2);
COMMIT;

-- ----------------------------
-- Table structure for app_role
-- ----------------------------
DROP TABLE IF EXISTS `app_role`;
CREATE TABLE `app_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `status` smallint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_role
-- ----------------------------
BEGIN;
INSERT INTO `app_role` VALUES (1, '管理员', '系统管理员', NULL);
INSERT INTO `app_role` VALUES (3, '客服主管', '部门负责人', NULL);
INSERT INTO `app_role` VALUES (5, '总经理', '部门负责人', NULL);
INSERT INTO `app_role` VALUES (6, '生产主管', '负责人', NULL);
COMMIT;

-- ----------------------------
-- Table structure for app_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `app_role_permission`;
CREATE TABLE `app_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `app_role_permission` VALUES (1, 1);
INSERT INTO `app_role_permission` VALUES (1, 2);
INSERT INTO `app_role_permission` VALUES (1, 3);
INSERT INTO `app_role_permission` VALUES (1, 4);
INSERT INTO `app_role_permission` VALUES (1, 5);
INSERT INTO `app_role_permission` VALUES (1, 6);
INSERT INTO `app_role_permission` VALUES (1, 7);
INSERT INTO `app_role_permission` VALUES (1, 8);
INSERT INTO `app_role_permission` VALUES (1, 9);
INSERT INTO `app_role_permission` VALUES (1, 10);
INSERT INTO `app_role_permission` VALUES (3, 1);
INSERT INTO `app_role_permission` VALUES (3, 2);
INSERT INTO `app_role_permission` VALUES (3, 3);
INSERT INTO `app_role_permission` VALUES (3, 5);
INSERT INTO `app_role_permission` VALUES (3, 8);
INSERT INTO `app_role_permission` VALUES (5, 1);
INSERT INTO `app_role_permission` VALUES (5, 2);
INSERT INTO `app_role_permission` VALUES (5, 6);
INSERT INTO `app_role_permission` VALUES (6, 1);
INSERT INTO `app_role_permission` VALUES (6, 2);
INSERT INTO `app_role_permission` VALUES (6, 7);
COMMIT;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_user
-- ----------------------------
BEGIN;
INSERT INTO `app_user` VALUES (1, 'yangb', '$2a$10$e/Vgw1zKQDdyxd/DvyNSMeeT0TQhaDB9KbUoN8jC2f8MV9lGUobcy', '杨斌', '15000000000', 1, '523084685@qq.com', '2020-11-30 22:11:42');
INSERT INTO `app_user` VALUES (2, 'yangcq', '$2a$10$e/Vgw1zKQDdyxd/DvyNSMeeT0TQhaDB9KbUoN8jC2f8MV9lGUobcy', '杨超越', '13023021132', 0, 'yangchy@art.com', '2020-12-01 12:58:03');
INSERT INTO `app_user` VALUES (3, 'fanbb', '$2a$10$e/Vgw1zKQDdyxd/DvyNSMeeT0TQhaDB9KbUoN8jC2f8MV9lGUobcy', '范冰冰', '12322312331', 0, 'fanbb@art.com', '2020-12-01 12:59:29');
INSERT INTO `app_user` VALUES (5, 'muxj', '$2a$10$RfHZIYllemJNi/qjOuRV3OGbGz84xyxrLoWZ.YP/wayYa9z3GyoXm', '慕小娟', '13234564326', NULL, '523084685@qq.com', NULL);
INSERT INTO `app_user` VALUES (7, 'tongdw', '$2a$10$DAzGaibwTv4Iv4FGTkEYR.353rURvu9y3v0yS3CfP9OKxK8tQUs3e', '佟大为', '15232132456', 0, 'tongdw@art.com', NULL);
INSERT INTO `app_user` VALUES (9, 'mujy', '$2a$10$3FU/67IMw3nwQ8lZy3XE5OaRm9rmvp4fAVXnLX/Hst26AJGTkkMfe', '慕军义', '13209874231', 0, 'mujy@nm.com', '2020-12-01 07:37:53');
INSERT INTO `app_user` VALUES (10, 'yangzg', '$2a$10$TlGZ2ZldsSgouWf.1lvgX.f8.EGjHq9GSobfLKeG/XyaKpBoj3XmW', '杨正刚', '13323421234', 0, 'yangzg@nm.com', '2020-12-01 22:41:54');
COMMIT;

-- ----------------------------
-- Table structure for app_user_role
-- ----------------------------
DROP TABLE IF EXISTS `app_user_role`;
CREATE TABLE `app_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of app_user_role
-- ----------------------------
BEGIN;
INSERT INTO `app_user_role` VALUES (1, 1);
INSERT INTO `app_user_role` VALUES (10, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
