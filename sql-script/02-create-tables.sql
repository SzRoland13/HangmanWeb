CREATE DATABASE IF NOT EXISTS `hangman_topics`;

USE `hangman_topics`;

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topic_id` int NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(70) NOT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `word`;

CREATE TABLE `word` (
  `word_id` int NOT NULL AUTO_INCREMENT,
  `word_name` varchar(200) NOT NULL,
  `topic_id` int NOT NULL,
  PRIMARY KEY (`word_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;