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
-- Table structure for table `content_feed_favourite`
--

DROP TABLE IF EXISTS `content_feed_favourite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_feed_favourite` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `content_feed_type_id` int(11) DEFAULT NULL,
  `user_email_id` varchar(50) DEFAULT NULL,
  `created_dttm` datetime DEFAULT NULL,
  `isFavour` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_feed_favourite`
--

LOCK TABLES `content_feed_favourite` WRITE;
/*!40000 ALTER TABLE `content_feed_favourite` DISABLE KEYS */;
INSERT INTO `content_feed_favourite` VALUES (1,1,'bhanuchander33@gmail.com','2015-07-20 11:11:11',1),(2,2,'bhanuchander33@gmail.com','2015-07-20 03:58:34',1),(3,3,'bhanuchander33@gmail.com','2015-07-20 03:58:57',0),(4,6,'bhanuchander33@gmail.com','2015-07-20 03:59:00',0),(6,13,'bhanuchander33@gmail.com','2015-07-20 03:59:17',0),(7,19,'bhanuchander33@gmail.com','2015-07-20 03:59:28',0),(9,9,'(null)','2015-07-21 15:10:14',0),(11,19,'(null)','2015-07-21 15:19:16',0),(13,17,'(null)','2015-07-21 15:21:00',0),(22,18,'bhanuchander33@gmail.com','2015-07-22 07:20:41',0),(91,37,'s7@s.com','2015-10-03 04:17:28',0),(98,15,'s3@s.com','2015-11-28 19:42:14',0),(109,38,'m@mm.com','2016-01-04 07:27:55',0),(113,28,'drsjey@gmail.com','2016-02-17 05:19:29',0),(117,19,'drsjey@gmail.com','2016-02-23 10:20:51',0),(118,65,'drsjey@gmail.com','2016-03-10 04:24:04',0),(120,78,'a1@a1.com','2016-04-01 23:15:31',0),(121,76,'s3@s.com','2016-04-21 15:50:31',0),(126,80,'s400@s.com','2016-04-27 02:02:58',0),(127,84,'s400@s.com','2016-04-27 02:03:00',0),(128,88,'s400@s.com','2016-04-27 02:03:05',0),(129,92,'s400@s.com','2016-04-27 02:03:08',0),(130,81,'s400@s.com','2016-04-27 02:03:10',0),(131,85,'s400@s.com','2016-04-27 02:03:12',0),(132,89,'s400@s.com','2016-04-27 02:03:14',0),(133,93,'s400@s.com','2016-04-27 02:03:16',0),(134,82,'s400@s.com','2016-04-27 02:03:19',0),(135,86,'s400@s.com','2016-04-27 02:03:21',0),(136,90,'s400@s.com','2016-04-27 02:03:23',0),(137,94,'s400@s.com','2016-04-27 02:03:25',0),(138,52,'s400@s.com','2016-04-27 02:03:27',0),(139,53,'bonusesportal@gmail.com','2016-05-11 10:07:39',0),(142,52,'bonusesportal@gmail.com','2016-05-11 10:07:54',0),(143,95,'bonusesportal@gmail.com','2016-05-11 10:08:26',0),(146,62,'bonusesportal@gmail.com','2016-05-11 10:38:47',0),(148,56,'vijay.gopineedi@gmail.com','2016-06-16 00:44:47',0),(153,253,'vikigm@gmail.com','2017-07-17 14:02:46',1),(154,20,'vikigm@gmail.com','2017-07-17 14:03:53',1),(156,155,'vikigm@gmail.com','2017-07-17 14:07:10',0),(158,154,'vikigm@gmail.com','2017-07-17 14:09:51',0),(159,26,'papu397@gmail.com','2017-07-17 17:55:17',0),(160,159,'papu397@gmail.com','2017-07-17 17:58:00',0),(162,120,'papu397@gmail.com','2017-07-17 18:26:53',0),(163,18,'papu397@gmail.com','2017-07-17 18:26:59',0),(164,72,'papu397@gmail.com','2017-07-17 21:02:49',0),(165,16,'papu397@gmail.com','2017-07-17 21:07:46',0),(166,98,'papu397@gmail.com','2017-07-17 21:08:00',0),(167,115,'papu397@gmail.com','2017-07-18 07:37:50',0),(168,216,'bapu397@gmail.com','2017-07-20 14:06:41',0),(169,35,'vikigm@gmail.com',NULL,1),(170,252,'vikigm@gmail.com',NULL,1),(171,333,'vikigm@gmail.com',NULL,1),(172,333,'bapu397@gmail.com',NULL,1),(173,6,'bapu397@gmail.com',NULL,0),(175,6,'papu397@gmail.com',NULL,1),(177,71,'vikigm@gmail.com',NULL,1),(178,249888,'papu397@gmail.com',NULL,0),(179,254112,'papu397@gmail.com',NULL,0),(180,248416,'papu397@gmail.com',NULL,0),(181,2281504,'papu397@gmail.com',NULL,0),(182,8,'papu397@gmail.com',NULL,1),(183,246496,'papu397@gmail.com',NULL,0),(184,2243264,'bapu397@gmail.com',NULL,0),(185,18,'vikigm@gmail.com',NULL,0),(186,2319136,'bapu397@gmail.com',NULL,0),(187,1108,'bapu397@gmail.com',NULL,1),(188,1109,'bapu397@gmail.com',NULL,1),(189,231,'vikigm@gmail.com',NULL,1),(190,1176,'vikigm@gmail.com',NULL,1),(191,61,'vikigm@gmail.com',NULL,0),(192,8,'vikigm@gmail.com',NULL,1),(193,28,'bapu398@gmail.com',NULL,0),(194,7,'bapu398@gmail.com',NULL,1),(195,65,'bapu398@gmail.com',NULL,1),(196,231,'bapu398@gmail.com',NULL,0),(197,235,'bapu398@gmail.com',NULL,1),(198,345,'drsjey@gmail.com',NULL,1),(199,342,'bapu397@gmail.com',NULL,0),(200,71,'bapu397@gmail.com',NULL,1),(201,705,'bapu397@gmail.com',NULL,1),(202,706,'bapu397@gmail.com',NULL,0),(203,243,'bapu397@gmail.com',NULL,0),(204,235,'bapu397@gmail.com',NULL,1),(205,368,'bapu397@gmail.com',NULL,1),(206,35,'San.ian.skelton@gmail.com',NULL,1);
/*!40000 ALTER TABLE `content_feed_favourite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:29:36
