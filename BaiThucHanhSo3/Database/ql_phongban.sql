-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: ql_phongban
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `chuc_vu`
--

DROP TABLE IF EXISTS `chuc_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuc_vu` (
  `ma_chuc_vu` smallint(4) NOT NULL AUTO_INCREMENT,
  `ten_chuc_vu` varchar(100) NOT NULL,
  PRIMARY KEY (`ma_chuc_vu`),
  UNIQUE KEY `ma_chuc_vu` (`ma_chuc_vu`),
  UNIQUE KEY `ten_chuc_vu` (`ten_chuc_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuc_vu`
--

LOCK TABLES `chuc_vu` WRITE;
/*!40000 ALTER TABLE `chuc_vu` DISABLE KEYS */;
INSERT INTO `chuc_vu` VALUES (3,'Nhân viên'),(2,'Phó phòng'),(0,'Quản Trị Viên'),(1,'Trưởng phòng');
/*!40000 ALTER TABLE `chuc_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(15) NOT NULL,
  `ma_chuc_vu` smallint(4) NOT NULL,
  `ma_phong_ban` smallint(6) NOT NULL,
  `mat_khau` varchar(15) NOT NULL,
  `ten_nhan_vien` varchar(100) NOT NULL,
  `so_dien_thoai` varchar(15) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_nhan_vien`),
  UNIQUE KEY `ma_nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES ('admin',0,0,'admin','Quản Trị Viên','01234567890','Đà Nẵng'),('nthia',1,15,'123456','Nguyễn Thị A','1234567890','Quảng Trị'),('nthib',2,15,'123456','Nguyễn Thị B','1234567890','Đà Nẵng'),('nthic',3,15,'123456','Nguyễn Thị C','1234567890','Đà Nẵng'),('nvana',1,14,'123456','Nguyễn Văn A','1234567890','Đà Nẵng'),('nvanb',2,14,'123456','Nguyễn Văn B','1234567890','Quảng Nam'),('nvanc',3,14,'123456','Nguyễn Văn C','123456789','Huế'),('thuua',1,16,'123456','Trần Hữu A','123456789','Quảng Bình'),('thuub',2,16,'123456','Trần Hữu B','123456789','Huế'),('thuuc',3,16,'123456','Trần Hữu C','1234567890','Quảng Nam');
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong_ban`
--

DROP TABLE IF EXISTS `phong_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phong_ban` (
  `ma_phong_ban` smallint(6) NOT NULL AUTO_INCREMENT,
  `ten_phong_ban` varchar(255) NOT NULL,
  `ngay_tao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ma_phong_ban`),
  UNIQUE KEY `ten_phong_ban` (`ten_phong_ban`),
  UNIQUE KEY `ma_phong_ban` (`ma_phong_ban`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong_ban`
--

LOCK TABLES `phong_ban` WRITE;
/*!40000 ALTER TABLE `phong_ban` DISABLE KEYS */;
INSERT INTO `phong_ban` VALUES (14,'Hành Chính','2016-05-08 12:47:26'),(15,'Tài Chính','2016-05-08 12:47:32'),(16,'Đào Tạo','2016-05-08 12:47:37');
/*!40000 ALTER TABLE `phong_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `user_pass` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@gmail.com','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-01  4:42:49
