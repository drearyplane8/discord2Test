-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: discord2db
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `MessageID` int unsigned NOT NULL AUTO_INCREMENT,
  `Author` varchar(64) NOT NULL,
  `Content` varchar(2048) NOT NULL,
  `TimeSent` datetime NOT NULL,
  `VoteSum` int NOT NULL,
  `FileExtension` varchar(15) DEFAULT NULL,
  `FileData` longblob,
  PRIMARY KEY (`MessageID`),
  UNIQUE KEY `MessageID_UNIQUE` (`MessageID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'charlie','nya','2021-11-01 11:22:56',0,'null',_binary 'NULL'),(2,'charlie','pwarglerf','2021-11-02 16:23:19',0,'null',_binary 'NULL'),(3,'charlie','fefe;kjhaefeafeafafeaf','2021-11-02 16:23:25',0,'null',_binary 'NULL'),(4,'charlie','stinky','2021-11-02 16:23:27',0,'null',_binary 'NULL'),(5,'charlie','pooop','2021-11-02 16:23:29',0,'null',_binary 'NULL'),(6,'real robert','uwu','2021-11-02 16:23:52',0,'null',_binary 'NULL'),(7,'real robert','i like anime','2021-11-02 16:23:58',0,'null',_binary 'NULL'),(8,'real robert','and vr ','2021-11-02 16:24:06',0,'null',_binary 'NULL'),(9,'real robert','owo','2021-11-02 16:24:09',0,'null',_binary 'NULL'),(10,'charlie','qui','2021-11-02 16:31:58',0,'null',_binary 'NULL'),(11,'charlie','nya','2021-11-02 16:41:15',0,'null',_binary 'NULL'),(12,'root','sudo your mum','2021-11-02 16:43:30',0,NULL,NULL),(13,'root','rm rf *','2021-11-02 16:43:30',0,NULL,NULL),(14,'charlie','hi','2021-11-02 16:45:36',0,'null',_binary 'NULL'),(15,'charlie','hello world','2021-11-02 16:55:47',0,'null',_binary 'NULL'),(16,'world','hi','2021-11-02 16:55:52',0,'null',_binary 'NULL'),(17,'charlie','heya#','2021-11-02 16:55:56',0,'null',_binary 'NULL'),(18,'placeholder','owo','2021-11-08 15:20:27',0,'null',_binary 'null'),(19,'placeholder','Send a message','2021-11-08 15:56:49',0,'null',_binary 'null'),(20,'placeholder','Send a message','2021-11-08 15:59:21',0,'null',_binary 'null'),(21,'placeholder','Send a message','2021-11-08 15:59:21',0,'null',_binary 'null'),(22,'placeholder','Send a message','2021-11-08 15:59:21',0,'null',_binary 'null'),(23,'placeholder','Send a message','2021-11-09 16:39:55',0,'null',_binary 'null'),(24,'placeholder','hello','2021-11-09 16:48:37',0,'null',_binary 'null'),(25,'null','uwu','2021-11-10 15:53:06',0,'null',_binary 'null'),(26,'null','ello','2021-11-10 15:54:16',0,'null',_binary 'null'),(27,'null','p','2021-11-10 15:54:50',0,'null',_binary 'null'),(28,'null','a message','2021-11-10 15:57:19',0,'null',_binary 'null'),(29,'null','Send a message','2021-11-10 16:02:39',0,'null',_binary 'null'),(30,'null','Send a message','2021-11-10 16:06:06',0,'null',_binary 'null'),(31,'null','Send a message','2021-11-11 14:15:55',0,'null',_binary 'null'),(32,'charlie','├Âw├Â','2021-11-11 14:22:55',0,'null',_binary 'null'),(33,'charlie','├Âw├Â','2021-11-11 14:22:57',0,'null',_binary 'null'),(34,'peepee','pwarg','2021-11-11 14:30:08',0,'null',_binary 'null'),(35,'virgin CLI','nobody knows my arguments','2021-11-11 14:54:01',-1,'null',_binary 'NULL'),(36,'chad GUI','i dont need arguments i have buttons','2021-11-11 14:54:24',1,'null',_binary 'null'),(37,'virgin CLI','i can use a shell script to be automateable','2021-11-11 14:54:36',-1,'null',_binary 'NULL'),(38,'waw','lmao noone cares','2021-11-11 14:58:47',0,'null',_binary 'null'),(39,'Username','Send a message','2021-11-11 15:43:35',0,'null',_binary 'null'),(40,'baaa','baaaaaa','2021-11-12 18:12:07',0,'null',_binary 'null'),(41,'charlie','helo','2021-11-12 18:13:52',0,'null',_binary 'null'),(42,'charlie','no','2021-11-12 18:17:35',-2,'null',_binary 'NULL');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 19:28:06
