-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lp1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lp1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lp1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `lp1` ;

create user 'userlp'@'localhost' identified by 'lp123';

grant select, insert, delete, update on lp1.* to userlp@'localhost';

-- -----------------------------------------------------
-- Table `lp1`.`animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `animal` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `costume` VARCHAR(45) NOT NULL,
  `movimento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`bolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`bolo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ingrediente` VARCHAR(45) NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`caderno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`caderno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tamanho` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `numero_pag` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`camisa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`camisa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tamanho` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`carro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`instrumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`instrumento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `caminho` VARCHAR(110) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `caminho_UNIQUE` (`caminho` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`livro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `ano_lancamento` INT NOT NULL,
  `citacao_1` VARCHAR(100) NULL DEFAULT NULL,
  `citacao_2` VARCHAR(100) NULL DEFAULT NULL,
  `citacao_3` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(20) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`planta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`planta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `lp1`.`time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lp1`.`time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_casa` VARCHAR(45) NOT NULL,
  `time_visitante` VARCHAR(55) NOT NULL,
  `arena` VARCHAR(45) NOT NULL,
  `gol_casa` INT NOT NULL,
  `gol_visitante` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
