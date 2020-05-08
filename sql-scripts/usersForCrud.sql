CREATE DATABASE  IF NOT EXISTS `wojtek`;
USE `wojtek`;

--
-- Table structure for table `userWithoutSecurity`;
--

DROP TABLE IF EXISTS `user_without_security`;

CREATE TABLE `user_without_security`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `account_creation_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `user`
--

INSERT INTO `user_without_security` VALUES 
	(1,'Witold','Tracz','witold@yahoo.com','2019-12-10 00:54:44'),
	(2,'Karol','Leptak','karol@gmail.com','2020-01-20 16:13:55'),
	(3,'Fiona','Gupta','fiona@op.pl','2010-09-06 13:47:42'),
	(4,'Urszula','Kral','urszula@gmail.com','2020-12-30 05:08:12'),
	(5,'Pawel','Precel','pawel@wp.com','2019-06-26 11:15:55');

