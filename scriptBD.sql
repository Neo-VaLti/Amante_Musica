-- MySQL Workbench Synchronization
-- Generated: 2016-11-08 19:58
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: javier

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `amantemusica` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `amantemusica`.`canciones` (
  `clave` VARCHAR(7) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `cveGenero` VARCHAR(7) NULL DEFAULT NULL,
  `interprete` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `album` VARCHAR(45) NULL DEFAULT NULL,
  `duracion` INT(10) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`clave`),
  INDEX `cveGenero_idx` (`cveGenero` ASC),
  CONSTRAINT `cveGenero`
    FOREIGN KEY (`cveGenero`)
    REFERENCES `amantemusica`.`generos` (`cveGenero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `amantemusica`.`generos` (
  `cveGenero` VARCHAR(7) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tipoMedio` CHAR NOT NULL,
  PRIMARY KEY (`cveGenero`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `amantemusica`.`peliculas` (
  `clave` VARCHAR(7) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `cveGenero` VARCHAR(7) NULL DEFAULT NULL,
  `actor1` VARCHAR(45) NOT NULL,
  `actor2` VARCHAR(45) NULL DEFAULT NULL,
  `director` VARCHAR(45) NOT NULL,
  `duracion` INT(10) NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`clave`),
  INDEX `cveGeneros_idx` (`cveGenero` ASC),
  CONSTRAINT `cveGeneros`
    FOREIGN KEY (`cveGenero`)
    REFERENCES `amantemusica`.`generos` (`cveGenero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
