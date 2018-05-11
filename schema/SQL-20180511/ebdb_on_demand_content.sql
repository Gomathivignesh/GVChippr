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
-- Table structure for table `on_demand_content`
--

DROP TABLE IF EXISTS `on_demand_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `on_demand_content` (
  `id` int(11) NOT NULL,
  `screen_name` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `on_demand_content`
--

LOCK TABLES `on_demand_content` WRITE;
/*!40000 ALTER TABLE `on_demand_content` DISABLE KEYS */;
INSERT INTO `on_demand_content` VALUES (3,'6 Ways To Safely Increase Flexibility','6 Ways To Safely Increase Flexibility',NULL),(4,'What\'s Your Dream?','What\'s Your Dream?',NULL),(5,'Here are the best stretches for every body part','Here are the best stretches for every body part',NULL),(6,'Equipment','How Will You Be Training?',NULL),(7,'strengthning','Bodyweight Workouts That Require No Equipment!',NULL),(8,'Zone','Here\'s Your Zone, Based On Your Conscious Breath Score',NULL),(9,'Choose Your Stretch Intensity','Choose Your Workout Intensity',NULL),(10,'Pick Your Favorite Interval Training','Pick Your Favorite Interval Training',NULL),(11,'Recovery','2 Must-Try Yoga Tools to Speed Recovery',NULL),(12,'Chippr Therapy','Find Healing With Yoga Therapy',NULL),(13,'Chippr Restore & Renew','Experience The Art Of Slowing Down!',NULL),(14,'Here\'s your zone','2 Ways To Practice Mindfulness',NULL),(15,'Relaxation Techniques to Get You In The Zone ','Relaxation Techniques to Get You In The Zone ',NULL),(16,'Guided Imagery','Allow the music and nature sounds to help you unwind ',NULL),(17,'Feel Good Positive Thinking','What\'s Your Emotion Right Now?',NULL),(18,'Flexibility type','Choose one of the options below to get started',NULL),(20,'High Level Fitness Leve','Choose Your Workout Intensity','Choose Your Stretch Intensity');
/*!40000 ALTER TABLE `on_demand_content` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:25:26
