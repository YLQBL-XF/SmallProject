/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.62-community : Database - mydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `mydb`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `age` int(4) NOT NULL COMMENT '年龄',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `education` varchar(10) DEFAULT NULL COMMENT '学历',
  `identity` varchar(18) NOT NULL COMMENT '身份证号',
  `phon` int(11) DEFAULT NULL COMMENT '手机号',
  `unitname` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `unitaddress` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `create_date` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `modification_time` varchar(255) DEFAULT NULL COMMENT '修改时间',
  `upload_file` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`password`,`age`,`address`,`education`,`identity`,`phon`,`unitname`,`unitaddress`,`create_date`,`status`,`modification_time`,`upload_file`) values (5,NULL,NULL,10,NULL,NULL,'123456789456123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'113','6512bd43d9caa6e02c990b0a82652dca',1,'发的','大学','689898989644444565',1264531212,'来得及法律的思考','来得及法律的思考','17-9-5 ??3:29','0','17-9-5 ??3:29',NULL),(8,'113','6512bd43d9caa6e02c990b0a82652dca',1,'发的','大学','689898989644444565',1264531212,'来得及法律的思考','来得及法律的思考','17-9-5 ??3:29','0','17-9-5 ??3:29',NULL),(9,'113','6512bd43d9caa6e02c990b0a82652dca',1,'发的','大学','689898989644444565',1264531212,'来得及法律的思考','来得及法律的思考','17-9-5 ??3:29','0','17-9-5 ??3:29',NULL),(55,'111','222',1,'发','大学','689898989644444565',1264531212,'来得及法律的思考','来得及法律的思考','17-9-5 ??3:25','0','17-9-5 ??3:25',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
