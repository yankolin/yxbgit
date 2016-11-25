-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: ESM_SNMP
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

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
-- Table structure for table `ESM_GlobalStatus_d`
--

DROP TABLE IF EXISTS `ESM_GlobalStatus_d`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESM_GlobalStatus_d` (
  `GlobalId` int(11) NOT NULL AUTO_INCREMENT,
  `AverageCPURate` float NOT NULL,
  `AverageMemoryRate` float NOT NULL,
  `AverageStorRate` float NOT NULL,
  `AverageUpFlow` float NOT NULL,
  `AverageDownFlow` float NOT NULL,
  `TotalServiceNum` int(11) NOT NULL,
  `TotalNetDeviceNum` int(11) NOT NULL,
  `TotalSwitchDeviceNum` int(11) NOT NULL,
  `TotalNormalDeviceNum` int(11) NOT NULL,
  `TotalPrewarningDeviceNum` int(11) NOT NULL,
  `NormalServiceNum` int(11) NOT NULL,
  `NormalNetDeviceNum` int(11) NOT NULL,
  `NormalSwitchDeviceNum` int(11) NOT NULL,
  `PrewarningServiceNum` int(11) NOT NULL,
  `PrewarningNetDeviceNum` int(11) NOT NULL,
  `PrewarningSwitchDeviceNum` int(11) NOT NULL,
  PRIMARY KEY (`GlobalId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESM_GlobalStatus_d`
--

LOCK TABLES `ESM_GlobalStatus_d` WRITE;
/*!40000 ALTER TABLE `ESM_GlobalStatus_d` DISABLE KEYS */;
INSERT INTO `ESM_GlobalStatus_d` VALUES (1,56,45,56,3550,365,123,26,12,135,26,100,23,10,23,3,2);
/*!40000 ALTER TABLE `ESM_GlobalStatus_d` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-11 18:12:41
