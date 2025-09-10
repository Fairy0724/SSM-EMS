/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : 20220620-hr

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 11/10/2023 21:30:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `day` date NULL DEFAULT NULL,
  `time_type` enum('上午','下午','加班') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` time NULL DEFAULT NULL,
  `start_type` enum('正常','迟到','未签到') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未签到',
  `end_time` time NULL DEFAULT NULL,
  `end_type` enum('正常','早退','未签退') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未签退',
  `work_type` enum('上班','请假') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (44, 1001, '2023-09-28', '下午', '16:54:21', '迟到', '16:55:04', '早退', NULL, NULL);
INSERT INTO `attendance` VALUES (45, 1001, '2023-09-28', '加班', '19:23:29', '正常', NULL, '未签到', NULL, NULL);
INSERT INTO `attendance` VALUES (46, 1001, '2023-10-11', '加班', '21:19:22', '迟到', '21:19:51', '早退', NULL, NULL);
INSERT INTO `attendance` VALUES (47, 1002, '2023-10-11', '加班', '21:22:06', '迟到', '21:23:59', '早退', NULL, NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `department_number` int NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 2001, '人事部', '王生安', '0923-3456180', '科技楼101', '');
INSERT INTO `department` VALUES (13, 2013, '技术部', '李烨', '0923-2456123', '办公楼108', '');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `department_number` int NULL DEFAULT NULL,
  `position_number` int NULL DEFAULT NULL,
  `in_time` date NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_number`(`department_number`) USING BTREE,
  INDEX `title_number`(`position_number`) USING BTREE,
  INDEX `employee_number`(`employee_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 1001, 'admin', '男', '1995-10-18', '15678015439', '', '', '', '', 2013, 3009, '2017-02-22', '1001', '');
INSERT INTO `employee` VALUES (8, 1002, '张龙', '男', '2022-06-11', '12312341234', '456@qq.com', '云南', '', '1', 2013, 3009, '2022-06-27', '1002', '刚摘的');
INSERT INTO `employee` VALUES (9, 1003, '王朝', '男', '2003-06-11', '12312341234', '123@163.com', '云南', '', '1', 2001, 3009, '2022-06-27', '1003', '快坏了');
INSERT INTO `employee` VALUES (10, 1006, '1004', '男', '2023-09-05', '14777858956', '123@qq.com', 'aaa', '', 'aaa', 2001, 3010, '2023-09-27', '1004', '1111');
INSERT INTO `employee` VALUES (11, 1007, '11111', '男', NULL, '', '', '', '', '', 2013, 3010, '2023-09-27', '123456', '');

-- ----------------------------
-- Table structure for gonggao
-- ----------------------------
DROP TABLE IF EXISTS `gonggao`;
CREATE TABLE `gonggao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gonggao
-- ----------------------------
INSERT INTO `gonggao` VALUES (1, '1', '1');
INSERT INTO `gonggao` VALUES (2, '2', '2');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `in_time` date NULL DEFAULT NULL,
  `out_time` date NULL DEFAULT NULL,
  `department_number` int NULL DEFAULT NULL,
  `position_number` int NULL DEFAULT NULL,
  `status` enum('离职','在职','退休') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `home` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, 1001, 'admin', '男', '1995-10-18', '15678015439', '', '', '', '', '2017-02-22', '2022-06-27', 2001, 3009, '在职', '', '');
INSERT INTO `history` VALUES (13, 1002, '张龙', '男', '2022-06-11', '12312341234', '456@qq.com', '云南', '', '1', '2022-06-27', NULL, 2013, 3010, '在职', '', '刚摘的');
INSERT INTO `history` VALUES (14, 1003, '王朝', '男', '2003-06-12', '12312341234', '123@163.com', '云南', '', '1', '2022-06-27', NULL, 2001, 3010, '在职', '', '快坏了');
INSERT INTO `history` VALUES (15, 1004, '张龙', '男', '2022-06-08', '12312341234', '456123@qq.com', '云南', '', '1', '2022-06-30', NULL, 2013, 3010, '离职', '', '123123123');
INSERT INTO `history` VALUES (16, 1005, '马汉', '男', '2022-06-09', '12312341234', '123123@qq.com', '云南', '', '1', '2022-06-30', NULL, 2013, 3010, '离职', '', '1sdfsa');
INSERT INTO `history` VALUES (17, 1006, '1004', '男', '2023-09-05', '14777858956', '123@qq.com', 'aaa', '', 'aaa', '2023-09-27', NULL, 2001, 3010, '在职', '', '1111');
INSERT INTO `history` VALUES (18, 1007, '11111', '男', NULL, '', '', '', '', '', '2023-09-27', NULL, 2013, 3010, '在职', '', '');

-- ----------------------------
-- Table structure for lea
-- ----------------------------
DROP TABLE IF EXISTS `lea`;
CREATE TABLE `lea`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `department_number` int NULL DEFAULT NULL,
  `start_time` date NULL DEFAULT NULL,
  `end_time` date NULL DEFAULT NULL,
  `days` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` enum('事假','病假') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` enum('已批准','未批准') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未批准',
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lea
-- ----------------------------
INSERT INTO `lea` VALUES (11, 1001, 2013, '2022-06-29', '2022-06-30', '2', '1123', '事假', NULL, '已批准', NULL);

-- ----------------------------
-- Table structure for move
-- ----------------------------
DROP TABLE IF EXISTS `move`;
CREATE TABLE `move`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `before` int NULL DEFAULT NULL,
  `after` int NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `manager` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of move
-- ----------------------------

-- ----------------------------
-- Table structure for overtime
-- ----------------------------
DROP TABLE IF EXISTS `overtime`;
CREATE TABLE `overtime`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `department_number` int NULL DEFAULT NULL,
  `employee_number` int NULL DEFAULT NULL,
  `day` date NULL DEFAULT NULL,
  `start_time` time NULL DEFAULT NULL,
  `end_time` time NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of overtime
-- ----------------------------
INSERT INTO `overtime` VALUES (9, 2001, 1002, '2022-06-28', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `position_number` int NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` enum('部门主任','部门员工','人事部主任','人事部员工') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `position_number`(`position_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (9, 3009, '人事部主任', '人事部主任', '');
INSERT INTO `position` VALUES (10, 3010, '人事部员工', '人事部员工', '');

-- ----------------------------
-- Table structure for rewards_punishment
-- ----------------------------
DROP TABLE IF EXISTS `rewards_punishment`;
CREATE TABLE `rewards_punishment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `employee_number` int NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` float(8, 0) NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `manager` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_number`(`employee_number`) USING BTREE,
  CONSTRAINT `rewards_punishment_ibfk_1` FOREIGN KEY (`employee_number`) REFERENCES `employee` (`employee_number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rewards_punishment
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
