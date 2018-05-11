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
-- Table structure for table `breath_cycle_ml_map`
--

DROP TABLE IF EXISTS `breath_cycle_ml_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `breath_cycle_ml_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cycle` int(11) NOT NULL,
  `current_module` varchar(45) NOT NULL,
  `current_level` varchar(45) NOT NULL,
  `next_module` varchar(45) NOT NULL,
  `next_level` varchar(45) NOT NULL,
  `created` datetime NOT NULL,
  `lastUpdated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `breath_cycle_ml_map`
--

LOCK TABLES `breath_cycle_ml_map` WRITE;
/*!40000 ALTER TABLE `breath_cycle_ml_map` DISABLE KEYS */;
INSERT INTO `breath_cycle_ml_map` VALUES (1,28,'M1','L1','M1','L2','2015-05-15 00:00:00','2015-05-15 00:00:00'),(2,26,'M1','L2','M1','L3','2015-05-15 00:00:00','2015-05-15 00:00:00'),(3,24,'M1','L3','M1','L4','2015-05-15 00:00:00','2015-05-15 00:00:00'),(4,22,'M1','L4','M1','L5','2015-05-15 00:00:00','2015-05-15 00:00:00'),(5,20,'M1','L5','M1','L6','2015-05-15 00:00:00','2015-05-15 00:00:00'),(6,18,'M1','L6','M1','L7','2015-05-15 00:00:00','2015-05-15 00:00:00'),(7,16,'M1','L7','M1','L8','2015-05-15 00:00:00','2015-05-15 00:00:00'),(9,14,'M2','L1','M2','L2','2015-05-15 00:00:00','2015-05-15 00:00:00'),(10,12,'M3','L1','M3','L1','2015-05-15 00:00:00','2015-05-15 00:00:00'),(12,10,'M4','L1','M5','L1','2015-05-15 00:00:00','2015-05-15 00:00:00'),(13,8,'M5','L1','M6','L1','2015-05-15 00:00:00','2015-05-15 00:00:00'),(14,6,'M6','L1','M6','L1','2015-05-15 00:00:00','2015-05-15 00:00:00');
/*!40000 ALTER TABLE `breath_cycle_ml_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:26:23
