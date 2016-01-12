-- CREATE TABLES

-- ROLE TABLE
CREATE TABLE `appy_poc`.`role_lk` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(25) NULL,
  `role_description` VARCHAR(200) NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC));
  
  
-- USER Table
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(12) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `date_joined` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `img_location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`login`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- USER_ROLE join table
CREATE TABLE `user_role` (
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_role_id_idx` (`role_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role_lk` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- specialties_lk
CREATE TABLE `specialties_lk` (
  `specialty_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`specialty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- USER_SPECIALTIES
CREATE TABLE `user_specialties` (
  `user_id` int(11) NOT NULL,
  `specialty_id` int(11) NOT NULL,
  KEY `FK_USER_ID_idx` (`user_id`),
  KEY `FK_SPECIALTY_ID_idx` (`specialty_id`),
  CONSTRAINT `FK_USER_SPECIALTY_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_SPECIALTY_ID` FOREIGN KEY (`specialty_id`) REFERENCES `specialties_lk` (`specialty_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
