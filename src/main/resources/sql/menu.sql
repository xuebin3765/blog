/*
 Navicat Premium Data Transfer

 Source Server         : mysql-本地
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : xb-blog

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 17/11/2019 15:11:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url_path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 1573915690000, '菜单管理', 0, 0, '菜单管理', '/admin/menu/list.html');
INSERT INTO `menu` VALUES (2, 1573915690000, '菜单列表', 1, 0, '菜单列表', '/admin/menu/list.html');
INSERT INTO `menu` VALUES (3, 1573915690000, '增加菜单', 1, 0, '增加菜单', '/admin/menu/laddMenu.html');
INSERT INTO `menu` VALUES (4, 1573915690000, '修改菜单', 1, 0, '修改菜单', '');
INSERT INTO `menu` VALUES (6, 1573915690000, '用户列表', 5, 0, '用户管理', '/admin/menu/list.html');
INSERT INTO `menu` VALUES (5, 1573915690000, '用户管理', 0, 0, '用户管理', '/admin/menu/list.html');

SET FOREIGN_KEY_CHECKS = 1;
