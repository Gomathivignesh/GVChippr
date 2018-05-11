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
-- Table structure for table `exclusionmap`
--

DROP TABLE IF EXISTS `exclusionmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exclusionmap` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hcId` varchar(15) DEFAULT NULL,
  `hcCode` varchar(15) DEFAULT NULL,
  `btCode` varchar(15) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastUpdated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=197 DEFAULT CHARSET=latin1 COMMENT='Used to keep track of all bt exclusion for special cases';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exclusionmap`
--

LOCK TABLES `exclusionmap` WRITE;
/*!40000 ALTER TABLE `exclusionmap` DISABLE KEYS */;
INSERT INTO `exclusionmap` VALUES (2,'1','DEF','DRTBPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(3,'1','DEF','DRTCPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(1,'1','DEF','DRTAPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(91,'10','HERN','DRTPRD','2014-07-18 00:00:00','2015-03-27 00:00:00'),(90,'10','HERN','DRTPRC','2014-07-18 00:00:00','2015-03-27 00:00:00'),(89,'10','HERN','DRTPRB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(88,'10','HERN','DRTPRA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(87,'10','HERN','PRMBPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(86,'10','HERN','PRMAPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(85,'10','HERN','PSPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(84,'10','HERN','HSPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(83,'10','HERN','QRTPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(82,'10','HERN','DRTCPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(81,'10','HERN','DRTBPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(80,'10','HERN','DRTAPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(79,'10','HERN','MSRT','2014-07-18 00:00:00','2015-03-27 00:00:00'),(78,'10','HERN','BRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(77,'10','HERN','PS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(76,'10','HERN','HS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(75,'10','HERN','NB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(74,'10','HERN','NAS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(73,'50','EPIL','DRTPRD','2014-07-18 00:00:00','2015-03-27 00:00:00'),(72,'50','EPIL','DRTPRC','2014-07-18 00:00:00','2015-03-27 00:00:00'),(71,'50','EPIL','DRTPRB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(70,'50','EPIL','DRTPRA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(69,'50','EPIL','NAS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(68,'50','EPIL','NB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(67,'50','EPIL','BRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(66,'50','EPIL','MSRT','2014-07-18 00:00:00','2015-03-27 00:00:00'),(65,'50','EPIL','PS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(64,'50','EPIL','HS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(63,'50','EPIL','PRMBLISSB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(62,'50','EPIL','PRMBLISSA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(61,'50','EPIL','PRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(60,'50','EPIL','PRMB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(59,'50','EPIL','PRMA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(58,'50','PREG','DRTPRD','2014-07-18 00:00:00','2015-03-27 00:00:00'),(57,'50','PREG','DRTPRC','2014-07-18 00:00:00','2015-03-27 00:00:00'),(56,'50','PREG','DRTPRB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(55,'50','PREG','DRTPRA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(54,'50','PREG','IRTS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(53,'50','PREG','PRMBLISSB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(52,'50','PREG','PRMBLISSA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(51,'50','PREG','PRMB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(50,'50','PREG','PRMA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(49,'50','PREG','PRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(48,'50','PREG','NAS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(47,'50','PREG','NB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(46,'50','PREG','MSRT','2014-07-18 00:00:00','2015-03-27 00:00:00'),(45,'50','PREG','HS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(44,'50','PREG','PS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(43,'50','PREG','BRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(42,'4','BRAS','DRTBLISS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(41,'4','BRAS','DRTPRD','2014-07-18 00:00:00','2015-03-27 00:00:00'),(40,'4','BRAS','DRTPRC','2014-07-18 00:00:00','2015-03-27 00:00:00'),(39,'4','BRAS','DRTPRB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(38,'4','BRAS','DRTPRA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(37,'4','BRAS','MSRT','2014-07-18 00:00:00','2015-03-27 00:00:00'),(36,'4','BRAS','NB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(35,'4','BRAS','NAS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(34,'4','BRAS','PRMB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(33,'4','BRAS','PRMA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(32,'4','BRAS','PRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(31,'4','BRAS','PRMBLISSB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(30,'4','BRAS','PRMBLISSA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(29,'4','BRAS','BRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(28,'4','BRAS','PS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(27,'4','BRAS','HS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(26,'4','BRAS','IRTL','2014-07-18 00:00:00','2015-03-27 00:00:00'),(25,'4','BRAS','IRTS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(24,'2','COHD','DRTBLISS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(23,'2','COHD','DRTRRD','2014-07-18 00:00:00','2015-03-27 00:00:00'),(22,'2','COHD','DRTRRC','2014-07-18 00:00:00','2015-03-27 00:00:00'),(21,'2','COHD','DRTRRB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(20,'2','COHD','DRTRRA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(19,'2','COHD','NAS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(18,'2','COHD','PRMBLISSB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(17,'2','COHD','PRMBLISSA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(16,'2','COHD','PRMB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(15,'2','COHD','PRMA','2014-07-18 00:00:00','2015-03-27 00:00:00'),(14,'2','COHD','PRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(13,'2','COHD','MSRT','2014-07-18 00:00:00','2015-03-27 00:00:00'),(12,'2','COHD','NB','2014-07-18 00:00:00','2015-03-27 00:00:00'),(11,'2','COHD','PS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(10,'2','COHD','HS','2014-07-18 00:00:00','2015-03-27 00:00:00'),(9,'2','COHD','BRM','2014-07-18 00:00:00','2015-03-27 00:00:00'),(8,'1','DEF','PRMBPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(7,'1','DEF','PRMAPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(6,'1','DEF','PSPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(5,'1','DEF','HSPREG','2014-07-18 00:00:00','2015-03-27 00:00:00'),(4,'1','DEF','QRTPREG','2014-07-18 00:00:00','2015-03-27 00:00:00');
/*!40000 ALTER TABLE `exclusionmap` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:26:08