-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema GuardianPro
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GuardianPro
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GuardianPro` DEFAULT CHARACTER SET utf8 ;
USE `GuardianPro` ;

-- -----------------------------------------------------
-- Table `GuardianPro`.`religion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`religion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `religion_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Military_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Military_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Military_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Army_Area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Army_Area` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Area_name` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Namtional_ID` VARCHAR(45) NOT NULL,
  `Front_image` VARCHAR(45) NULL,
  `back_image` VARCHAR(45) NULL,
  `date_issue` DATETIME NULL,
  `place_Issue` VARCHAR(45) NULL,
  `religion_ID` INT NOT NULL,
  `Military_status_ID` INT NOT NULL,
  `Army_Area_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_National_ID_religion_idx` (`religion_ID` ASC),
  INDEX `fk_National_ID_Military_status1_idx` (`Military_status_ID` ASC),
  INDEX `fk_National_ID_Army_Area1_idx` (`Army_Area_ID` ASC),
  CONSTRAINT `fk_National_ID_religion`
    FOREIGN KEY (`religion_ID`)
    REFERENCES `GuardianPro`.`religion` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_National_ID_Military_status1`
    FOREIGN KEY (`Military_status_ID`)
    REFERENCES `GuardianPro`.`Military_status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_National_ID_Army_Area1`
    FOREIGN KEY (`Army_Area_ID`)
    REFERENCES `GuardianPro`.`Army_Area` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Country` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`City` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `City_name` VARCHAR(45) NOT NULL,
  `Country_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_City_Country1_idx` (`Country_ID` ASC),
  CONSTRAINT `fk_City_Country1`
    FOREIGN KEY (`Country_ID`)
    REFERENCES `GuardianPro`.`Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Birth_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Birth_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Birth_Date` DATETIME NOT NULL,
  `Birth_Cert` VARCHAR(500) NULL,
  `Birth_place` VARCHAR(500) NULL,
  `City_ID` INT NOT NULL,
  `Country_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Birth_Data_City1_idx` (`City_ID` ASC),
  INDEX `fk_Birth_Data_Country1_idx` (`Country_ID` ASC),
  CONSTRAINT `fk_Birth_Data_City1`
    FOREIGN KEY (`City_ID`)
    REFERENCES `GuardianPro`.`City` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Birth_Data_Country1`
    FOREIGN KEY (`Country_ID`)
    REFERENCES `GuardianPro`.`Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Profile_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Profile_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Picture_path` VARCHAR(300) NULL,
  `Cover_image` VARCHAR(45) NULL,
  `Nick_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Middle_name` VARCHAR(45) NOT NULL,
  `Last_name` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `National_ID_ID` INT NOT NULL,
  `Birth_Data_ID` INT NOT NULL,
  `Profile_Data_ID` INT NOT NULL,
  `Email` VARCHAR(300) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_User_National_ID1_idx` (`National_ID_ID` ASC),
  INDEX `fk_User_Birth_Data1_idx` (`Birth_Data_ID` ASC),
  INDEX `fk_User_Profile_Data1_idx` (`Profile_Data_ID` ASC),
  CONSTRAINT `fk_User_National_ID1`
    FOREIGN KEY (`National_ID_ID`)
    REFERENCES `GuardianPro`.`National_ID` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Birth_Data1`
    FOREIGN KEY (`Birth_Data_ID`)
    REFERENCES `GuardianPro`.`Birth_Data` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Profile_Data1`
    FOREIGN KEY (`Profile_Data_ID`)
    REFERENCES `GuardianPro`.`Profile_Data` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Marital_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Marital_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Marital_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID_has_Marital_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID_has_Marital_status` (
  `National_ID_ID` INT NOT NULL,
  `Marital_status_ID` INT NOT NULL,
  `no_Childern` VARCHAR(45) NULL,
  `Wife_name` VARCHAR(300) NULL,
  `National_ID_has_Marital_statuscol` VARCHAR(300) NULL,
  PRIMARY KEY (`National_ID_ID`, `Marital_status_ID`),
  INDEX `fk_National_ID_has_Marital_status_Marital_status1_idx` (`Marital_status_ID` ASC),
  INDEX `fk_National_ID_has_Marital_status_National_ID1_idx` (`National_ID_ID` ASC),
  CONSTRAINT `fk_National_ID_has_Marital_status_National_ID1`
    FOREIGN KEY (`National_ID_ID`)
    REFERENCES `GuardianPro`.`National_ID` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_National_ID_has_Marital_status_Marital_status1`
    FOREIGN KEY (`Marital_status_ID`)
    REFERENCES `GuardianPro`.`Marital_status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`District`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`District` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `District_name` VARCHAR(500) NOT NULL,
  `City_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Distinct_City1_idx` (`City_ID` ASC),
  CONSTRAINT `fk_Distinct_City1`
    FOREIGN KEY (`City_ID`)
    REFERENCES `GuardianPro`.`City` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Street` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Street_name` VARCHAR(150) NOT NULL,
  `Distinct_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Street_Distinct1_idx` (`Distinct_ID` ASC),
  CONSTRAINT `fk_Street_Distinct1`
    FOREIGN KEY (`Distinct_ID`)
    REFERENCES `GuardianPro`.`District` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Near_places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Near_places` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Places` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(500) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Address` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Street_no` INT NULL,
  `Near_places_ID` INT NOT NULL,
  `Street_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Address_Near_places1_idx` (`Near_places_ID` ASC),
  INDEX `fk_Address_Street1_idx` (`Street_ID` ASC),
  CONSTRAINT `fk_Address_Near_places1`
    FOREIGN KEY (`Near_places_ID`)
    REFERENCES `GuardianPro`.`Near_places` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Address_Street1`
    FOREIGN KEY (`Street_ID`)
    REFERENCES `GuardianPro`.`Street` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID_has_Marital_status_has_Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID_has_Marital_status_has_Address` (
  `National_ID_has_Marital_status_National_ID_ID` INT NOT NULL,
  `National_ID_has_Marital_status_Marital_status_ID` INT NOT NULL,
  `Address_ID` INT NOT NULL,
  PRIMARY KEY (`National_ID_has_Marital_status_National_ID_ID`, `National_ID_has_Marital_status_Marital_status_ID`, `Address_ID`),
  INDEX `fk_National_ID_has_Marital_status_has_Address_Address1_idx` (`Address_ID` ASC),
  INDEX `fk_National_ID_has_Marital_status_has_Address_National_ID_h_idx` (`National_ID_has_Marital_status_National_ID_ID` ASC, `National_ID_has_Marital_status_Marital_status_ID` ASC),
  CONSTRAINT `fk_National_ID_has_Marital_status_has_Address_National_ID_has1`
    FOREIGN KEY (`National_ID_has_Marital_status_National_ID_ID` , `National_ID_has_Marital_status_Marital_status_ID`)
    REFERENCES `GuardianPro`.`National_ID_has_Marital_status` (`National_ID_ID` , `Marital_status_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_National_ID_has_Marital_status_has_Address_Address1`
    FOREIGN KEY (`Address_ID`)
    REFERENCES `GuardianPro`.`Address` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Website_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Website_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `web_site` VARCHAR(45) NOT NULL,
  `Web_Desc` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Website_Data_has_User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Website_Data_has_User` (
  `Website_Data_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`Website_Data_ID`, `User_ID`),
  INDEX `fk_Website_Data_has_User_User1_idx` (`User_ID` ASC),
  INDEX `fk_Website_Data_has_User_Website_Data1_idx` (`Website_Data_ID` ASC),
  CONSTRAINT `fk_Website_Data_has_User_Website_Data1`
    FOREIGN KEY (`Website_Data_ID`)
    REFERENCES `GuardianPro`.`Website_Data` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Website_Data_has_User_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Social_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Social_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Soc_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Social_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Social_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `facebook_URL` VARCHAR(300) NULL,
  `User_ID` INT NOT NULL,
  `Social_type_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `User_ID`),
  INDEX `fk_facebook_Data_User1_idx` (`User_ID` ASC),
  INDEX `fk_Social_Data_Social_type1_idx` (`Social_type_ID` ASC),
  CONSTRAINT `fk_facebook_Data_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Social_Data_Social_type1`
    FOREIGN KEY (`Social_type_ID`)
    REFERENCES `GuardianPro`.`Social_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Phone_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Phone_types` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `tele_type` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Phone_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Phone_Data` (
  `ID` INT NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `Phone_types_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Phone_Data_Phone_types1_idx` (`Phone_types_ID` ASC),
  INDEX `fk_Phone_Data_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Phone_Data_Phone_types1`
    FOREIGN KEY (`Phone_types_ID`)
    REFERENCES `GuardianPro`.`Phone_types` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phone_Data_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Login_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Login_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Lg_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Login_way`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuardianPro`.`Login_way` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Lg_way` VARCHAR(45) NULL,
  `Login_type_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Login_way_Login_type1_idx` (`Login_type_ID` ASC),
  INDEX `fk_Login_way_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Login_way_Login_type1`
    FOREIGN KEY (`Login_type_ID`)
    REFERENCES `GuardianPro`.`Login_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Login_way_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
