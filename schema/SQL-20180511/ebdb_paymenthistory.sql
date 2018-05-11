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
-- Table structure for table `paymenthistory`
--

DROP TABLE IF EXISTS `paymenthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymenthistory` (
  `id` varchar(15) NOT NULL,
  `purchaseMethod` int(11) DEFAULT NULL,
  `paymentType` int(11) DEFAULT NULL,
  `billedAmount` varchar(100) DEFAULT NULL,
  `transactionId` varchar(100) DEFAULT NULL,
  `otherDetails` varchar(1000) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymenthistory`
--

LOCK TABLES `paymenthistory` WRITE;
/*!40000 ALTER TABLE `paymenthistory` DISABLE KEYS */;
INSERT INTO `paymenthistory` VALUES ('1',2,0,'10','2215000040','1|1|1|This transaction has been approved.|0L5R78|Y|2215000040||101 Yrs Subscription/Gift Payment|10.00|CC|auth_capture||R|P||100 Main St||CA|94599||||||||||||||||||E37CF6A0D78EAA1047AD2644D8816F02||2|||||||||||XXXX1111|Visa||||||||||||||||','2014-06-17 03:48:50','2014-06-17 03:48:50'),('1',2,0,'60','2215000054','1|1|1|This transaction has been approved.|DMCMPN|Y|2215000054||101 Yrs Subscription/Gift Payment|60.00|CC|auth_capture||a|a||a||CA|11111||||||||||||||||||E06CFA0D240B810CF874C55CAE4DBD3D||2|||||||||||XXXX1111|Visa||||||||||||||||','2014-06-17 03:50:00','2014-06-17 03:50:00'),('7',2,0,'10','t12389',NULL,'2015-01-19 05:24:17','2015-01-19 05:24:17'),('101',2,0,'10','t12389',NULL,'2015-01-19 05:29:36','2015-01-19 05:29:36'),('102',2,0,'10','t12389',NULL,'2015-01-19 06:20:53','2015-01-19 06:20:53'),('103',2,0,'10','t12389',NULL,'2015-01-21 12:37:47','2015-01-21 12:37:47'),('103',2,0,'10','t12389',NULL,'2015-01-21 12:38:25','2015-01-21 12:38:25'),('133',2,0,'10','t12389',NULL,'2015-02-20 05:42:42','2015-02-20 05:42:42'),('158',2,0,'10','t12389',NULL,'2015-03-13 14:21:44','2015-03-13 14:21:44'),('176',2,0,'10','t12389',NULL,'2015-04-03 00:24:33','2015-04-03 00:24:33'),('232',2,0,'10','t12389',NULL,'2015-08-12 15:17:50','2015-08-12 15:17:50'),('232',2,0,'10','t12389',NULL,'2015-08-12 15:19:18','2015-08-12 15:19:18'),('232',2,0,'10','t12389',NULL,'2015-08-12 15:23:46','2015-08-12 15:23:46'),('232',2,0,'10','t12389',NULL,'2015-08-16 17:50:05','2015-08-16 17:50:05');
/*!40000 ALTER TABLE `paymenthistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:24:54
