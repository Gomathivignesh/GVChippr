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
-- Table structure for table `healthcondition_bckup`
--

DROP TABLE IF EXISTS `healthcondition_bckup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `healthcondition_bckup` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conditions` text,
  `des` text,
  `link` text,
  `hcode` varchar(15) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COMMENT='Used to keep track of all Health conditions';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `healthcondition_bckup`
--

LOCK TABLES `healthcondition_bckup` WRITE;
/*!40000 ALTER TABLE `healthcondition_bckup` DISABLE KEYS */;
INSERT INTO `healthcondition_bckup` VALUES (1,'DMTS','Diabetes','testlink','1','2014-01-27 07:42:49','2014-01-27 07:42:49'),(2,'HYTN','Hypertension','testlink','2','2014-02-02 06:06:00','2014-02-02 06:06:00'),(3,'OBES','Obesity - overweight','testlink','3','2014-03-12 18:00:00','2014-03-12 19:00:00'),(4,'DEF','No Health Condition','testlink','0','2014-03-12 18:00:00','2014-03-12 18:00:00'),(5,'DMTS','Diabetes','testlink','1','2014-01-27 07:42:49','2014-01-27 07:42:49');
/*!40000 ALTER TABLE `healthcondition_bckup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:24:15
