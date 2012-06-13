CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `originalTitle` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `writers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `courses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `publishers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `editions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `year` year(4) DEFAULT NULL,
  `idPublisher` bigint(20) NOT NULL,
  `buyed` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `editions_ibfk_1` (`idPublisher`),
  CONSTRAINT `editions_ibfk_1` FOREIGN KEY (`idPublisher`) REFERENCES `publishers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `universities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `idCountry` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCountry` (`idCountry`),
  CONSTRAINT `universities_ibfk_1` FOREIGN KEY (`idCountry`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `universitycourses` (
  `idUniversity` bigint(20) NOT NULL,
  `idCourse` bigint(20) NOT NULL,
  PRIMARY KEY (`idUniversity`,`idCourse`),
  KEY `idCourse` (`idCourse`),
  CONSTRAINT `universitycourses_ibfk_1` FOREIGN KEY (`idUniversity`) REFERENCES `universities` (`id`),
  CONSTRAINT `universitycourses_ibfk_2` FOREIGN KEY (`idCourse`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

