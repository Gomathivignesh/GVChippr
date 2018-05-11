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
-- Table structure for table `content_feed_comment`
--

DROP TABLE IF EXISTS `content_feed_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_feed_comment` (
  `id` int(1) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `content_feed_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `comment_text` text,
  `ratings` varchar(15) DEFAULT NULL,
  `created_dttm` datetime DEFAULT NULL,
  `updated_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_feed_comment`
--

LOCK TABLES `content_feed_comment` WRITE;
/*!40000 ALTER TABLE `content_feed_comment` DISABLE KEYS */;
INSERT INTO `content_feed_comment` VALUES (1,229,'bhanuchander33@gmail.com',36,'bhanu','p','feels good','5','2015-08-02 20:01:11','2015-08-02 20:01:11'),(4,229,'bhanuchander33@gmail.com',36,'bhanu','p','Awesome video','5','2015-08-02 20:01:11','2015-08-02 20:01:11'),(5,229,'bhanuchander33@gmail.com',36,'bhanu','p','its ok','0','2015-08-05 15:33:16','2015-08-05 15:33:16'),(8,86,'javed540@gmail.com',36,'Javed','Mdd','test comments from ios','5','2015-08-06 03:02:55','2015-08-06 03:02:55'),(9,86,'javed540@gmail.com',36,'Javed','Mdd','comment2 from ios','5','2015-08-06 03:04:46','2015-08-06 03:04:46'),(10,229,'bhanuchander33@gmail.com',35,'bhanu','p','what a video..great','5','2015-08-06 14:19:53','2015-08-06 14:19:53'),(11,86,'javed540@gmail.com',35,'Javed','D','what a video..great','5','2015-08-06 14:21:54','2015-08-06 14:21:54'),(12,86,'javed540@gmail.com',35,'javed','d','k k ','0','2015-08-06 14:22:46','2015-08-06 14:22:46'),(13,86,'javed540@gmail.com',41,'Javed','Mdd','Test comments0','5','2015-08-07 01:05:11','2015-08-07 01:05:11'),(14,86,'javed540@gmail.com',41,'Javed','Mdd','Test Comment1','5','2015-08-07 01:07:01','2015-08-07 01:07:01'),(15,86,'javed540@gmail.com',41,'Javed','Mdd','Test Comments3','5','2015-08-07 01:20:32','2015-08-07 01:20:32'),(16,86,'javed540@gmail.com',41,'Javed','Mdd','Test comment4','5','2015-08-07 01:21:35','2015-08-07 01:21:35'),(17,86,'javed540@gmail.com',41,'Javed','Mdd','test comments5','5','2015-08-07 01:22:47','2015-08-07 01:22:47'),(18,228,'s200@s.com',47,'Siva','Test','Energetic indeed .','5','2015-08-14 02:33:49','2015-08-14 02:33:49'),(19,4,'s3@s.com',46,'Sivakb','Kumar','this','5','2015-08-14 16:19:36','2015-08-14 16:19:36'),(20,86,'javed540@gmail.com',17,'Javed','Mdd','test comment1','5','2015-08-16 04:50:26','2015-08-16 04:50:26'),(21,86,'javed540@gmail.com',17,'Javed','Mdd','test commmet2','5','2015-08-16 04:50:48','2015-08-16 04:50:48'),(22,86,'javed540@gmail.com',17,'Javed','Mdd','test comment3','5','2015-08-16 04:51:01','2015-08-16 04:51:01'),(23,86,'javed540@gmail.com',17,'Javed','Mdd','test comment4','5','2015-08-16 04:51:17','2015-08-16 04:51:17'),(24,86,'javed540@gmail.com',17,'Javed','Mdd','test comment5','5','2015-08-16 04:52:27','2015-08-16 04:52:27'),(25,86,'javed540@gmail.com',15,'Javed','Mdd','test comment1','5','2015-08-16 04:52:38','2015-08-16 04:52:38'),(26,86,'javed540@gmail.com',15,'Javed','Mdd','test comment2','5','2015-08-16 04:52:45','2015-08-16 04:52:45'),(27,86,'javed540@gmail.com',15,'Javed','Mdd','test comment3','5','2015-08-16 04:52:51','2015-08-16 04:52:51'),(28,10,'s7@s.com',37,'Sss','Kkk','good','5','2015-10-03 04:29:51','2015-10-03 04:29:51'),(29,86,'javed540@gmail.com',40,'Javed','Mdd','Hi','5','2015-10-31 16:07:38','2015-10-31 16:07:38'),(30,343,'papu397@gmail.com',116,'Papu','LP','Hi...','5','2017-07-17 18:14:38','2017-07-17 18:14:38'),(31,343,'papu397@gmail.com',1091,'Papu','LP','Test','5','2017-07-17 20:19:49','2017-07-17 20:19:49'),(32,343,'papu397@gmail.com',1096,'Papu','LP','Test','5','2017-07-17 20:25:55','2017-07-17 20:25:55'),(33,341,'bapu397@gmail.com',NULL,'Bapu','Lp','Test','5','2017-07-17 20:31:45','2017-07-17 20:31:45'),(34,341,'bapu397@gmail.com',1104,'Bapu','Lp','Test','5','2017-07-17 20:32:24','2017-07-17 20:32:24'),(35,341,'bapu397@gmail.com',65,'Bapu','Lp','TEST','5','2017-07-17 20:35:18','2017-07-17 20:35:18'),(36,341,'bapu397@gmail.com',1101,'Bapu','Lp','TEST','0','2017-07-17 20:45:49','2017-07-17 20:45:49'),(37,341,'bapu397@gmail.com',NULL,'Bapu','Lp','TEST','5','2017-07-17 20:48:09','2017-07-17 20:48:09'),(38,341,'bapu397@gmail.com',NULL,'Bapu','Lp','ttt','5','2017-07-17 20:52:08','2017-07-17 20:52:08'),(39,343,'papu397@gmail.com',NULL,'Papu','LP','Test','5','2017-07-17 20:58:58','2017-07-17 20:58:58'),(40,343,'papu397@gmail.com',72,'Papu','LP','rrrrr','5','2017-07-17 21:02:38','2017-07-17 21:02:38'),(41,341,'bapu397@gmail.com',108,'Bapu','Lp','test','5','2017-07-20 13:29:45','2017-07-20 13:29:45'),(42,341,'bapu397@gmail.com',1109,'Bapu','Lp','test','5','2017-07-21 12:28:02','2017-07-21 12:28:02'),(43,341,'bapu397@gmail.com',1108,'Bapu','Lp','set test','5','2017-07-21 18:04:10','2017-07-21 18:04:10'),(44,341,'bapu397@gmail.com',71,'Bapu','Lp','hi','5','2017-11-03 12:10:30','2017-11-03 12:10:30');
/*!40000 ALTER TABLE `content_feed_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:29:49
