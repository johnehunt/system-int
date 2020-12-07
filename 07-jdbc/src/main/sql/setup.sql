CREATE DATABASE `coursedb`;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'user123';

GRANT ALL PRIVILEGES ON coursedb.* TO 'user'@'localhost';

USE coursedb;

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

INSERT INTO `students` VALUES (1,'Phoebe','Cooke','Animation','pc@my.com','1'),
                              (2,'Gryff','Jones','Games','grj@my.com','2'),
                              (3,'Adam','Fosh','Music','af@my.com','MSC'),
                              (4,'Jasmine','Smith','Games','js@my.com','PHD'),
                              (5,'Tom','Jones','Music','tj@my.com','F'),
                              (6,'James','Andrews','Games','ja@my.com',NULL),
                              (7,'Phoebe','Cooke','Animation','pc1@my.com',NULL),
                              (8,'Jill','Matthews','Law','jm@my.com','2');

