DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
                            `id` int(10) unsigned NOT NULL,
                            `name` varchar(30) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `employee` WRITE;
INSERT INTO `employee` VALUES (1,'Albert'),(2,'Denise'),(3,'Phoebe'),(4,'Adam');
UNLOCK TABLES;