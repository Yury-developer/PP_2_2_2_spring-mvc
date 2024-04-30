DROP DATABASE IF EXISTS`PP_2_2_2_spring-mvc`;
CREATE SCHEMA IF NOT EXISTS `PP_2_2_2_spring-mvc` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

SHOW DATABASES;
USE `pp_2_2_2_spring-mvc`;
SHOW TABLES FROM `spring_hiber`;
SELECT * FROM spring_hiber.users;
SELECT * FROM spring_hiber.cars;

TRUNCATE TABLE users;
TRUNCATE TABLE cars;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cars;