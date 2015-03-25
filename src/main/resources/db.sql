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
-- Table `testdb`.`Publication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`Publication` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Date` BIGINT NOT NULL,
  `Content` VARCHAR(144) NOT NULL,
  `PublisherId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_Publication_Publisher`
    FOREIGN KEY (`PublisherId`)
    REFERENCES `testdb`.`Publisher` (`Id`)
    ON DELETE CASCADE 
    ON UPDATE CASCADE)
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

-- -----------------------------------------------------
-- Table `testdb`.`is_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testdb`.`is_member` (
  `PersonId` INT NOT NULL,
  `BandId` INT NOT NULL,
  PRIMARY KEY (`PersonId`,`BandId`),
  CONSTRAINT `fk_Band_has_Person_BandId`
  FOREIGN KEY (`BandId` )
  REFERENCES `testdb`.`Band` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Band_has_Person_PersonId`
  FOREIGN KEY (`PersonId` )
  REFERENCES `testdb`.`Person` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`Skill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`Skill` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`has_skill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`has_skill` (
  `PersonId` INT NOT NULL ,
  `SkillId` INT NOT NULL ,
  PRIMARY KEY (`PersonId`, `SkillId`) ,
  CONSTRAINT `fk_Person_has_Skill_PersonId`
  FOREIGN KEY (`PersonId` )
  REFERENCES `testdb`.`Person` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_has_Skill_SkillId`
  FOREIGN KEY (`SkillId` )
  REFERENCES `testdb`.`Skill` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`Tag`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`Tag` (
  `Id` INT NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`person_has_tag`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`person_has_tag` (
  `PersonId` INT NOT NULL ,
  `TagId` INT NOT NULL ,
  PRIMARY KEY (`PersonId`, `TagId`) ,
  CONSTRAINT `fk_Person_has_Tag_PersonId`
  FOREIGN KEY (`PersonId` )
  REFERENCES `testdb`.`Person` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_has_Tag_TagId`
  FOREIGN KEY (`TagId` )
  REFERENCES `testdb`.`Tag` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `testdb`.`band_has_tag`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`band_has_tag` (
  `BandId` INT NOT NULL ,
  `TagId` INT NOT NULL ,
  PRIMARY KEY (`BandId`, `TagId`) ,
  CONSTRAINT `fk_Band_has_Tag_BandId`
  FOREIGN KEY (`BandId` )
  REFERENCES `testdb`.`Band` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Band_has_Tag_TagId`
  FOREIGN KEY (`TagId` )
  REFERENCES `testdb`.`Tag` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

USE `testdb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;