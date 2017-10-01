/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.17-log : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) NOT NULL,
  `goods_amount` int(11) DEFAULT NULL,
  `goods_remain` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `goods_orders` */

DROP TABLE IF EXISTS `goods_orders`;

CREATE TABLE `goods_orders` (
  `goods_orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `goods_orders_time` datetime NOT NULL,
  `goods_orders_amount` int(11) NOT NULL,
  PRIMARY KEY (`goods_orders_id`),
  KEY `goods` (`goods_id`),
  CONSTRAINT `goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `goods_orders` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_num` varchar(11) NOT NULL,
  `room_type` int(2) NOT NULL DEFAULT '1',
  `room_size` int(2) NOT NULL,
  PRIMARY KEY (`room_num`),
  KEY `Room_Id` (`room_id`),
  KEY `size` (`room_size`),
  KEY `type` (`room_type`),
  CONSTRAINT `size` FOREIGN KEY (`room_size`) REFERENCES `roomsize` (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `room` */

/*Table structure for table `room_orders` */

DROP TABLE IF EXISTS `room_orders`;

CREATE TABLE `room_orders` (
  `room_orders_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_num` varchar(11) NOT NULL,
  `room_orders_start_time` datetime NOT NULL,
  `orders_type` varchar(11) NOT NULL,
  `room_orders_num` int(5) NOT NULL,
  `room_orders_end_time` datetime DEFAULT NULL,
  `room_price` int(11) NOT NULL,
  `room_orders_price` int(11) NOT NULL,
  PRIMARY KEY (`room_orders_id`),
  KEY `num` (`room_num`),
  CONSTRAINT `num` FOREIGN KEY (`room_num`) REFERENCES `room` (`room_num`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `room_orders` */

/*Table structure for table `roomsize` */

DROP TABLE IF EXISTS `roomsize`;

CREATE TABLE `roomsize` (
  `size_id` int(2) NOT NULL AUTO_INCREMENT,
  `size_name` varchar(10) NOT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `roomsize` */

insert  into `roomsize`(`size_id`,`size_name`) values 
(1,'标准间'),
(2,'圆床间'),
(3,'小单间'),
(4,'棋牌间');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(18) NOT NULL,
  `user_name` varchar(18) NOT NULL,
  `room_orders_id` int(11) NOT NULL,
  `user_tel` varchar(18) NOT NULL,
  `user_nation` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`room_orders_id`),
  KEY `roomOrdersId` (`room_orders_id`),
  CONSTRAINT `roomOrdersId` FOREIGN KEY (`room_orders_id`) REFERENCES `room_orders` (`room_orders_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
