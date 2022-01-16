CREATE DATABASE  IF NOT EXISTS `practice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `practice`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: practice
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `roomlist`
--

DROP TABLE IF EXISTS `roomlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomlist` (
  `SrNo` int(11) NOT NULL,
  `RoomNo` varchar(10) DEFAULT NULL,
  `RoomType` varchar(20) DEFAULT NULL,
  `BedType` varchar(20) DEFAULT NULL,
  `RoomCost` varchar(20) DEFAULT NULL,
  `Available` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`SrNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomlist`
--

LOCK TABLES `roomlist` WRITE;
/*!40000 ALTER TABLE `roomlist` DISABLE KEYS */;
INSERT INTO `roomlist` VALUES (1,'101','NON-AC','Single','Rs.700','YES'),(2,'102','NON-AC','Single','Rs.700','YES'),(3,'103','NON-AC','Single','Rs.700','YES'),(4,'104','NON-AC','Single','Rs.700','YES'),(5,'105','NON-AC','Single','Rs.700','YES'),(6,'106','NON-AC','Single','Rs.700','YES'),(7,'107','NON-AC','Single','Rs.700','YES'),(8,'108','NON-AC','Single','Rs.700','YES'),(9,'109','NON-AC','Single','Rs.700','YES'),(10,'110','NON-AC','Single','Rs.700','YES'),(11,'111','NON-AC','Double','Rs.1000','YES'),(12,'112','NON-AC','Double','Rs.1000','YES'),(13,'113','NON-AC','Double','Rs.1000','YES'),(14,'114','NON-AC','Double','Rs.1000','YES'),(15,'115','NON-AC','Double','Rs.1000','YES'),(16,'116','AC','Single','Rs.1200','YES'),(17,'117','AC','Single','Rs.1200','YES'),(18,'118','AC','Single','Rs.1200','YES'),(19,'119','AC','Single','Rs.1200','YES'),(20,'120','AC','Single','Rs.1200','YES'),(21,'121','AC','Single','Rs.1200','YES'),(22,'122','AC','Double','Rs.1700','YES'),(23,'123','AC','Double','Rs.1700','YES'),(24,'124','AC','Double','Rs.1700','YES'),(25,'125','AC','Double','Rs.1700','YES'),(26,'126','AC','Double','Rs.1700','YES');
/*!40000 ALTER TABLE `roomlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-13  0:31:41
