-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `custom`
--

DROP TABLE IF EXISTS `custom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom` (
  `custom_name` varchar(10) DEFAULT NULL,
  `total_purchase` decimal(10,2) DEFAULT NULL,
  `custom_idx` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`custom_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom`
--

LOCK TABLES `custom` WRITE;
/*!40000 ALTER TABLE `custom` DISABLE KEYS */;
INSERT INTO `custom` VALUES ('A',150.00,1),('B',75.00,2),('C',300.00,3),('D',50.00,4),('E',200.00,5);
/*!40000 ALTER TABLE `custom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `joined_at` date NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Kim','kim@example.com','Seoul','2025-07-01'),(2,'Lee','lee@example.com','Busan_si','2025-07-10'),(3,'Park','park@example.com','Seoul','2025-08-01'),(4,'Choi','choi@example.com','Incheon','2025-08-05'),(5,'Yoon','test.@test.com',NULL,'2025-08-22');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `department_idx` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) DEFAULT NULL,
  `manager_employee_idx` int DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`department_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'인사',1,'서울'),(2,'영업',2,'부산'),(3,'구매',3,'서울'),(4,'개발',NULL,'속초');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_idx` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) DEFAULT NULL,
  `SALARY` decimal(10,2) DEFAULT NULL,
  `DEPARTMENT_IDX` int DEFAULT NULL,
  `MANAGER_IDX` int DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  PRIMARY KEY (`employee_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'유재석',9000.00,1,NULL,'2025-01-01'),(2,'박명수',8500.00,2,1,'2025-01-01'),(3,'노홍철',7000.00,3,1,'2025-01-01'),(6,'정준하',7500.00,2,2,'2025-09-01'),(7,'하하',8000.00,3,2,'2025-09-01'),(8,'홍길동',5000.00,1,4,'2025-09-01'),(9,'이순신',10000.00,4,5,'2025-09-01');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `qty` int NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`order_item_id`),
  UNIQUE KEY `order_item_id` (`order_item_id`),
  CONSTRAINT `order_items_chk_1` CHECK ((`qty` > 0)),
  CONSTRAINT `order_items_chk_2` CHECK ((`unit_price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,1,1,1,45000.00),(2,1,2,2,24000.00),(3,1,4,1,9000.00),(4,2,3,1,290000.00),(5,3,2,1,25000.00),(6,3,6,5,1000.00),(7,4,1,1,45000.00),(8,4,5,3,2800.00);
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `ordered_at` timestamp NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`),
  CONSTRAINT `orders_chk_1` CHECK ((`status` in (_utf8mb4'PAID',_utf8mb4'CANCELLED',_utf8mb4'SHIPPED')))
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2025-08-10 01:00:00','PAID'),(2,1,'2025-08-11 00:30:00','CANCELLED'),(3,2,'2025-08-12 05:00:00','SHIPPED'),(4,3,'2025-08-12 09:20:00','PAID');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id` (`product_id`),
  CONSTRAINT `products_chk_1` CHECK ((`price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Keyboard','Electronics',45000.00),(2,'Mouse','Electronics',25000.00),(3,'Monitor 27\"','Electronics',290000.00),(4,'Mug','Lifestyle',9000.00),(5,'Notebook','Stationery',3000.00),(6,'Pen','Stationery',1000.00),(7,'Apple','fruit',5000.00),(8,'Apple','fruit',5000.00),(9,'Apple','fruit',5000.00),(10,'Orange','fruit',8000.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_rates`
--

DROP TABLE IF EXISTS `shipping_rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_rates` (
  `rate_idx` int NOT NULL AUTO_INCREMENT,
  `min` decimal(10,2) DEFAULT NULL,
  `max` decimal(10,2) DEFAULT NULL,
  `fee` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`rate_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_rates`
--

LOCK TABLES `shipping_rates` WRITE;
/*!40000 ALTER TABLE `shipping_rates` DISABLE KEYS */;
INSERT INTO `shipping_rates` VALUES (1,0.00,100.00,10.00),(2,100.00,200.00,5.00),(3,200.00,500.00,0.00);
/*!40000 ALTER TABLE `shipping_rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_idx` int NOT NULL AUTO_INCREMENT,
  `student_name` varchar(45) DEFAULT NULL,
  `student_email` varchar(45) DEFAULT NULL,
  `join_dt` date DEFAULT NULL,
  PRIMARY KEY (`student_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='CREATE TABLE `test`.`students` (\n  `student_idx` INT NOT NULL AUTO_INCREMENT,\n  `student_name` VARCHAR(45) NULL,\n  `student_email` VARCHAR(45) NULL,\n  `join_dt` DATE NULL,\n  PRIMARY KEY (`student_idx`));\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'홍길동','TEST@TEST.COM','2025-08-19'),(2,'김영희','ㄹㄹㄹㄹ','2025-01-01');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vip`
--

DROP TABLE IF EXISTS `vip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vip` (
  `VIP_IDX` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`VIP_IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vip`
--

LOCK TABLES `vip` WRITE;
/*!40000 ALTER TABLE `vip` DISABLE KEYS */;
INSERT INTO `vip` VALUES (1,'A'),(2,'B'),(3,'C');
/*!40000 ALTER TABLE `vip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-25 11:26:08
