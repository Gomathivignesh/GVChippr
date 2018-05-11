-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 34.211.81.224    Database: ebdb
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usergift`
--

DROP TABLE IF EXISTS `usergift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `sentTo` varchar(100) DEFAULT NULL,
  `sentOn` datetime DEFAULT NULL,
  `registeredEmail` varchar(100) DEFAULT NULL,
  `registeredDate` datetime DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergift`
--

LOCK TABLES `usergift` WRITE;
/*!40000 ALTER TABLE `usergift` DISABLE KEYS */;
INSERT INTO `usergift` VALUES (1,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52','','2016-09-25 11:02:33','1','2014-06-17 03:50:00'),(2,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52','','2016-09-25 11:08:32','2','2014-06-17 03:50:00'),(3,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52',NULL,NULL,'3','2014-06-17 03:50:00'),(4,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52',NULL,NULL,'4','2014-06-17 03:50:00'),(5,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52',NULL,NULL,'5','2014-06-17 03:50:00'),(6,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52','ramkanth526@gmail.com','2016-10-12 14:59:35','6','2014-06-17 03:50:00'),(7,1,10,'predeep@c1exchange.com','2015-08-12 15:19:52','test@mail.com','2016-11-12 06:04:05','7','2014-06-17 03:50:00'),(8,103,10,'predeep@c1exchange.com','2015-08-12 15:19:52','test2@mail.com','2016-11-12 06:05:27','8','2015-01-21 12:38:25'),(9,232,10,'predeep@c1exchange.com','2015-08-12 15:19:52','','2016-09-25 10:45:58','kcfuv72s9qdnbcvi4p844ogr6o','2015-08-12 15:19:18'),(10,232,10,'predeep@c1exchange.com',NULL,'test3@mail.com','2016-11-12 06:39:01','9','2015-08-12 15:23:46'),(11,232,10,'predeep@c1exchange.com',NULL,'test5@mail.com','2016-11-14 13:43:21','10','2015-08-16 17:50:05'),(12,232,10,'predeep@c1exchange.com',NULL,'test6@mail.com','2016-11-14 16:09:26','11','2015-08-16 17:50:05'),(13,232,10,'predeep@c1exchange.com',NULL,'test7@mail.com','2016-11-14 16:42:18','12','2015-08-16 17:50:05'),(14,232,10,'predeep@c1exchange.com',NULL,'test8@mail.com','2016-11-16 10:06:39','13','2015-08-16 17:50:05'),(15,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'14','2015-08-16 17:50:05'),(16,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'15',NULL),(17,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'16',NULL),(18,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'17',NULL),(19,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'18',NULL),(20,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'19',NULL),(21,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'20',NULL),(22,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'21',NULL),(23,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'22',NULL),(24,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'23',NULL),(25,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'24',NULL),(26,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'25',NULL),(27,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'26',NULL),(28,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'27',NULL),(29,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'28',NULL),(30,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'29',NULL),(31,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'30',NULL),(32,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'31',NULL),(33,232,10,'predeep@c1exchange.com',NULL,NULL,NULL,'32',NULL);
/*!40000 ALTER TABLE `usergift` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:29:56
