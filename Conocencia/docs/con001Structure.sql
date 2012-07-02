CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `originalTitle` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

CREATE TABLE `bookwriters` (
  `idBook` bigint(20) NOT NULL,
  `idWriter` bigint(20) NOT NULL,
  PRIMARY KEY (`idBook`,`idWriter`),
  KEY `bookwriters_ibfk_2` (`idWriter`),
  CONSTRAINT `bookwriters_ibfk_1` FOREIGN KEY (`idBook`) REFERENCES `books` (`id`),
  CONSTRAINT `bookwriters_ibfk_2` FOREIGN KEY (`idWriter`) REFERENCES `writers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

CREATE TABLE `editions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `year` year(4) DEFAULT NULL,
  `idPublisher` bigint(20) NOT NULL,
  `buyed` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `idBook` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idPublisher` (`idPublisher`),
  KEY `idBook` (`idBook`),
  CONSTRAINT `editions_ibfk_1` FOREIGN KEY (`idPublisher`) REFERENCES `publishers` (`id`),
  CONSTRAINT `editions_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

CREATE TABLE `publishers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `universities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `idCountry` int(11) NOT NULL,
  `web` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCountry` (`idCountry`),
  CONSTRAINT `universities_ibfk_1` FOREIGN KEY (`idCountry`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;

CREATE TABLE `universitycourses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idUniversity` bigint(20) NOT NULL,
  `idCourse` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCourse` (`idCourse`),
  KEY `universitycourses_ibfk_1` (`idUniversity`),
  CONSTRAINT `universitycourses_ibfk_1` FOREIGN KEY (`idUniversity`) REFERENCES `universities` (`id`),
  CONSTRAINT `universitycourses_ibfk_2` FOREIGN KEY (`idCourse`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

CREATE TABLE `universityrecommendations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEdition` bigint(20) NOT NULL,
  `idUniversityCourse` bigint(20) NOT NULL,
  `text` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `universityrecommendations_ibfk_1` (`idEdition`),
  KEY `idUniversityCourse` (`idUniversityCourse`),
  CONSTRAINT `universityrecommendations_ibfk_1` FOREIGN KEY (`idEdition`) REFERENCES `editions` (`id`),
  CONSTRAINT `universityrecommendations_ibfk_2` FOREIGN KEY (`idUniversityCourse`) REFERENCES `universitycourses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

CREATE TABLE `writers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueName` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

