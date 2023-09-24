-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema questiondb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema questiondb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `questiondb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema quizdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema quizdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `quizdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `questiondb` ;

-- -----------------------------------------------------
-- Table `questiondb`.`questiontb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `questiondb`.`questiontb` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `question_title` VARCHAR(255) NULL DEFAULT NULL,
  `option1` VARCHAR(255) NULL DEFAULT NULL,
  `option2` VARCHAR(255) NULL DEFAULT NULL,
  `option3` VARCHAR(255) NULL DEFAULT NULL,
  `option4` VARCHAR(255) NULL DEFAULT NULL,
  `right_answer` VARCHAR(255) NULL DEFAULT NULL,
  `difficultylevel` VARCHAR(255) NULL DEFAULT NULL,
  `category` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `quizdb` ;

-- -----------------------------------------------------
-- Table `quizdb`.`quiz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quizdb`.`quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quizdb`.`quiz_question_ids`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quizdb`.`quiz_question_ids` (
  `quiz_id` INT NOT NULL,
  `question_ids` INT NULL DEFAULT NULL,
  CONSTRAINT `FKs0d7k0yq779g15wmctr0tlnbi`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `quizdb`.`quiz` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `FKs0d7k0yq779g15wmctr0tlnbi` ON `quizdb`.`quiz_question_ids` (`quiz_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
