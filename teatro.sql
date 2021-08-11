CREATE DATABASE  IF NOT EXISTS `teatro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `teatro`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: teatro
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID` bigint NOT NULL,
  `DOCUMENTO` varchar(20) DEFAULT NULL,
  `ENDERECO` varchar(127) DEFAULT NULL,
  `IDADE` int DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'15151','AVENIDA x',18,'MARCOS'),(2,'1111','AVENIDA y',20,'ANDRE'),(501,'232323','aaaaa',232,'aaaaa'),(601,'32423','fsdfsd',23,'fsdf'),(603,'23232','dfsfsd',32,'sdfsdfsd'),(651,'324324','sdfdsf',23,'dfsdf'),(701,'2323','sdfsdf',34,'dfsdf'),(751,'32423','sdfs',34,'adsdf');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `ID` bigint NOT NULL,
  `DATAEVENTO` datetime DEFAULT NULL,
  `DESCRICAO` varchar(40) DEFAULT NULL,
  `EHTEATRO` tinyint(1) DEFAULT '0',
  `MAXPESSOAS` int DEFAULT NULL,
  `VALORDALIMPEZA` double DEFAULT NULL,
  `VALORDALUZ` double DEFAULT NULL,
  `VALORINGRESSO` double DEFAULT NULL,
  `SALAO_ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_evento_SALAO_ID` (`SALAO_ID`),
  CONSTRAINT `FK_evento_SALAO_ID` FOREIGN KEY (`SALAO_ID`) REFERENCES `salao` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (4,'2021-10-10 03:00:00','TEATRO BENEFICENTE',1,8,2323,5000,0,3),(101,'2021-05-07 03:00:00','TEATRO PAGO',1,200,3000,2121,10,3),(102,'2021-10-10 03:00:00','EVENTO PAGO',0,100,2600,1200,10,3),(451,'2021-10-10 03:00:00','EVENTO BENEFICENTE',0,23,1000,2600,0,3),(1252,'2021-10-10 03:00:00','CARMEN',1,50,1500,1500,110,1251);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresso`
--

DROP TABLE IF EXISTS `ingresso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresso` (
  `ID` bigint NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `TIPOCONVITE` varchar(10) DEFAULT NULL,
  `CLIENTE_ID` bigint DEFAULT NULL,
  `EVENTO_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INGRESSO_CLIENTE_ID` (`CLIENTE_ID`),
  KEY `FK_INGRESSO_EVENTO_ID` (`EVENTO_ID`),
  CONSTRAINT `FK_INGRESSO_CLIENTE_ID` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `FK_INGRESSO_EVENTO_ID` FOREIGN KEY (`EVENTO_ID`) REFERENCES `evento` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresso`
--

LOCK TABLES `ingresso` WRITE;
/*!40000 ALTER TABLE `ingresso` DISABLE KEYS */;
INSERT INTO `ingresso` VALUES (454,'IngressoTeatro','DOACAO',1,4),(456,'IngressoTeatro','DOACAO',1,4),(458,'IngressoTeatro','DOACAO',2,4),(460,'IngressoTeatro','MEIA',1,101),(462,'IngressoTeatro','PAGO',2,101),(464,'IngressoEvento','MEIA',1,102),(466,'IngressoEvento','PAGO',2,102),(468,'IngressoEvento','DOACAO',2,451),(470,'IngressoEvento','DOACAO',1,451),(551,'IngressoTeatro','DOACAO',1,4),(901,'IngressoTeatro','DOACAO',2,4),(903,'IngressoTeatro','DOACAO',1,4),(1201,'IngressoTeatro','DOACAO',2,4),(1253,'IngressoTeatro','PAGO',2,1252),(1301,'IngressoTeatro','PAGO',2,1252);
/*!40000 ALTER TABLE `ingresso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresso_evento`
--

DROP TABLE IF EXISTS `ingresso_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresso_evento` (
  `pk_ingresso_evento` bigint NOT NULL,
  PRIMARY KEY (`pk_ingresso_evento`),
  CONSTRAINT `FK_ingresso_evento_pk_ingresso_evento` FOREIGN KEY (`pk_ingresso_evento`) REFERENCES `ingresso` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresso_evento`
--

LOCK TABLES `ingresso_evento` WRITE;
/*!40000 ALTER TABLE `ingresso_evento` DISABLE KEYS */;
INSERT INTO `ingresso_evento` VALUES (464),(466),(468),(470);
/*!40000 ALTER TABLE `ingresso_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresso_teatro`
--

DROP TABLE IF EXISTS `ingresso_teatro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresso_teatro` (
  `pk_ingresso_teatro` bigint NOT NULL,
  `CODIGOCADEIRA` varchar(10) DEFAULT NULL,
  `SETOR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_ingresso_teatro`),
  CONSTRAINT `FK_ingresso_teatro_pk_ingresso_teatro` FOREIGN KEY (`pk_ingresso_teatro`) REFERENCES `ingresso` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresso_teatro`
--

LOCK TABLES `ingresso_teatro` WRITE;
/*!40000 ALTER TABLE `ingresso_teatro` DISABLE KEYS */;
INSERT INTO `ingresso_teatro` VALUES (454,'34','A'),(456,'36','A'),(458,'3','A'),(460,'34','A'),(462,'20','A'),(551,'39','A'),(901,'27','F'),(903,'33','A'),(1201,'21','A'),(1253,'36','A'),(1301,'34','A');
/*!40000 ALTER TABLE `ingresso_teatro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salao`
--

DROP TABLE IF EXISTS `salao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salao` (
  `ID` bigint NOT NULL,
  `DESCRICAO` varchar(40) DEFAULT NULL,
  `ENDERECO` varchar(40) DEFAULT NULL,
  `QUANTIDADEPESSOAS` int DEFAULT NULL,
  `VALORALUGUEL` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salao`
--

LOCK TABLES `salao` WRITE;
/*!40000 ALTER TABLE `salao` DISABLE KEYS */;
INSERT INTO `salao` VALUES (3,'SALAO DO QUINTAS','Avenida dos andradas 874',600,800),(1251,'SALÃO ZEZIN\'S','Avenida dos andradas 874',600,0);
/*!40000 ALTER TABLE `salao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',1350);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID` int NOT NULL,
  `ISADMIN` tinyint(1) DEFAULT '0',
  `LOGIN` varchar(40) DEFAULT NULL,
  `SENHA` varchar(40) DEFAULT NULL,
  `CLIENTE_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_usuario_CLIENTE_ID` (`CLIENTE_ID`),
  CONSTRAINT `FK_usuario_CLIENTE_ID` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,0,'user','123',1),(3,1,'admin','admin',2),(502,0,'aaaa','aaaa',501),(602,0,'','324234',601),(604,0,'asdasd','324324',603),(652,0,'','32423',651),(702,0,'','423432',701),(752,0,'','123213',751);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `ID` bigint NOT NULL,
  `DESCRICAO` varchar(30) DEFAULT NULL,
  `VALORTOTAL` double DEFAULT NULL,
  `CLIENTE_ID` bigint DEFAULT NULL,
  `EVENTO_ID` bigint DEFAULT NULL,
  `INGRESSO_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_venda_EVENTO_ID` (`EVENTO_ID`),
  KEY `FK_venda_CLIENTE_ID` (`CLIENTE_ID`),
  KEY `FK_venda_INGRESSO_ID` (`INGRESSO_ID`),
  CONSTRAINT `FK_venda_CLIENTE_ID` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `FK_venda_EVENTO_ID` FOREIGN KEY (`EVENTO_ID`) REFERENCES `evento` (`ID`),
  CONSTRAINT `FK_venda_INGRESSO_ID` FOREIGN KEY (`INGRESSO_ID`) REFERENCES `ingresso` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (455,'ENTRADA COM DOACAO DE ALIMENTO',0,1,4,454),(457,'ENTRADA COM DOACAO DE ALIMENTO',0,1,4,456),(459,'ENTRADA COM DOACAO DE ALIMENTO',0,2,4,458),(461,'ENTRADA PAGA, MEIA',5,1,101,460),(463,'ENTRADA PAGA, INTEIRA',10,2,101,462),(465,'ENTRADA PAGA, MEIA',5,1,102,464),(467,'ENTRADA PAGA, INTEIRA',10,2,102,466),(469,'ENTRADA COM DOACAO DE ALIMENTO',0,2,451,468),(471,'ENTRADA COM DOACAO DE ALIMENTO',0,1,451,470),(552,'ENTRADA COM DOACAO DE ALIMENTO',0,1,4,551),(902,'ENTRADA COM DOACAO DE ALIMENTO',0,2,4,901),(904,'ENTRADA COM DOACAO DE ALIMENTO',0,1,4,903),(1202,'ENTRADA COM DOACAO DE ALIMENTO',0,2,4,1201),(1254,'ENTRADA PAGA, INTEIRA',110,2,1252,1253),(1302,'ENTRADA PAGA, INTEIRA',110,2,1252,1301);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'teatro'
--

--
-- Dumping routines for database 'teatro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 20:43:19
