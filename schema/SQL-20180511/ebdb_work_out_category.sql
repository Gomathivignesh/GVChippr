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
-- Table structure for table `work_out_category`
--

DROP TABLE IF EXISTS `work_out_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_out_category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastUpdated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_out_category`
--

LOCK TABLES `work_out_category` WRITE;
/*!40000 ALTER TABLE `work_out_category` DISABLE KEYS */;
INSERT INTO `work_out_category` VALUES (1,'CARDIO TRAINING',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(2,'KICKBOXING CARDIO TRAINING',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(3,'STRENGTH TRAINING',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(4,'FIT YOGA (no equipment)',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(5,'STRENGTHENING EXERCISES(no equipment)',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(6,'YOGA STRETCH',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(7,'CHIPPR ENERGY STRETCH',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(8,'CHIPPR OFFICE',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(9,'CHAIR YOGA',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(10,'HIIT',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(11,'HIIT - NO EQUIPMENT',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(12,'TABATA',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(13,'HICT',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(14,'MB',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(15,'GR',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(16,'Flower Visualization - Allow the flower to become a metaphor for your strength & beauty  ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(17,' Sunrise on the Beach - Imagine that you are near the ocean just before sunrise',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(18,'Peaceful Meadow - Rest and luxuriate in a beautiful meadow',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(19,'Warm autogenic relaxation - Relax in the feelings of calm and warmth',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(20,'Floating Feather - imagine yourself light and airy as a feather',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(21,'Boat Journey - imagine you’re in a small boat, drifting smoothly',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(22,'Ocean Escape - Imagine relaxing on a beautiful beach',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(23,'The Forest Speaks - Listen to the soothing sounds of birds chirping ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(24,'Forest Walk - Imagine yourself walking on a path through a forest',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(25,'The Healing Moon - Imagine sitting on the lakeside at dusk',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(26,'Country Walk - Imagine walking near a trickling stream',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(27,'The Tropical Beach - Recharge in a beautiful palm fringed beach',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(28,'Floating on a Cloud - Imagine floating on a soft fluffy white cloud',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(29,'Golden Light Visualization - Visualize a golden light filling and suffusing you',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(30,'Desirous ~ Envious ~ Jealous ~ Threatened',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(31,'Afraid ~ Fearful ~ Jumpy ~ Nervous ~ Shaky  ~ Unsettled  ~ Worried',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(32,'Grief-stricken ~ Heartbroken ~ Hopeless ~ Inconsolable ~ Morose',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(33,'Ashamed ~ Chagrined ~ Contrite ~ Culpable ~ Embarrassed ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(34,'Guilt-ridden ~ Guilt-stricken ~ Humiliated ~ Mortified -  Self-condemning',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(35,'Anxious ~ Disquieted ~ Doubtful ~ Edgy ~ Fidgety',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(36,'Confused ~ Curious ~ Disconcerted ~ Disoriented ~ Apprehensive',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(37,' Depressed ~ Despondent - Downtrodden ~ Drained ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(38,'Desirous ~ Envious ~ Jealous ~ Threatened',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(39,'Ouch, My Neck Hurts!',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(40,'Soothe Heel Pain',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(41,'Breast Cancer Prevention and Recovery',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(42,'Relieve Hand & Wrist Pain',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(43,'Sciatica Pain Relief',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(44,'PCOS Solutions',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(45,'Relieve Shoulder Pain ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(46,'Ankle Pain Relief',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(47,'Ouch, My Lower Back!',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(48,'Relax Deeply',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(49,'Beat Cold-and-Flu Season',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(50,'Voice Chanting',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(51,'Brief Muscle Relaxation ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(52,'Short Relaxation   ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(53,'Instant Relaxation',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(54,'Blissful Deep Relaxation ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(55,'Reverse Relaxation',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16'),(56,'Deep Relaxation ',NULL,'2016-08-03 22:59:16','2016-08-03 22:59:16');
/*!40000 ALTER TABLE `work_out_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 12:26:38
