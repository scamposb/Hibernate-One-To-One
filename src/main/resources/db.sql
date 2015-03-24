SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `testdb` ;
CREATE SCHEMA IF NOT EXISTS `testdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `testdb` ;

-- -----------------------------------------------------
-- Table `testdb`.`Publisher`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`Publisher` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Type` BOOLEAN NOT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`Person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`Person` (
  `Id` INT NOT NULL ,
  `Name` VARCHAR(20) NOT NULL ,
  `Email` VARCHAR(60) NOT NULL ,
  `Nip` INT NOT NULL ,
  PRIMARY KEY (`Id`) ,
  CONSTRAINT `fk_Person_Publisher`
    FOREIGN KEY (`Id` )
    REFERENCES `testdb`.`Publisher` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`Group`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`Band` (
   `Id` INT NOT NULL ,
  `Name` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  CONSTRAINT `fk_Band_Publisher`
    FOREIGN KEY (`Id` )
    REFERENCES `testdb`.`Publisher` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `testdb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;