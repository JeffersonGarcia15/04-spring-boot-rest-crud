CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Jefferson','Garcia','jefferson@aa.io'),
	(2,'Adilson','Lopez','adilson@aa.io'),
	(3,'Jonas','Garcia','jonas@aa.io'),
	(4,'Adonay','Reyes','adonay@aa.io'),
	(5,'Kevin','Garcia','kevin@aa.io');

