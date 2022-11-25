/*
 Navicat Premium Data Transfer

 Source Server         : 47.106.183.99
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 47.106.183.99:3306
 Source Schema         : hr

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 25/11/2022 12:06:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint NOT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` int NULL DEFAULT NULL,
  `parent_id` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for extra_wages
-- ----------------------------
DROP TABLE IF EXISTS `extra_wages`;
CREATE TABLE `extra_wages`  (
  `hr_id` bigint NOT NULL,
  `bonus` decimal(24, 2) NULL DEFAULT NULL,
  `fine` decimal(24, 2) NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL COMMENT '额外工资的时间（每个月的奖金和罚金）',
  INDEX `hr_id`(`hr_id`) USING BTREE,
  CONSTRAINT `extra_wages_ibfk_1` FOREIGN KEY (`hr_id`) REFERENCES `hr_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hr_audit
-- ----------------------------
DROP TABLE IF EXISTS `hr_audit`;
CREATE TABLE `hr_audit`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `department_id` bigint NULL DEFAULT NULL COMMENT '单位Id',
  `nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faith` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宗教信仰',
  `time` datetime NULL DEFAULT NULL COMMENT '建档时间',
  `bank` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行',
  `bank_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行账号',
  `registrant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登记人',
  `resume` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '简历',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  `wage_standard_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '采用的工资标准id',
  `review_comments` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '审核意见',
  `agree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '-1' COMMENT '默认未审核为-1，审核通过为1，未通过为0',
  `hr_file_id` bigint NULL DEFAULT NULL COMMENT '更新时填入id',
  `reviewed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `reviewed_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `position_id` bigint NULL DEFAULT NULL,
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `position_id`(`position_id`) USING BTREE,
  CONSTRAINT `hr_audit_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hr_audit_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hr_file
-- ----------------------------
DROP TABLE IF EXISTS `hr_file`;
CREATE TABLE `hr_file`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `department_id` bigint NULL DEFAULT NULL COMMENT '单位Id',
  `nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faith` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '宗教信仰',
  `time` datetime NULL DEFAULT NULL COMMENT '建档时间',
  `bank` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行',
  `bank_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行账号',
  `registrant` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登记人',
  `resume` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '简历',
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  `wage_standard_id` bigint NULL DEFAULT NULL COMMENT '采用的工资标准id',
  `position_id` bigint NULL DEFAULT NULL,
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `state` int NULL DEFAULT NULL COMMENT '-1为正常，0为删除，1为待审核',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `wage_standard_id`(`wage_standard_id`) USING BTREE,
  CONSTRAINT `hr_file_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hr_file_ibfk_2` FOREIGN KEY (`wage_standard_id`) REFERENCES `wages_standard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `user_id` bigint NOT NULL,
  `login_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position_wage
-- ----------------------------
DROP TABLE IF EXISTS `position_wage`;
CREATE TABLE `position_wage`  (
  `department_id` bigint NOT NULL,
  `position_id` bigint NULL DEFAULT NULL,
  `wage_standard_id` bigint NOT NULL,
  INDEX `department_id`(`department_id`) USING BTREE,
  INDEX `position_id`(`position_id`) USING BTREE,
  CONSTRAINT `position_wage_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `position_wage_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for salary_payment_record
-- ----------------------------
DROP TABLE IF EXISTS `salary_payment_record`;
CREATE TABLE `salary_payment_record`  (
  `hr_id` bigint NOT NULL,
  `time` datetime NULL DEFAULT NULL COMMENT '确认时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '工资登记的userId',
  `base_pay` decimal(24, 2) NOT NULL COMMENT '基本工资',
  `transportation_subsidy` decimal(24, 2) NOT NULL COMMENT '交通补贴',
  `lunch_allowance` decimal(24, 2) NOT NULL COMMENT '午餐补贴',
  `communication_subsidy` decimal(24, 2) NOT NULL COMMENT '通信补贴',
  `pension_subsidy` decimal(24, 2) NOT NULL COMMENT '养老补贴',
  `unemployment_insurance` decimal(24, 2) NOT NULL COMMENT '失业保险',
  `medical_insurance` decimal(24, 2) NOT NULL COMMENT '医疗保险',
  `housing_provident_fund` decimal(24, 2) NOT NULL COMMENT '住房公积金',
  `bouns` decimal(24, 2) NOT NULL,
  `fine` decimal(24, 2) NOT NULL,
  `total` decimal(24, 2) NULL DEFAULT NULL COMMENT '总计',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `department_id` bigint NOT NULL,
  `id` bigint NOT NULL,
  `state` int NULL DEFAULT NULL COMMENT '0为未登记，1为以发放',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `hr_id`(`hr_id`) USING BTREE,
  CONSTRAINT `salary_payment_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `salary_payment_record_ibfk_2` FOREIGN KEY (`hr_id`) REFERENCES `hr_file` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_id` bigint NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wages_standard
-- ----------------------------
DROP TABLE IF EXISTS `wages_standard`;
CREATE TABLE `wages_standard`  (
  `id` bigint NOT NULL,
  `base_pay` decimal(24, 2) NOT NULL COMMENT '基本工资',
  `transportation_subsidy` decimal(24, 2) NOT NULL COMMENT '交通补贴',
  `lunch_allowance` decimal(24, 2) NOT NULL COMMENT '午餐补贴',
  `communication_subsidy` decimal(24, 2) NOT NULL COMMENT '通信补贴',
  `pension_subsidy` decimal(24, 2) NOT NULL COMMENT '养老补贴',
  `unemployment_insurance` decimal(24, 2) NOT NULL COMMENT '失业保险',
  `medical_insurance` decimal(24, 2) NOT NULL COMMENT '医疗保险',
  `housing_provident_fund` decimal(24, 2) NOT NULL COMMENT '住房公积金',
  `time` datetime NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wages_standard_audit
-- ----------------------------
DROP TABLE IF EXISTS `wages_standard_audit`;
CREATE TABLE `wages_standard_audit`  (
  `id` bigint NOT NULL,
  `base_pay` decimal(24, 2) NOT NULL COMMENT '基本工资',
  `transportation_subsidy` decimal(24, 2) NOT NULL COMMENT '交通补贴',
  `lunch_allowance` decimal(24, 2) NOT NULL COMMENT '午餐补贴',
  `communication_subsidy` decimal(24, 2) NOT NULL COMMENT '通信补贴',
  `pension_subsidy` decimal(24, 2) NOT NULL COMMENT '养老补贴',
  `unemployment_insurance` decimal(24, 2) NOT NULL COMMENT '失业保险',
  `medical_insurance` decimal(24, 2) NOT NULL COMMENT '医疗保险',
  `housing_provident_fund` decimal(24, 2) NOT NULL COMMENT '住房公积金',
  `time` datetime NULL DEFAULT NULL,
  `agree` int NULL DEFAULT NULL COMMENT '同意为1，不同意为0',
  `wages_standard_id` bigint NULL DEFAULT NULL COMMENT '修改为bull，添加为对应的id',
  `reviewed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `reviewed_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `wages_standard_id`(`wages_standard_id`) USING BTREE,
  CONSTRAINT `wages_standard_audit_ibfk_1` FOREIGN KEY (`wages_standard_id`) REFERENCES `wages_standard` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
