-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: book
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `SPRING_SESSION`
--

DROP TABLE IF EXISTS `SPRING_SESSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` char(36) DEFAULT NULL,
  `SESSION_ID` char(36) DEFAULT NULL,
  `CREATION_TIME` bigint DEFAULT NULL,
  `LAST_ACCESS_TIME` bigint DEFAULT NULL,
  `MAX_INACTIVE_INTERVAL` int DEFAULT NULL,
  `EXPIRY_TIME` bigint DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPRING_SESSION`
--

LOCK TABLES `SPRING_SESSION` WRITE;
/*!40000 ALTER TABLE `SPRING_SESSION` DISABLE KEYS */;
INSERT INTO `SPRING_SESSION` VALUES ('b6cd00d8-0eac-48a0-bc35-8381612227c5','8191c3c3-35f8-4a3a-9bfe-92782238d98d',1665670374796,1665670380984,1800,1665672180984,NULL);
/*!40000 ALTER TABLE `SPRING_SESSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SPRING_SESSION_ATTRIBUTES`
--

DROP TABLE IF EXISTS `SPRING_SESSION_ATTRIBUTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` char(36) DEFAULT NULL,
  `ATTRIBUTE_NAME` varchar(200) DEFAULT NULL,
  `ATTRIBUTE_BYTES` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPRING_SESSION_ATTRIBUTES`
--

LOCK TABLES `SPRING_SESSION_ATTRIBUTES` WRITE;
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` DISABLE KEYS */;
INSERT INTO `SPRING_SESSION_ATTRIBUTES` VALUES ('147e0f3f-75db-4962-8560-663fb02e41ba','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('26a9e089-1be6-4ec7-8cdb-e0b0c724414f','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('e9adbed1-f185-4c25-98db-7b2b2bad0ba9','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('a2b2d28f-89d4-4fc9-adba-260f8f7fea5f','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('b20c939e-cf65-4153-9fb9-750633fd9d1c','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('2920b8bb-394c-4eaf-bb1d-f8d767dbed29','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('1c2fb030-00dc-42ba-81e2-de4d1b51dc15','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('1eb74805-fd69-48be-91b5-678507f36120','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('0f7176f8-4316-4c1c-9241-6075d67ee8e1','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('1ad30ec7-53ec-4bee-8305-3e3a342dba86','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('f786b8b2-d20b-457b-a428-9af62d74a4a5','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('1999de9c-7305-403e-9bc8-7d0dc7c2768f','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('a79ba6d2-109b-470a-b6dc-a2dbaefd4cab','userStatus',_binary '�\�\0sr\0book.entity.UserStatus�f\� Rr\Z\0[\0\nprivilegest\0[Lbook/entity/UserPrivilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.UserPrivilege;՟��X\'�\0\0xp\0\0\0sr\0book.entity.UserPrivilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('1d57b285-3c0c-4df1-be84-ad6bcdf8c0ea','userStatus',_binary '�\�\0sr\0book.entity.UserStatusNT�\�[\�AI\0[\0\nprivilegest\0[Lbook/entity/Privilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.Privilege;d����*\�\0\0xp\0\0\0sr\0book.entity.Privilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin'),('b6cd00d8-0eac-48a0-bc35-8381612227c5','userStatus',_binary '�\�\0sr\0book.entity.UserStatusNT�\�[\�AI\0[\0\nprivilegest\0[Lbook/entity/Privilege;L\0roleIdt\0Ljava/lang/Integer;L\0roleNamet\0Ljava/lang/String;L\0userIdq\0~\0L\0userNameq\0~\0xpur\0[Lbook.entity.Privilege;d����*\�\0\0xp\0\0\0sr\0book.entity.Privilege\0\0\0\0\0\0\0\0L\0privilegeIdq\0~\0L\0\rprivilegeNameq\0~\0xpsr\0java.lang.Integer⠤\���8\0I\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0t\0查看数据sq\0~\0sq\0~\0	\0\0\0t\0增删改数据q\0~\0t\0管理员（全部操作）q\0~\0t\0admin');
/*!40000 ALTER TABLE `SPRING_SESSION_ATTRIBUTES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `stock` int NOT NULL COMMENT '库存',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_detail` (
  `book_id` int NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `book_author` varchar(50) NOT NULL,
  `publisher` varchar(50) NOT NULL COMMENT '出版社',
  `time` varchar(10) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `introduction` text,
  PRIMARY KEY (`book_id`),
  CONSTRAINT `book_detail_book_null_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_detail`
--

LOCK TABLES `book_detail` WRITE;
/*!40000 ALTER TABLE `book_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_info`
--

DROP TABLE IF EXISTS `borrow_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow_info` (
  `user_id` int NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `book_id` int NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `borrow_time` mediumtext NOT NULL,
  `deadline` mediumtext NOT NULL,
  PRIMARY KEY (`book_id`,`user_id`),
  KEY `borrow_info_user_null_fk` (`user_id`),
  CONSTRAINT `borrow_info_book_null_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `borrow_info_user_null_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_info`
--

LOCK TABLES `borrow_info` WRITE;
/*!40000 ALTER TABLE `borrow_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilege` (
  `privilege_id` smallint unsigned DEFAULT NULL,
  `privilege_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'查看数据'),(2,'增删改数据');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` tinyint unsigned DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'管理员（全部操作）'),(2,'普通用户（仅查看）');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_privilege` (
  `id` int unsigned DEFAULT NULL,
  `role_id` tinyint unsigned DEFAULT NULL,
  `privilege_id` smallint unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
INSERT INTO `role_privilege` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$M9n/9O5qXuqtjup4jm3Oz.qj393pQ2eR/fS6/Amkf/MqbxgmjE9/K',NULL,NULL,NULL),(2,'bob','$2a$10$FRuiYpdeF.AY98Q0GVJuE.hnYWc/a0K7aJN1LGXDHc.0ewyUSc7I6',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_log` (
  `log_id` int unsigned DEFAULT NULL,
  `user_id` smallint unsigned DEFAULT NULL,
  `role_id` tinyint unsigned DEFAULT NULL,
  `action_time` datetime DEFAULT NULL,
  `action_type` tinyint unsigned DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
INSERT INTO `user_log` VALUES (1,1,1,'2022-09-03 19:34:23',6,'用户退出登录：admin','admin','管理员'),(2,1,1,'2022-09-03 19:34:34',5,'用户登录：admin','admin','管理员'),(3,1,1,'2022-09-03 19:37:18',6,'用户退出登录：admin','admin','管理员'),(4,2,2,'2022-09-03 19:37:24',5,'用户登录：bob','bob','普通用户'),(5,2,2,'2022-09-03 19:38:43',6,'用户退出登录：bob','bob','普通用户'),(7,1,1,'2022-09-03 19:46:42',6,'用户退出登录：admin','admin','管理员'),(8,2,2,'2022-09-03 19:46:45',5,'用户登录：bob','bob','普通用户'),(9,2,2,'2022-09-03 19:46:59',6,'用户退出登录：bob','bob','普通用户'),(10,1,1,'2022-09-03 19:47:11',5,'用户登录：admin','admin','管理员'),(11,2,2,'2022-09-04 13:37:44',5,'用户登录：bob','bob','普通用户'),(12,2,2,'2022-09-04 13:38:38',6,'用户退出登录：bob','bob','普通用户'),(13,1,1,'2022-09-04 13:38:45',5,'用户登录：admin','admin','管理员'),(14,1,1,'2022-09-04 14:14:40',5,'用户登录：admin','admin','管理员'),(15,2,2,'2022-09-04 15:05:28',5,'用户登录：bob','bob','普通用户'),(16,2,2,'2022-09-04 15:05:41',6,'用户退出登录：bob','bob','普通用户'),(17,2,2,'2022-09-04 15:06:40',5,'用户登录：bob','bob','普通用户'),(336,2,2,'2022-09-05 16:16:50',5,'用户登录：bob','bob','普通用户'),(337,2,2,'2022-09-05 16:25:01',5,'用户登录：bob','bob','普通用户'),(338,2,2,'2022-09-05 16:31:39',5,'用户登录：bob','bob','普通用户'),(339,1,1,'2022-10-12 14:51:28',5,'用户登录：admin','admin','管理员'),(340,1,1,'2022-10-12 14:51:29',5,'用户登录：admin','admin','管理员'),(341,1,1,'2022-10-12 14:51:34',5,'用户登录：admin','admin','管理员'),(342,1,1,'2022-10-12 14:52:59',5,'用户登录：admin','admin','管理员'),(343,1,1,'2022-10-12 14:53:39',5,'用户登录：admin','admin','管理员'),(344,1,1,'2022-10-12 14:54:30',5,'用户登录：admin','admin','管理员'),(345,1,1,'2022-10-12 15:02:31',5,'用户登录：admin','admin','管理员'),(346,1,1,'2022-10-12 15:04:55',5,'用户登录：admin','admin','管理员'),(347,1,1,'2022-10-12 15:07:49',5,'用户登录：admin','admin','管理员'),(348,1,1,'2022-10-12 15:09:40',5,'用户登录：admin','admin','管理员'),(349,1,1,'2022-10-12 15:20:35',5,'用户登录：admin','admin','管理员'),(350,1,1,'2022-10-12 15:25:24',5,'用户登录：admin','admin','管理员'),(351,1,1,'2022-10-12 15:49:29',5,'用户登录：admin','admin','管理员'),(352,1,1,'2022-10-12 16:12:05',5,'用户登录：admin','admin','管理员'),(353,1,1,'2022-10-12 16:13:07',5,'用户登录：admin','admin','管理员'),(354,1,1,'2022-10-12 16:14:13',5,'用户登录：admin','admin','管理员'),(355,1,1,'2022-10-12 16:19:44',5,'用户登录：admin','admin','管理员'),(356,1,1,'2022-10-12 16:20:51',5,'用户登录：admin','admin','管理员'),(357,1,1,'2022-10-12 16:23:59',5,'用户登录：admin','admin','管理员'),(358,1,1,'2022-10-12 16:27:31',5,'用户登录：admin','admin','管理员'),(359,1,1,'2022-10-12 16:30:16',5,'用户登录：admin','admin','管理员'),(360,1,1,'2022-10-12 17:42:30',5,'用户登录：admin','admin','管理员'),(361,1,1,'2022-10-12 17:46:13',5,'用户登录：admin','admin','管理员'),(362,1,1,'2022-10-12 17:47:51',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 17:58:15',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:00:13',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:05:59',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:28:19',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:39:13',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:39:23',6,'用户退出登录：admin','admin','管理员'),(NULL,2,2,'2022-10-12 18:39:26',5,'用户登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 18:45:58',6,'用户退出登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 18:46:00',5,'用户登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 18:46:55',6,'用户退出登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 18:46:56',5,'用户登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 18:53:05',6,'用户退出登录：bob','bob','普通用户'),(NULL,1,1,'2022-10-12 18:53:08',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 18:53:24',6,'用户退出登录：admin','admin','管理员'),(NULL,2,2,'2022-10-12 18:53:26',5,'用户登录：bob','bob','普通用户'),(NULL,2,2,'2022-10-12 19:17:27',6,'用户退出登录：bob','bob','普通用户'),(NULL,1,1,'2022-10-12 19:17:29',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 19:50:05',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 20:44:40',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 20:46:54',6,'用户退出登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 20:46:55',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 20:48:35',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 23:13:51',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-12 23:35:11',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-13 16:40:16',5,'用户登录：admin','admin','管理员'),(NULL,1,1,'2022-10-13 22:12:55',5,'用户登录：admin','admin','管理员');
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int unsigned DEFAULT NULL,
  `user_id` smallint unsigned DEFAULT NULL,
  `role_id` tinyint unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-13 14:19:46
