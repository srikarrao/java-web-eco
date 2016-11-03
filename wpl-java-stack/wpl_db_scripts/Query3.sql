create database wpl_rest;
use wpl_rest;
show tables;
select * from application_details;
select * from publisher_details;
drop database wpl_rest;

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `publisher_details`;
CREATE TABLE `publisher_details` (
  `PUBLISHER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `OFFICE_NAME` varchar(20),
  `PUBLISHED_DATE` date,
  PRIMARY KEY (`PUBLISHER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `wpl_rest`.`application_details`;
CREATE TABLE  `wpl_rest`.`application_details` (
  `APP_ID` int(10),
  `APP_STATUS` varchar(10),
   `BEGIN_DATE` date,
  `PUBLISHER_ID` int(10),
  PRIMARY KEY (`APP_ID`) USING BTREE,
  KEY `FK_APP_TRANSACTION_APP_ID` (`PUBLISHER_ID`),
  CONSTRAINT `FK_APP_TRANSACTION_APP_ID`
  FOREIGN KEY (`PUBLISHER_ID`) 
  REFERENCES `publisher_details` (`PUBLISHER_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;