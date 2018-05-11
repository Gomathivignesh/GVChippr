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
-- Table structure for table `usercoursereview`
--

DROP TABLE IF EXISTS `usercoursereview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercoursereview` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(10) DEFAULT NULL,
  `courseId` int(10) DEFAULT NULL,
  `feedback` text,
  `ratings` varchar(15) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastUpdated` datetime DEFAULT NULL,
  `fName` varchar(45) DEFAULT NULL,
  `lName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `userId` (`userId`),
  KEY `courseId` (`courseId`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=latin1 COMMENT='Used to keep track of all user course review';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercoursereview`
--

LOCK TABLES `usercoursereview` WRITE;
/*!40000 ALTER TABLE `usercoursereview` DISABLE KEYS */;
INSERT INTO `usercoursereview` VALUES (1,2,20,'Test','5','2014-06-17 19:37:52','2014-06-17 19:37:52','Ss','Kk'),(2,2,20,'bad','0','2014-06-17 19:38:04','2014-06-17 19:38:04','Ss','Kk'),(3,8,20,'test','5','2014-06-26 20:52:24','2014-06-26 20:52:24','Thiru','Kumar'),(4,4,15,'test','5','2014-06-30 10:32:35','2014-06-30 10:32:35','Siva','Kumar'),(5,4,22,'nice one ','Rating is: 3.0','2014-07-05 09:55:20','2014-07-05 09:55:20','Siva','Kumar'),(6,4,22,'Good one.....!','Rating is: 4.0','2014-07-06 11:30:41','2014-07-06 11:30:41','Siva','Kumar'),(7,4,24,'testing in ios ','(null)','2014-07-08 17:30:56','2014-07-08 17:30:56','Siva','Kumar'),(8,4,61,'Yup really good app.....!','4','2014-07-18 17:00:50','2014-07-18 17:00:50','Siva','Kumar'),(9,22,173,'awesome','5','2014-07-19 06:15:26','2014-07-19 06:15:26','21','2'),(10,4,238,'','4','2014-07-19 06:56:00','2014-07-19 06:56:00','Siva','Kumar'),(11,4,238,'Things that really matter in life seldom announces it\'s value . One such vital aspect of our existence is our breath.','4','2014-07-19 11:14:12','2014-07-19 11:14:12','Siva','Kumar'),(12,2,238,'Nice course .....!   ','4','2014-07-19 11:28:53','2014-07-19 11:28:53','Arindam','Nath'),(13,2,238,'Good course to start ....','4','2014-07-19 11:33:23','2014-07-19 11:33:23','Arindam','Nath'),(14,4,238,'Good ......','4','2014-07-20 06:39:43','2014-07-20 06:39:43','Siva','Kumar'),(15,23,211,'Great session! Feeling relaxed.','5','2014-07-22 05:40:46','2014-07-22 05:40:46','Siva','Pr Kumar'),(16,21,78,'Nice! :)','5','2014-07-24 12:13:46','2014-07-24 12:13:46','Siva','Kumar'),(17,25,4,'Nice content!','5','2014-07-25 06:29:48','2014-07-25 06:29:48','Arindam','Nath'),(18,4,219,'Very refreshing','5','2014-07-29 01:23:47','2014-07-29 01:23:47','Siva','Kumar'),(19,4,219,'Fantastic','5','2014-07-29 01:24:23','2014-07-29 01:24:23','Siva','Kumar'),(20,4,219,'Not so far great','0','2014-07-29 01:24:44','2014-07-29 01:24:44','Siva','Kumar'),(21,4,219,'Nice','5','2014-07-29 01:39:16','2014-07-29 01:39:16','Siva','Kumar'),(22,4,219,'Energetic','5','2014-07-29 01:39:58','2014-07-29 01:39:58','Siva','Kumar'),(23,4,61,'Cool','5','2014-07-29 01:41:10','2014-07-29 01:41:10','Siva','Kumar'),(24,29,211,'Test','4','2014-08-14 06:24:10','2014-08-14 06:24:10','sai','palepu'),(25,29,201,'Test','4','2014-08-18 10:32:39','2014-08-18 10:32:39','sai','palepu'),(26,29,225,'Nice','4','2014-08-18 10:41:37','2014-08-18 10:41:37','sai','palepu'),(27,29,225,'Good','4','2014-08-18 10:46:21','2014-08-18 10:46:21','sai','palepu'),(28,29,225,'Nice','4','2014-08-18 10:52:56','2014-08-18 10:52:56','sai','palepu'),(29,29,201,'','4','2014-08-22 06:54:53','2014-08-22 06:54:53','sai','palepu'),(30,29,201,'','4','2014-08-22 06:55:17','2014-08-22 06:55:17','sai','palepu'),(31,29,201,'','4','2014-08-22 06:56:41','2014-08-22 06:56:41','sai','palepu'),(32,4,238,'nice one','5','2014-09-05 05:53:49','2014-09-05 05:53:49','Siva','Kumar'),(33,4,219,'hi','5','2014-09-11 09:39:12','2014-09-11 09:39:12','Siva','Kumar'),(34,23,7,'test','4','2014-10-26 17:07:56','2014-10-26 17:07:56','Siva','Pr Kumar'),(35,23,179,'good relaxation ','4','2014-11-01 20:39:02','2014-11-01 20:39:02','Siva','Pr Kumaran'),(36,23,179,'cool','4','2014-11-01 20:39:17','2014-11-01 20:39:17','Siva','Pr Kumaran'),(37,73,95,'Good tutorial...','5','2014-11-02 09:04:03','2014-11-02 09:04:03','Kiran','Kumar'),(38,73,67,'gud session','5','2014-11-02 09:21:23','2014-11-02 09:21:23','Kiran','Kumar'),(39,4,246,'cool','5','2014-11-03 05:28:59','2014-11-03 05:28:59','Siva','Kumar'),(40,4,246,'I wish it\'s a bit faster','0','2014-11-03 05:29:32','2014-11-03 05:29:32','Siva','Kumar'),(41,4,246,'ok','0','2014-11-03 05:30:38','2014-11-03 05:30:38','Siva','Kumar'),(42,4,9,'cool','5','2014-11-09 01:29:21','2014-11-09 01:29:21','Sivas','Kumar'),(43,4,9,'ok','0','2014-11-09 01:30:50','2014-11-09 01:30:50','Sivas','Kumar'),(44,73,7,'gud tutorial','0','2014-11-09 11:06:11','2014-11-09 11:06:11','Kiran','Kumar'),(45,73,7,'Test2','5','2014-11-09 11:11:08','2014-11-09 11:11:08','Kiran','Kumar'),(46,4,246,'cool','0','2014-11-10 01:47:27','2014-11-10 01:47:27','Sivas','Kumar'),(47,4,203,'what??','0','2014-11-10 01:52:22','2014-11-10 01:52:22','Sivas','Kumar'),(48,4,204,'refreshing!','5','2014-12-24 10:29:09','2014-12-24 10:29:09','Sivak','Kumar'),(49,4,182,'Awesome','5','2015-01-12 03:11:27','2015-01-12 03:11:27','Sivakb','Kumar'),(50,4,182,'Cool','5','2015-01-12 03:11:54','2015-01-12 03:11:54','Sivakb','Kumar'),(51,4,182,'This course is great','5','2015-01-12 03:12:58','2015-01-12 03:12:58','Sivakb','Kumar'),(52,97,244,'awesome!','5','2015-01-12 03:19:41','2015-01-12 03:19:41','Apple','Cupertino '),(53,105,67,'I like it!','5','2015-01-26 02:29:51','2015-01-26 02:29:51','mukundu','kumaran'),(54,105,67,'I like it!','5','2015-01-26 02:30:02','2015-01-26 02:30:02','mukundu','kumaran'),(55,105,67,'I like it!','0','2015-01-26 02:30:19','2015-01-26 02:30:19','mukundu','kumaran'),(56,142,201,'good','5','2015-02-25 05:10:31','2015-02-25 05:10:31','Thiru','Kum'),(57,142,201,'good','5','2015-02-25 05:10:34','2015-02-25 05:10:34','Thiru','Kum'),(58,142,95,'good','5','2015-02-25 05:17:10','2015-02-25 05:17:10','Thiru','Kum'),(59,190,230,'This is the best stress buster in my pocket! Thank you!','5','2015-04-19 01:56:20','2015-04-19 01:56:20','S70','Siva'),(60,197,203,'very nice ','5','2015-04-29 20:20:46','2015-04-29 20:20:46','Vijay','Gopi'),(61,84,225,'excellent','5','2015-04-30 08:27:08','2015-04-30 08:27:08','Senthil','Narayanan'),(62,229,264,'hi','0','2015-07-26 13:53:46','2015-07-26 13:53:46','Bhanu','P'),(63,229,264,'hi','5','2015-07-26 13:53:51','2015-07-26 13:53:51','Bhanu','P');
/*!40000 ALTER TABLE `usercoursereview` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:25:00
