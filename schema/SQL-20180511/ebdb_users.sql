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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pwd` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `mname` varchar(32) DEFAULT NULL,
  `lname` varchar(100) NOT NULL,
  `dob` datetime DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL,
  `currentLevel` varchar(100) DEFAULT NULL,
  `currentModule` varchar(100) DEFAULT NULL,
  `score` int(10) DEFAULT NULL,
  `btMorning` int(10) DEFAULT NULL,
  `btAfternoon` int(10) DEFAULT NULL,
  `btEvening` int(10) DEFAULT NULL,
  `sequence` decimal(10,4) DEFAULT NULL,
  `cycle` int(10) DEFAULT NULL,
  `metrics` text,
  `userType` varchar(45) DEFAULT NULL,
  `referralId` varchar(45) DEFAULT NULL,
  `rewards` int(10) DEFAULT NULL,
  `subsBeginDate` datetime DEFAULT NULL,
  `subsEndDate` datetime DEFAULT NULL,
  `trialBeginDate` datetime DEFAULT NULL,
  `trialEndDate` datetime DEFAULT NULL,
  `calibration` varchar(5) DEFAULT NULL,
  `primaryhealthcondition` int(10) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `bmi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=383 DEFAULT CHARSET=latin1 COMMENT='Used to keep track of all User accounts';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (350,'4a0f2905d0f03712ee901f307fef1291193971bc','drsjey@gmail.com','(null)','','(null)','1974-10-27 00:00:00','female','2017-07-25 06:33:15','2017-10-27 17:37:11','L1','M6',0,1,1,1,NULL,6,'[{\"inHaleTime\":\"5\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"6\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"7\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"6\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"7\"}]','0',NULL,NULL,NULL,NULL,'2017-07-25 06:33:15','2017-08-25 06:33:15','1',NULL,'152','110','BMI: 21'),(336,'20eabe5d64b0e216796e834f52d61fd0b70332fc','j@101years.com','meera','','meera','1986-06-15 00:00:00','Male','2017-05-05 15:12:35','2017-05-05 15:12:35',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-05-05 15:12:35','2017-06-05 15:12:35',NULL,NULL,NULL,NULL,NULL),(337,'7110eda4d09e062aa5e4a390b0a572ac0d2c0220','support@chippr.et','meera','','meera','1986-06-15 00:00:00','Male','2017-05-05 15:14:54','2017-05-05 15:14:54',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-05-05 15:14:54','2017-06-05 15:14:54',NULL,NULL,NULL,NULL,NULL),(338,'fb248deebc852556a3ad01872628897b1a4693d5','cristabrennan@yahoo.com','Crista','','Brennan',NULL,NULL,'2017-05-07 17:37:33','2017-05-07 17:39:12','L5','M1',NULL,1,1,1,NULL,20,'[{\"inHaleTime\":\"9\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"9\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-05-07 17:37:33','2017-06-07 17:37:33','1',NULL,NULL,NULL,NULL),(339,'0f6ea648fa0d2d1c4c68816f06b2c728a81464bb','jehoonkim@gmail.com','Je Hoon','','Kim','1982-02-26 00:00:00','Male','2017-06-07 20:10:17','2017-06-08 01:50:51','L1','M2',NULL,1,1,1,NULL,14,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"}]','0',NULL,NULL,NULL,NULL,'2017-06-07 20:10:17','2017-07-07 20:10:17','1',NULL,NULL,NULL,NULL),(340,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','vikigm@gmail.com','gv','','vignesh','2017-08-14 00:00:00','female','2017-06-09 14:28:34','2017-10-25 09:35:00','L1','M5',NULL,1,1,1,NULL,8,'[{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"15\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"15\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-06-09 14:28:34','2017-07-09 14:28:34','1',0,'','',''),(341,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','bapu397@gmail.com','Bapu','','Lp','1990-11-29 00:00:00','male','2017-06-10 11:02:16','2017-12-05 14:08:42','L1','M6',NULL,1,1,1,NULL,6,'[{\"inHaleTime\":\"8\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"10\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"8\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"10\",\"exHaleTime\":\"7\"}]','0',NULL,NULL,NULL,NULL,'2017-06-10 11:02:16','2017-07-10 11:02:16','1',NULL,'150','55','BMI: 1.72'),(364,'d767906d92bd17418b60c85c05e335f1da74297a','beccasmith61@rocketmail.com','Rebecca ','','Smith ',NULL,NULL,'2017-09-23 18:54:00','2017-09-23 18:54:46','L1','M6',NULL,1,1,1,NULL,6,'[{\"inHaleTime\":\"3\",\"exHaleTime\":\"22\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"22\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"22\"}]','0',NULL,NULL,NULL,NULL,'2017-09-23 18:54:00','2017-10-23 18:54:00','1',NULL,'(null)','(null)','(null)'),(342,'40bd001563085fc35165329ea1ff5c5ecbdbbeef','testviki@gmail.com','vikij','','viki','1986-06-15 00:00:00','Male','2017-06-10 13:51:03','2017-06-10 13:52:15','L1','M5',NULL,1,1,1,NULL,8,'[{},{},{},{},{},{},{},{}]','0',NULL,NULL,NULL,NULL,'2017-06-10 13:51:03','2017-07-10 13:51:03','1',0,NULL,NULL,NULL),(343,'4a0f2905d0f03712ee901f307fef1291193971bc','papu397@gmail.com','Papu','','LP',NULL,'male','2017-07-06 20:16:38','2017-10-25 09:50:35','L1','M6',0,1,1,1,NULL,6,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"}]','0',NULL,NULL,NULL,NULL,'2017-07-06 20:16:38','2017-08-06 20:16:38','1',NULL,NULL,NULL,NULL),(365,'2117a23d088add70122547f1681e18b7cfd22c95','San.ian.skelton@gmail.com','Sam','','Skelton','1984-10-10 00:00:00','male','2017-10-25 17:29:26','2018-01-12 04:12:25','L1','M4',NULL,1,1,1,NULL,10,'[{\"inHaleTime\":\"60\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"60\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"}]','0',NULL,NULL,NULL,NULL,'2017-10-25 17:29:26','2017-11-25 17:29:26','1',NULL,'(null)72','(null)172','BMI: nan'),(344,'7110eda4d09e062aa5e4a390b0a572ac0d2c0220','vignesh@gmail.com','GV','','vignesh','1986-06-15 00:00:00','Male','2017-07-09 14:14:22','2017-07-09 14:14:22',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-07-09 14:14:22','2017-08-09 14:14:22',NULL,NULL,NULL,NULL,NULL),(346,'0cc035e4402996cb4fa0f6cfdf8c60ef958f1c01','DDD','dDS','','DDD','1986-06-15 00:00:00','Male','2017-07-23 13:09:44','2017-07-23 13:09:44',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-07-23 13:09:44','2017-08-23 13:09:44',NULL,NULL,NULL,NULL,NULL),(345,'40bd001563085fc35165329ea1ff5c5ecbdbbeef','vikigm222@gmail.com','viki','','gm','1986-06-15 00:00:00','Male','2017-07-19 17:42:37','2017-07-19 17:42:37',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-07-19 17:42:37','2017-08-19 17:42:37',NULL,NULL,NULL,NULL,NULL),(347,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','gvgayu@gmail.com','gvtest','','gv','1986-06-15 00:00:00','Male','2017-07-23 18:27:26','2017-07-23 18:27:26',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-07-23 18:27:26','2017-08-23 18:27:26',NULL,NULL,NULL,NULL,NULL),(349,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','bapu398@gmail.com','LP','','Sahu',NULL,NULL,'2017-07-24 09:08:23','2017-07-24 09:09:22','L1','M2',NULL,1,1,1,NULL,14,'[{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-07-24 09:08:23','2017-08-24 09:08:23','1',NULL,NULL,NULL,NULL),(351,'e9197ec57f7f5fef63e7459ba3e4d6515958dfb8','mgomathivignesh@gmail.com','Gomathivignesh Murugan','','','1994-05-22 00:00:00','Male','2017-08-20 05:08:16','2017-10-25 18:38:21','L2','M1',NULL,1,1,1,NULL,26,'[{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-08-20 05:08:16','2017-09-20 05:08:16','1',NULL,NULL,NULL,NULL),(352,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','viki@gmail.com','vignesh','','gn','1986-06-15 00:00:00','Male','2017-08-20 11:12:43','2017-08-20 11:12:43',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-08-20 11:12:43','2017-09-20 11:12:43',NULL,NULL,NULL,NULL,NULL),(353,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','raj82singvel@gmail.com','Singu','','S','1986-06-15 00:00:00','Male','2017-08-20 13:00:35','2017-10-25 20:15:52','L1','M5',NULL,1,1,1,NULL,8,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"}]','0',NULL,NULL,NULL,NULL,'2017-08-20 13:00:35','2017-09-20 13:00:35','1',NULL,NULL,NULL,NULL),(354,'e9197ec57f7f5fef63e7459ba3e4d6515958dfb8','dhanaraja001@gmail.com','Dhana Raj','','','1994-05-22 00:00:00','Male','2017-08-21 09:48:50','2017-08-21 09:48:50',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-08-21 09:48:50','2017-09-21 09:48:50',NULL,NULL,NULL,NULL,NULL),(355,'e9197ec57f7f5fef63e7459ba3e4d6515958dfb8','sasikumar.432@gmail.com','Sri Sasi Kumar','','','1994-05-22 00:00:00','Male','2017-08-21 10:08:20','2017-08-21 10:08:20',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-08-21 10:08:20','2017-09-21 10:08:20',NULL,NULL,NULL,NULL,NULL),(356,'e9197ec57f7f5fef63e7459ba3e4d6515958dfb8','mmahaakshaya@gmail.com','Maha Akshaya','','shumi','1997-02-22 00:00:00','Female','2017-08-21 13:35:29','2017-08-21 13:37:56',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-08-21 13:35:29','2017-09-21 13:35:29',NULL,NULL,'160','51','19.92'),(357,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','mgv@gmail.com','gv','','gv','1986-06-15 00:00:00','Male','2017-09-10 17:37:11','2017-09-10 17:37:11',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-09-10 17:37:11','2017-10-10 17:37:11',NULL,NULL,NULL,NULL,NULL),(358,'ca5b47bee80d47fdae2954565c55658b3684bb26','mgvh@gmail.com','gv','','gv','1986-06-15 00:00:00','Male','2017-09-10 23:12:13','2017-09-10 23:12:13',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-09-10 23:12:13','2017-10-10 23:12:13',NULL,NULL,'170','65','22.49'),(359,'ca5b47bee80d47fdae2954565c55658b3684bb26','gayathri@gmail.com','gv','','gv','1986-06-15 00:00:00','Male','2017-09-10 18:20:42','2017-09-10 18:20:42',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-09-10 18:20:42','2017-10-10 18:20:42',NULL,NULL,'170','65','22.49'),(360,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','bapu@gmail.com','Lp','','Lp',NULL,NULL,'2017-09-11 13:15:23','2017-09-11 13:15:23',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-09-11 13:15:23','2017-10-11 13:15:23',NULL,NULL,'(null)','(null)','(null)'),(361,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','xyz@gmail.com','Lp','','Lp',NULL,NULL,'2017-09-11 13:17:12','2017-09-11 13:20:27','L7','M1',NULL,1,1,1,NULL,16,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-09-11 13:17:12','2017-10-11 13:17:12','1',NULL,'(null)','(null)','(null)'),(362,'7c222fb2927d828af22f592134e8932480637c0d','nitinsenthil@gmail.com','Jey','','Jey','2011-09-12 00:00:00','Male','2017-09-11 16:29:49','2017-09-12 16:46:16','L1','M6',NULL,1,1,1,NULL,6,'[{\"inHaleTime\":\"4\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"3\"}]','0',NULL,NULL,NULL,NULL,'2017-09-11 16:29:49','2017-10-11 16:29:49','1',NULL,'(null)','(null)','(null)'),(363,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','bapu387@gmail.com','Bapu','','LP','2017-08-12 00:00:00','Male','2017-09-12 17:12:14','2017-09-12 18:01:42','L1','M3',NULL,1,1,1,NULL,12,'[{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-09-12 17:12:14','2017-10-12 17:12:14','1',NULL,'(null)','(null)','(null)'),(375,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','niviratna@yahoo.com','Nivi','','Nivi',NULL,NULL,'2017-12-22 02:55:25','2017-12-22 03:07:10','L1','M6',NULL,1,1,1,NULL,6,'[{\"inHaleTime\":\"4\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"8\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"5\",\"exHaleTime\":\"8\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"7\"}]','0',NULL,NULL,NULL,NULL,'2017-12-22 02:55:25','2018-01-22 02:55:25','1',NULL,NULL,NULL,NULL),(366,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','mgv1@gmail.com','gv','','murugan','1986-06-15 00:00:00','Male','2017-10-25 18:56:50','2017-10-25 19:04:13',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-10-25 18:56:50','2017-11-25 18:56:50',NULL,0,'170','65','22.49'),(367,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','test@gmail.com','rt','','er','1986-06-15 00:00:00','Male','2017-10-25 20:36:02','2017-10-25 20:36:02',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-10-25 20:36:02','2017-11-25 20:36:02',NULL,NULL,NULL,NULL,NULL),(368,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','mgv2@gmail.com','gv','','murugan','1986-06-15 00:00:00','Male','2017-10-26 02:08:50','2017-10-26 02:08:50',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-10-26 02:08:50','2017-11-26 02:08:50',NULL,NULL,'170','65','22.49'),(369,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','mgved@gmail.com','gv','','murugan','1986-06-15 00:00:00','Male','2017-10-26 05:45:58','2017-10-26 05:45:58',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2017-10-26 05:45:58','2017-11-26 05:45:58',NULL,NULL,'170','65','22.49'),(370,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','bapu39@gmail.com','LP','','S','2017-10-26 00:00:00','male','2017-10-26 11:09:22','2017-10-26 12:44:25','L7','M1',NULL,1,1,1,NULL,16,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2017-10-26 11:09:22','2017-11-26 11:09:22','1',NULL,'167','111','BMI: 18'),(371,'7c222fb2927d828af22f592134e8932480637c0d','nitinninja18@gmail.com','Jey','','Jey','1985-10-28 00:00:00','female','2017-10-27 17:39:32','2017-10-28 11:35:12','L1','M6',NULL,1,1,1,NULL,6,'[{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"6\"},{\"inHaleTime\":\"7\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"6\",\"exHaleTime\":\"7\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"}]','0',NULL,NULL,NULL,NULL,'2017-10-27 17:39:32','2017-11-27 17:39:32','1',NULL,'153','110','BMI: 21'),(372,'7c222fb2927d828af22f592134e8932480637c0d','niveditasenthil@gmail.com','Nivi','','Nivi','1985-11-18 00:00:00','male','2017-10-30 07:05:39','2017-11-13 11:56:01','L1','M5',NULL,1,1,1,NULL,8,'[{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"5\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"}]','0',NULL,NULL,NULL,NULL,'2017-10-30 07:05:39','2017-11-30 07:05:39','1',NULL,'152','110','BMI:'),(373,'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','drj@gmail.com','gv','','vignesh','1994-05-22 00:00:00','female','2017-11-09 10:24:53','2018-03-05 15:21:58','L3','M1',NULL,1,1,1,NULL,24,'[{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"}]','0',NULL,NULL,NULL,NULL,'2017-11-09 10:24:53','2017-12-09 10:24:53','1',NULL,'152','52','BMI: 22.51'),(374,'7110eda4d09e062aa5e4a390b0a572ac0d2c0220','gom@gmail.vom','Gv','','Mur',NULL,NULL,'2017-11-09 11:04:05','2017-11-09 11:04:56','L6','M1',NULL,1,1,1,NULL,18,'[{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"},{\"inHaleTime\":\"0\",\"exHaleTime\":\"0\"}]','0',NULL,NULL,NULL,NULL,'2017-11-09 11:04:05','2017-12-09 11:04:05','1',NULL,'170','65','BMI:'),(376,'1142b33e04e1bef9f8724b824c54b08899f572a7','nouranahmed.@yahoo.com','Nouran','','Ahmed',NULL,NULL,'2017-12-31 19:31:27','2017-12-31 19:38:50','L6','M1',NULL,1,1,1,NULL,18,'[{\"inHaleTime\":\"8\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"8\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"3\"}]','0',NULL,NULL,NULL,NULL,'2017-12-31 19:31:27','2018-01-31 19:31:27','1',NULL,'66.5','40','BMI:'),(377,'f5c8dfd201ed6ef5e06000463c2494a0ba7235e8','wifeejulie@gmail.com','Julie','','Skelton',NULL,NULL,'2018-01-26 03:37:27','2018-01-26 03:39:00','L1','M3',NULL,1,1,1,NULL,12,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"}]','0',NULL,NULL,NULL,NULL,'2018-01-26 03:37:27','2018-02-26 03:37:27','1',NULL,NULL,NULL,NULL),(378,'f25b22b14e8f35efa9b5fc67d7ad71390df6bdd3','raajkumarc@gmail.com','Raajkumar ','','C',NULL,NULL,'2018-01-28 06:25:37','2018-01-28 06:32:57','L1','M4',NULL,1,1,1,NULL,10,'[{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"4\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"}]','0',NULL,NULL,NULL,NULL,'2018-01-28 06:25:37','2018-02-28 06:25:37','1',NULL,NULL,NULL,NULL),(379,'2117a23d088add70122547f1681e18b7cfd22c95','sam.skelton@synaptics.com','Sam','','Skelton',NULL,NULL,'2018-02-09 02:16:02','2018-02-09 02:18:31','L1','M4',NULL,1,1,1,NULL,10,'[{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"4\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"},{\"inHaleTime\":\"3\",\"exHaleTime\":\"3\"}]','0',NULL,NULL,NULL,NULL,'2018-02-09 02:16:02','2018-03-09 02:16:02','1',NULL,NULL,NULL,NULL),(380,'d6b65d8826cc489133db50cc642a92249dbd01ce','codervishnu@gmail.com','Vishnu Kumar','','K',NULL,NULL,'2018-02-18 04:51:36','2018-02-18 04:53:11','L6','M1',NULL,1,1,1,NULL,18,'[{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"2\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2018-02-18 04:51:36','2018-03-18 04:51:36','1',NULL,NULL,NULL,NULL),(381,'d318f44739dced66793b1a603028133a76ae680e','fujidrive4@gmail.com','Ch','','Gp',NULL,NULL,'2018-03-03 03:48:21','2018-03-03 03:50:59','L6','M1',NULL,1,1,1,NULL,18,'[{\"inHaleTime\":\"43\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"6\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"43\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"2\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"6\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"},{\"inHaleTime\":\"1\",\"exHaleTime\":\"1\"}]','0',NULL,NULL,NULL,NULL,'2018-03-03 03:48:21','2018-04-03 03:48:21','1',NULL,NULL,NULL,NULL),(382,'2a21e57e11b548988855326be7e2a6c249a0452f','rahul.an431@gmail.com','Rahul','','Reddy ',NULL,NULL,'2018-04-14 07:56:37','2018-04-14 07:56:37',NULL,NULL,NULL,1,1,1,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,'2018-04-14 07:56:37','2018-05-14 07:56:37',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:27:01