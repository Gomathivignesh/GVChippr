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
-- Table structure for table `plan_cat`
--

DROP TABLE IF EXISTS `plan_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_cat` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastUpdated` datetime DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_cat`
--

LOCK TABLES `plan_cat` WRITE;
/*!40000 ALTER TABLE `plan_cat` DISABLE KEYS */;
INSERT INTO `plan_cat` VALUES (1,'CHIPPR MAIN CATEGORIES','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(2,'FITNESS','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(3,'FLEXIBILITY TYPES','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(4,'SCULPT YOUR BEST BODY_ST','2016-08-03 23:04:08','2016-08-03 23:04:08','Sculpt your best body','So...What\'s Your Dream?'),(5,'SCULPT YOUR BEST BODY_FT','2016-08-03 23:04:08','2016-08-03 23:04:08','Sculpt your best body','So...What\'s Your Dream?'),(6,'Equipment','2016-08-03 23:04:08','2016-08-03 23:04:08','Maximize Your Exercise Routine!','Here are 6 simple tools to get you started.'),(7,'STRENGTHENING TYPES(no equipment)','2016-08-03 23:04:08','2016-08-03 23:04:08','Bodyweight workouts that require no equipment and can be done anywhere!','Bodyweight workouts that require no equipment and can be done anywhere!'),(8,'ZONE','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(9,'Fitness Level','2016-08-03 23:04:08','2016-08-03 23:04:08','What is your current fitness level?','What is Your Level Of Intensity?'),(10,'Advanced Level','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(11,'RECOVERY','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(12,'chippr therapy','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(13,'chippr restore & renew','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(14,'Mindfulness','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(15,'GUIDED RELAXATION','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(16,'GUIDED IMAGERY','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(17,'FEEL GOOD +VE THINKING','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(18,'Choose one of the options below to get started?','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(19,'Flexibility Warm Down','2016-08-03 23:04:08','2016-08-03 23:04:08',NULL,NULL),(20,'High Level Fitness','2016-08-03 23:04:08','2016-08-03 23:04:08','Choose Your Stretch Intensity','Choose Your Workout Intensity');
/*!40000 ALTER TABLE `plan_cat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:24:08
