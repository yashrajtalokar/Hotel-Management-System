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
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `SrNo` int(11) NOT NULL,
  `RoomNo` varchar(5) DEFAULT NULL,
  `RoomType` varchar(10) DEFAULT NULL,
  `BedType` varchar(10) DEFAULT NULL,
  `Cost` varchar(15) DEFAULT NULL,
  `Available` varchar(5) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `MobileNo` varchar(12) DEFAULT NULL,
  `Address` varchar(60) DEFAULT NULL,
  `CheckIn` date DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `IdProof` varchar(20) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  `State` varchar(25) DEFAULT NULL,
  `Country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SrNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'101','NON-AC','Single','Rs.700','YES','Krishna Verma',17,'8329342791','Sainagar	','2020-03-11','MALE','Aadhar Card','Amravati','Maharashtra','India'),(2,'102','NON-AC','Single','Rs.700','YES','ww',2,'1212m','ww','2020-03-12','MALE','Voter ID','dnd','md','ms'),(5,'104','NON-AC','Single','Rs.700','YES','1',1,'1','1','2020-03-01','MALE','Aadhar Card','11','11','11'),(6,'106','NON-AC','Single','Rs.700','YES','affffsa',1,'2323','wwmmw','2020-03-20','MALE','Passport','sds','sdee','ewe'),(7,'104','NON-AC','Single','Rs.700','YES','q',1,'1','1	','2020-03-20','FEMALE','Aadhar Card','w','w','2'),(10,'104','NON-AC','Single','Rs.700','YES','ss',1,'232','sss	','2020-03-06','FEMALE','Passport','dd','rr','rr'),(11,'104','NON-AC','Double','Rs.1000','YES','kdfkdndjdndkdkd',12,'38383838','djdjdnknk	','2020-03-26','MALE','Pan Card','ddd','SNnSJ','wdjjd'),(12,'104','NON-AC','Double','Rs.1000','YES','whw',2,'2','dnd','2020-03-21','MALE','Aadhar Card','sn','d','e'),(14,'104','NON-AC','Double','Rs.1000','YES','snsnss',1,'1','Smsks	','2020-03-13','MALE','Ration Card','Aam','ww','owo'),(20,'104','AC','Single','Rs.1200','YES','smjs',232,'2232','ccc','2020-03-13','FEMALE','Aadhar Card','Agra','UP','Hindustan'),(26,'104','AC','Double','Rs.1700','YES','ddd',2,'22','dnjd','2020-03-13','FEMALE','Aadhar Card','ccc','www','cccc');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-13  0:31:42
