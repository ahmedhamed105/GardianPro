-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema GuardianPro
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `GuardianPro` ;

-- -----------------------------------------------------
-- Schema GuardianPro
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GuardianPro` DEFAULT CHARACTER SET utf8 ;
USE `GuardianPro` ;

-- -----------------------------------------------------
-- Table `GuardianPro`.`User_Password`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`User_Password` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`User_Password` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`User` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Middle_name` VARCHAR(45) NOT NULL,
  `Last_name` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_Password_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_User_User_Password1_idx` (`User_Password_ID` ASC),
  CONSTRAINT `fk_User_User_Password1`
    FOREIGN KEY (`User_Password_ID`)
    REFERENCES `GuardianPro`.`User_Password` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`religion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`religion` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`religion` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `religion_name` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Military_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Military_status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Military_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Military_type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Army_Area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Army_Area` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Army_Area` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Area_name` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`National_ID` ;

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
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_National_ID_religion_idx` (`religion_ID` ASC),
  INDEX `fk_National_ID_Military_status1_idx` (`Military_status_ID` ASC),
  INDEX `fk_National_ID_Army_Area1_idx` (`Army_Area_ID` ASC),
  INDEX `fk_National_ID_User1_idx` (`User_ID` ASC),
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
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_National_ID_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Marital_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Marital_status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Marital_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Marital_type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Country` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Country` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Country_name` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`City`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`City` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`City` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `City_name` VARCHAR(45) NOT NULL,
  `Country_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_City_Country1_idx` (`Country_ID` ASC),
  CONSTRAINT `fk_City_Country1`
    FOREIGN KEY (`Country_ID`)
    REFERENCES `GuardianPro`.`Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Distinct`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Distinct` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Distinct` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Distinct_name` VARCHAR(300) NOT NULL,
  `City_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
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
DROP TABLE IF EXISTS `GuardianPro`.`Street` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Street` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Street_name` VARCHAR(45) NOT NULL,
  `Distinct_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Street_Distinct1_idx` (`Distinct_ID` ASC),
  CONSTRAINT `fk_Street_Distinct1`
    FOREIGN KEY (`Distinct_ID`)
    REFERENCES `GuardianPro`.`Distinct` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Near_places`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Near_places` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Near_places` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Places` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(500) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Address` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Address` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Street_no` INT NULL,
  `Near_places_ID` INT NOT NULL,
  `Street_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
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
-- Table `GuardianPro`.`Birth_Data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Birth_Data` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Birth_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Birth_Date` DATETIME NOT NULL,
  `Birth_Cert` VARCHAR(45) NULL,
  `Birth_place` VARCHAR(45) NULL,
  `City_ID` INT NOT NULL,
  `Country_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Birth_Data_City1_idx` (`City_ID` ASC),
  INDEX `fk_Birth_Data_Country1_idx` (`Country_ID` ASC),
  INDEX `fk_Birth_Data_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Birth_Data_City1`
    FOREIGN KEY (`City_ID`)
    REFERENCES `GuardianPro`.`City` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Birth_Data_Country1`
    FOREIGN KEY (`Country_ID`)
    REFERENCES `GuardianPro`.`Country` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Birth_Data_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Profile_Data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Profile_Data` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Profile_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Picture_path` VARCHAR(300) NULL,
  `Cover_image` VARCHAR(45) NULL,
  `Nick_name` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Profile_Data_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Profile_Data_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Website_Data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Website_Data` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Website_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `web_site` VARCHAR(300) NOT NULL,
  `Web_Desc` VARCHAR(300) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Website_Data_has_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Website_Data_has_User` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Website_Data_has_User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  `Website_Data_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Website_Data_has_User_User1_idx` (`User_ID` ASC),
  INDEX `fk_Website_Data_has_User_Website_Data1_idx` (`Website_Data_ID` ASC),
  CONSTRAINT `fk_Website_Data_has_User_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Website_Data_has_User_Website_Data1`
    FOREIGN KEY (`Website_Data_ID`)
    REFERENCES `GuardianPro`.`Website_Data` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Social_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Social_type` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Social_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Soc_type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Social_Data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Social_Data` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Social_Data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `facebook_URL` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  `Social_type_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
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
DROP TABLE IF EXISTS `GuardianPro`.`Phone_types` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Phone_types` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `tele_type` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Phone_Data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Phone_Data` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Phone_Data` (
  `ID` INT NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `Phone_types_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
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
DROP TABLE IF EXISTS `GuardianPro`.`Login_type` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Login_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Lg_type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Login_way`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Login_way` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Login_way` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Lg_way` VARCHAR(45) NULL,
  `Login_type_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
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


-- -----------------------------------------------------
-- Table `GuardianPro`.`Password_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Password_history` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Password_history` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Password_history_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Password_history_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`status` (
  `ID` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Email_SMS_send`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Email_SMS_send` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Email_SMS_send` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Email_Date` DATETIME NOT NULL,
  `Email_activationcode` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Email_send_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Email_send_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`TRX_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`TRX_Type` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`TRX_Type` (
  `ID` INT NOT NULL,
  `T_Type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`pages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`pages` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`pages` (
  `page_id` INT NOT NULL,
  `page_name` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`page_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Log_Screen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Log_Screen` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Log_Screen` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `table1` VARCHAR(45) NULL,
  `TRX_desc` VARCHAR(45) NOT NULL,
  `T2_val` VARCHAR(45) NULL,
  `T1_val` VARCHAR(45) NULL,
  `T2_Col` VARCHAR(45) NULL,
  `T1_Col` VARCHAR(45) NULL,
  `table2` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  `TRX_Type_ID` INT NOT NULL,
  `Seq_no` INT NULL,
  `page_id` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Log_Screen_User1_idx` (`User_ID` ASC),
  INDEX `fk_Log_Screen_TRX_Type1_idx` (`TRX_Type_ID` ASC),
  INDEX `FK_Log_screen_Pages_idx` (`page_id` ASC),
  CONSTRAINT `fk_Log_Screen_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Log_Screen_TRX_Type1`
    FOREIGN KEY (`TRX_Type_ID`)
    REFERENCES `GuardianPro`.`TRX_Type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Log_screen_Pages`
    FOREIGN KEY (`page_id`)
    REFERENCES `GuardianPro`.`pages` (`page_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`User_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`User_status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`User_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `status_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_User_status_status1_idx` (`status_ID` ASC),
  INDEX `fk_User_status_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_User_status_status1`
    FOREIGN KEY (`status_ID`)
    REFERENCES `GuardianPro`.`status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_status_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID_has_Marital_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`National_ID_has_Marital_status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID_has_Marital_status` (
  `ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `no_Childern` VARCHAR(45) NULL,
  `Wife_name` VARCHAR(45) NULL,
  `National_ID_ID` INT NOT NULL,
  `Marital_status_ID` INT NOT NULL,
  INDEX `fk_table1_National_ID1_idx` (`National_ID_ID` ASC),
  INDEX `fk_table1_Marital_status1_idx` (`Marital_status_ID` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_table1_National_ID1`
    FOREIGN KEY (`National_ID_ID`)
    REFERENCES `GuardianPro`.`National_ID` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_Marital_status1`
    FOREIGN KEY (`Marital_status_ID`)
    REFERENCES `GuardianPro`.`Marital_status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parameter_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parameter_type` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parameter_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `XML_header` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Input_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Input_type` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Input_type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parameter` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parameter` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Field_Name` VARCHAR(100) NOT NULL,
  `Display_Name` VARCHAR(100) NOT NULL,
  `Input_Length` INT NULL,
  `Note` VARCHAR(500) NULL,
  `Allow_Null` INT NOT NULL,
  `Input_type_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Default_value` VARCHAR(500) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Parameter_Input_type1_idx` (`Input_type_ID` ASC),
  CONSTRAINT `fk_Parameter_Input_type1`
    FOREIGN KEY (`Input_type_ID`)
    REFERENCES `GuardianPro`.`Input_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parameter_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parameter_Group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parameter_Group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Group_name` VARCHAR(100) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  `Parameter_type_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Parameter_Group_User1_idx` (`User_ID` ASC),
  INDEX `fk_Parameter_Group_Parameter_type1_idx` (`Parameter_type_ID` ASC),
  CONSTRAINT `fk_Parameter_Group_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parameter_Group_Parameter_type1`
    FOREIGN KEY (`Parameter_type_ID`)
    REFERENCES `GuardianPro`.`Parameter_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Group_Has_Parameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Group_Has_Parameter` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Group_Has_Parameter` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Parameter_ID` INT NOT NULL,
  `Parameter_Group_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Group_Has_Parameter_Parameter1_idx` (`Parameter_ID` ASC),
  INDEX `fk_Group_Has_Parameter_Parameter_Group1_idx` (`Parameter_Group_ID` ASC),
  CONSTRAINT `fk_Group_Has_Parameter_Parameter1`
    FOREIGN KEY (`Parameter_ID`)
    REFERENCES `GuardianPro`.`Parameter` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Group_Has_Parameter_Parameter_Group1`
    FOREIGN KEY (`Parameter_Group_ID`)
    REFERENCES `GuardianPro`.`Parameter_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID_has_Marital_status1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`National_ID_has_Marital_status1` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID_has_Marital_status1` (
  `National_ID_ID` INT NOT NULL,
  `Marital_status_ID` INT NOT NULL,
  `no_Childern` VARCHAR(45) NULL,
  `Wife_name` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`National_ID_ID`, `Marital_status_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`National_ID_has_Marital_status_has_Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`National_ID_has_Marital_status_has_Address` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`National_ID_has_Marital_status_has_Address` (
  `National_ID_has_Marital_status_National_ID_ID` INT NOT NULL,
  `National_ID_has_Marital_status_Marital_status_ID` INT NOT NULL,
  `Address_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`National_ID_has_Marital_status_National_ID_ID`, `National_ID_has_Marital_status_Marital_status_ID`, `Address_ID`),
  INDEX `fk_National_ID_has_Marital_status_has_Address_National_ID_h_idx` (`National_ID_has_Marital_status_National_ID_ID` ASC, `National_ID_has_Marital_status_Marital_status_ID` ASC),
  CONSTRAINT `fk_National_ID_has_Marital_status_has_Address_National_ID_has1`
    FOREIGN KEY (`National_ID_has_Marital_status_National_ID_ID` , `National_ID_has_Marital_status_Marital_status_ID`)
    REFERENCES `GuardianPro`.`National_ID_has_Marital_status1` (`National_ID_ID` , `Marital_status_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Groups` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Groups` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `AD_name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Role` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Role` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`component`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`component` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`component` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Description` VARCHAR(45) NULL,
  `Parent_ID` INT NULL,
  `Type` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `C_name` VARCHAR(150) NULL DEFAULT 'a',
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Role_has_Groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Role_has_Groups` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Role_has_Groups` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Role_ID` INT NOT NULL,
  `Groups_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Role_has_Groups_Role1_idx` (`Role_ID` ASC),
  INDEX `fk_Role_has_Groups_Groups1_idx` (`Groups_ID` ASC),
  CONSTRAINT `fk_Role_has_Groups_Role1`
    FOREIGN KEY (`Role_ID`)
    REFERENCES `GuardianPro`.`Role` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Role_has_Groups_Groups1`
    FOREIGN KEY (`Groups_ID`)
    REFERENCES `GuardianPro`.`Groups` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Groups_has_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Groups_has_User` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Groups_has_User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Groups_ID` INT NOT NULL,
  INDEX `fk_Groups_has_User_User1_idx` (`User_ID` ASC),
  PRIMARY KEY (`ID`),
  INDEX `fk_Groups_has_User_Groups1_idx` (`Groups_ID` ASC),
  CONSTRAINT `fk_Groups_has_User_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Groups_has_User_Groups1`
    FOREIGN KEY (`Groups_ID`)
    REFERENCES `GuardianPro`.`Groups` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Phone_Data_copy1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Phone_Data_copy1` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Phone_Data_copy1` (
  `ID` INT NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `Phone_types_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Phone_Data_Phone_types1_idx` (`Phone_types_ID` ASC),
  INDEX `fk_Phone_Data_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Phone_Data_Phone_types10`
    FOREIGN KEY (`Phone_types_ID`)
    REFERENCES `GuardianPro`.`Phone_types` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phone_Data_User10`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Role_has_component`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Role_has_component` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Role_has_component` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `view` TINYINT(1) NOT NULL DEFAULT 0,
  `edit` TINYINT(1) NOT NULL DEFAULT 0,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Role_ID` INT NOT NULL,
  `component_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Role_has_component_Role1_idx` (`Role_ID` ASC),
  INDEX `fk_Role_has_component_component1_idx` (`component_ID` ASC),
  CONSTRAINT `fk_Role_has_component_Role1`
    FOREIGN KEY (`Role_ID`)
    REFERENCES `GuardianPro`.`Role` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Role_has_component_component1`
    FOREIGN KEY (`component_ID`)
    REFERENCES `GuardianPro`.`component` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Config_parmeter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Config_parmeter` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Config_parmeter` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Parameter` VARCHAR(500) NOT NULL,
  `PValue` VARCHAR(150) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Encryption` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Config_parmeter_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Config_parmeter_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Application` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Application` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `APP_NAME` VARCHAR(45) NOT NULL,
  `APP_DIR` VARCHAR(150) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `File_name` VARCHAR(100) NOT NULL,
  `APP_SIZE` INT NULL,
  `APP_length` INT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Application_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Application_Group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Application_Group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Group_name` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Application_Group_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Application_Group_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Application_has_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Application_has_Group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Application_has_Group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Application_ID` INT NOT NULL,
  `Application_Group_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Application_has_Group_Application1_idx` (`Application_ID` ASC),
  INDEX `fk_Application_has_Group_Application_Group1_idx` (`Application_Group_ID` ASC),
  CONSTRAINT `fk_Application_has_Group_Application1`
    FOREIGN KEY (`Application_ID`)
    REFERENCES `GuardianPro`.`Application` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Application_has_Group_Application_Group1`
    FOREIGN KEY (`Application_Group_ID`)
    REFERENCES `GuardianPro`.`Application_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`accessory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`accessory` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`accessory` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `acc_name` VARCHAR(150) NOT NULL,
  `acc_descr` VARCHAR(400) NULL,
  `acc_catalog` VARCHAR(150) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`accessory_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`accessory_Group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`accessory_Group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Group_name` VARCHAR(150) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_accessory_Group_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_accessory_Group_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`accessory_has_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`accessory_has_group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`accessory_has_group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `accessory_ID` INT NOT NULL,
  `accessory_Group_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_accessory_has_group_accessory1_idx` (`accessory_ID` ASC),
  INDEX `fk_accessory_has_group_accessory_Group1_idx` (`accessory_Group_ID` ASC),
  CONSTRAINT `fk_accessory_has_group_accessory1`
    FOREIGN KEY (`accessory_ID`)
    REFERENCES `GuardianPro`.`accessory` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_accessory_has_group_accessory_Group1`
    FOREIGN KEY (`accessory_Group_ID`)
    REFERENCES `GuardianPro`.`accessory_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parts` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parts` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `PName` VARCHAR(150) NOT NULL,
  `Pdesc` VARCHAR(150) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Terminal_template`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Terminal_template` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Terminal_template` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TName` VARCHAR(150) NOT NULL,
  `Tdesc` VARCHAR(150) NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Terminal_template_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Terminal_template_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Download_method`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Download_method` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Download_method` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DName` VARCHAR(150) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Terminal_has_Parts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Terminal_has_Parts` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Terminal_has_Parts` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Parts_ID` INT NOT NULL,
  `Download_method_ID` INT NOT NULL,
  `Terminal_template_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Terminal_has_template_Parts1_idx` (`Parts_ID` ASC),
  INDEX `fk_Terminal_has_Parts_Download_method1_idx` (`Download_method_ID` ASC),
  INDEX `fk_Terminal_has_Parts_Terminal_template1_idx` (`Terminal_template_ID` ASC),
  CONSTRAINT `fk_Terminal_has_template_Parts1`
    FOREIGN KEY (`Parts_ID`)
    REFERENCES `GuardianPro`.`Parts` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terminal_has_Parts_Download_method1`
    FOREIGN KEY (`Download_method_ID`)
    REFERENCES `GuardianPro`.`Download_method` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terminal_has_Parts_Terminal_template1`
    FOREIGN KEY (`Terminal_template_ID`)
    REFERENCES `GuardianPro`.`Terminal_template` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Terminal_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Terminal_status` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Terminal_status` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Tstatus` VARCHAR(45) NOT NULL,
  `Tdescrip` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Terminal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Terminal` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Terminal` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `TID` VARCHAR(50) NOT NULL,
  `Owner_Name` VARCHAR(500) NULL,
  `Merchant_Name` VARCHAR(500) NULL,
  `Shop_Name` VARCHAR(500) NULL,
  `Address` VARCHAR(500) NULL,
  `Contact_person` VARCHAR(500) NULL,
  `Tel_No` VARCHAR(50) NULL,
  `officeContact` VARCHAR(45) NULL,
  `officeTelNo` VARCHAR(45) NULL,
  `POS_SerialNo` VARCHAR(500) NOT NULL,
  `Terminal_template_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Terminal_status_ID` INT NOT NULL,
  `schedule_start` DATETIME NULL,
  `schedule_end` DATETIME NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Terminal_Terminal_template1_idx` (`Terminal_template_ID` ASC),
  INDEX `fk_Terminal_Terminal_status1_idx` (`Terminal_status_ID` ASC),
  CONSTRAINT `fk_Terminal_Terminal_template1`
    FOREIGN KEY (`Terminal_template_ID`)
    REFERENCES `GuardianPro`.`Terminal_template` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Terminal_Terminal_status1`
    FOREIGN KEY (`Terminal_status_ID`)
    REFERENCES `GuardianPro`.`Terminal_status` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Terminal_Group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Terminal_Group` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Terminal_Group` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Group_name` VARCHAR(45) NOT NULL,
  `Group_desc` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Terminal_Group_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Terminal_Group_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`TGroup_has_parts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`TGroup_has_parts` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`TGroup_has_parts` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Parts_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TGroup_has_parts_Parts1_idx` (`Parts_ID` ASC),
  CONSTRAINT `fk_TGroup_has_parts_Parts1`
    FOREIGN KEY (`Parts_ID`)
    REFERENCES `GuardianPro`.`Parts` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Tgroup_has_Gparameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Tgroup_has_Gparameter` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Tgroup_has_Gparameter` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Terminal_Group_ID` INT NOT NULL,
  `Parameter_Group_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `terminal_id` INT NULL,
  `ACC_id` INT NULL,
  `ISS_id` INT NULL,
  `Card_id` INT NULL,
  `XML_update` INT NOT NULL,
  `filename` VARCHAR(450) NULL,
  `file_length` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Tgroup_has_Gparameter_Terminal_Group1_idx` (`Terminal_Group_ID` ASC),
  INDEX `fk_Tgroup_has_Gparameter_Parameter_Group1_idx` (`Parameter_Group_ID` ASC),
  CONSTRAINT `fk_Tgroup_has_Gparameter_Terminal_Group1`
    FOREIGN KEY (`Terminal_Group_ID`)
    REFERENCES `GuardianPro`.`Terminal_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tgroup_has_Gparameter_Parameter_Group1`
    FOREIGN KEY (`Parameter_Group_ID`)
    REFERENCES `GuardianPro`.`Parameter_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Tgroup_has_software`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Tgroup_has_software` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Tgroup_has_software` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Terminal_Group_ID` INT NOT NULL,
  `Application_Group_ID` INT NOT NULL,
  `S_Desc` VARCHAR(500) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `XML_update` INT NOT NULL,
  `APP_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Tgroup_has_software_Terminal_Group1_idx` (`Terminal_Group_ID` ASC),
  INDEX `fk_Tgroup_has_software_Application_Group1_idx` (`Application_Group_ID` ASC),
  CONSTRAINT `fk_Tgroup_has_software_Terminal_Group1`
    FOREIGN KEY (`Terminal_Group_ID`)
    REFERENCES `GuardianPro`.`Terminal_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tgroup_has_software_Application_Group1`
    FOREIGN KEY (`Application_Group_ID`)
    REFERENCES `GuardianPro`.`Application_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Tgroup_has_accesory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Tgroup_has_accesory` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Tgroup_has_accesory` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Terminal_Group_ID` INT NOT NULL,
  `accessory_Group_ID` INT NOT NULL,
  `A_accessory` VARCHAR(500) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `XML_update` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Tgroup_has_accesory_Terminal_Group1_idx` (`Terminal_Group_ID` ASC),
  INDEX `fk_Tgroup_has_accesory_accessory_Group1_idx` (`accessory_Group_ID` ASC),
  CONSTRAINT `fk_Tgroup_has_accesory_Terminal_Group1`
    FOREIGN KEY (`Terminal_Group_ID`)
    REFERENCES `GuardianPro`.`Terminal_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tgroup_has_accesory_accessory_Group1`
    FOREIGN KEY (`accessory_Group_ID`)
    REFERENCES `GuardianPro`.`accessory_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`TGroup_has_terminal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`TGroup_has_terminal` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`TGroup_has_terminal` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Terminal_ID` INT NOT NULL,
  `Terminal_Group_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `XML_update` INT NOT NULL,
  `DLL_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TGroup_has_terminal_Terminal1_idx` (`Terminal_ID` ASC),
  INDEX `fk_TGroup_has_terminal_Terminal_Group1_idx` (`Terminal_Group_ID` ASC),
  CONSTRAINT `fk_TGroup_has_terminal_Terminal1`
    FOREIGN KEY (`Terminal_ID`)
    REFERENCES `GuardianPro`.`Terminal` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TGroup_has_terminal_Terminal_Group1`
    FOREIGN KEY (`Terminal_Group_ID`)
    REFERENCES `GuardianPro`.`Terminal_Group` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parmeter_schema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parmeter_schema` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parmeter_schema` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Terminal_ID` VARCHAR(45) NOT NULL,
  `Acquirer_ID` VARCHAR(45) NULL,
  `Issuer_ID` VARCHAR(45) NULL,
  `CardRange_ID` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Group_sechema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Group_sechema` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Group_sechema` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Parameter_type_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Group_sechema_Parameter_type1_idx` (`Parameter_type_ID` ASC),
  CONSTRAINT `fk_Group_sechema_Parameter_type1`
    FOREIGN KEY (`Parameter_type_ID`)
    REFERENCES `GuardianPro`.`Parameter_type` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Parameter_values`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Parameter_values` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Parameter_values` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Tgroup_has_Gparameter_ID` INT NOT NULL,
  `Parameter_ID` INT NOT NULL,
  `Value` VARCHAR(500) NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Parameter_values_Tgroup_has_Gparameter1_idx` (`Tgroup_has_Gparameter_ID` ASC),
  INDEX `fk_Parameter_values_Parameter1_idx` (`Parameter_ID` ASC),
  CONSTRAINT `fk_Parameter_values_Tgroup_has_Gparameter1`
    FOREIGN KEY (`Tgroup_has_Gparameter_ID`)
    REFERENCES `GuardianPro`.`Tgroup_has_Gparameter` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parameter_values_Parameter1`
    FOREIGN KEY (`Parameter_ID`)
    REFERENCES `GuardianPro`.`Parameter` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`PGchild`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`PGchild` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`PGchild` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `root` INT NULL,
  `child` INT NULL,
  `Tgroup_has_Gparameter_ID` INT NOT NULL,
  `Tgroup_has_Gparameter_ID1` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_PGchild_Tgroup_has_Gparameter1_idx` (`Tgroup_has_Gparameter_ID` ASC),
  INDEX `fk_PGchild_Tgroup_has_Gparameter2_idx` (`Tgroup_has_Gparameter_ID1` ASC),
  CONSTRAINT `fk_PGchild_Tgroup_has_Gparameter1`
    FOREIGN KEY (`Tgroup_has_Gparameter_ID`)
    REFERENCES `GuardianPro`.`Tgroup_has_Gparameter` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PGchild_Tgroup_has_Gparameter2`
    FOREIGN KEY (`Tgroup_has_Gparameter_ID1`)
    REFERENCES `GuardianPro`.`Tgroup_has_Gparameter` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Email_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Email_log` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Email_log` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `E_subject` VARCHAR(500) NOT NULL,
  `E_text` VARCHAR(10000) NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `Pending` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Email_log_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Email_log_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`FTP_messages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`FTP_messages` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`FTP_messages` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `F_messages` VARCHAR(500) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `FTP_Log_ID` INT NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_FTP_messages_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_FTP_messages_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Config_email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Config_email` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Config_email` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(450) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Config_email_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Config_email_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Menu` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Menu` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Link` VARCHAR(45) NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Menu_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Menu_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Menu_sub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Menu_sub` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Menu_sub` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Link` VARCHAR(45) NOT NULL,
  `Menu_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Menu_sub_Menu1_idx` (`Menu_ID` ASC),
  CONSTRAINT `fk_Menu_sub_Menu1`
    FOREIGN KEY (`Menu_ID`)
    REFERENCES `GuardianPro`.`Menu` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Action_bar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Action_bar` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Action_bar` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `link` VARCHAR(150) NOT NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Action_bar_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Action_bar_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`terminal_parser_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`terminal_parser_log` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`terminal_parser_log` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NULL,
  `TID` VARCHAR(50) NOT NULL,
  `DT` VARCHAR(50) NOT NULL,
  `VER` VARCHAR(45) NOT NULL,
  `MODE` VARCHAR(45) NOT NULL,
  `ERR` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `USER_ID_FK_idx` (`user_id` ASC),
  CONSTRAINT `USER_ID_FK`
    FOREIGN KEY (`user_id`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Component_name`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Component_name` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Component_name` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Value` VARCHAR(45) NULL,
  `Description` VARCHAR(45) NULL,
  `Edit` INT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `component_component_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Component_name_component1_idx` (`component_component_ID` ASC),
  CONSTRAINT `fk_Component_name_component1`
    FOREIGN KEY (`component_component_ID`)
    REFERENCES `GuardianPro`.`component` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Reports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Reports` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Reports` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Report_DIR` VARCHAR(500) NOT NULL,
  `Report_name` VARCHAR(45) NOT NULL,
  `Report_SQL` VARCHAR(10000) NOT NULL,
  `User_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Reports_User1_idx` (`User_ID` ASC),
  CONSTRAINT `fk_Reports_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `GuardianPro`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`R_parameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`R_parameter` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`R_parameter` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `R_para` VARCHAR(500) NOT NULL,
  `Para_value` VARCHAR(500) NOT NULL,
  `Reports_ID` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_R_parameter_Reports1_idx` (`Reports_ID` ASC),
  CONSTRAINT `fk_R_parameter_Reports1`
    FOREIGN KEY (`Reports_ID`)
    REFERENCES `GuardianPro`.`Reports` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GuardianPro`.`Email_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GuardianPro`.`Email_history` ;

CREATE TABLE IF NOT EXISTS `GuardianPro`.`Email_history` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Email_log_ID` INT NOT NULL,
  `Email` VARCHAR(45) NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  `E_send_not` INT NOT NULL,
  `Config_email_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Email_history_Email_log1_idx` (`Email_log_ID` ASC),
  INDEX `fk_Email_history_Config_email1_idx` (`Config_email_ID` ASC),
  CONSTRAINT `fk_Email_history_Email_log1`
    FOREIGN KEY (`Email_log_ID`)
    REFERENCES `GuardianPro`.`Email_log` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Email_history_Config_email1`
    FOREIGN KEY (`Config_email_ID`)
    REFERENCES `GuardianPro`.`Config_email` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `GuardianPro`.`User_Password`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`User_Password` (`ID`, `password`, `create_date`, `update_date`) VALUES (1, 'ugnClcbkdWSUcjNFzCoFXQ==', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`User` (`ID`, `First_Name`, `Middle_name`, `Last_name`, `Username`, `create_date`, `update_date`, `User_Password_ID`) VALUES (1, 'ahmed', 'ahmed', 'ahmed', 'ahmed', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`status`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`status` (`ID`, `Status`, `create_date`, `update_date`) VALUES (1, 'Active', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`status` (`ID`, `Status`, `create_date`, `update_date`) VALUES (2, 'Not Active', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`status` (`ID`, `Status`, `create_date`, `update_date`) VALUES (3, 'Locked', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`status` (`ID`, `Status`, `create_date`, `update_date`) VALUES (4, 'Email_Activation', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`TRX_Type`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`TRX_Type` (`ID`, `T_Type`, `create_date`, `update_date`) VALUES (1, 'INFO', '2018-06-16 23:48:54', '2018-06-16 23:48:54');
INSERT INTO `GuardianPro`.`TRX_Type` (`ID`, `T_Type`, `create_date`, `update_date`) VALUES (2, 'ERROR', '2018-06-16 23:48:54', '2018-06-16 23:48:54');
INSERT INTO `GuardianPro`.`TRX_Type` (`ID`, `T_Type`, `create_date`, `update_date`) VALUES (3, 'EXCEPTION', '2018-06-16 23:48:54', '2018-06-16 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`pages`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (1, 'Action');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (2, 'ComponentsOfRole');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (3, 'Encryption');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (4, 'Inputtype');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (5, 'Login');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (6, 'Main');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (7, 'ParameterGroups');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (8, 'Partsbean');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (9, 'Pconfig');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (10, 'Profile');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (11, 'RolesBean');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (12, 'RolesOfGroup');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (13, 'TerminalTemp');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (14, 'Terminalbean');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (15, 'Terminalgroup');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (16, 'accessgroup');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (17, 'accessory');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (18, 'appgroup');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (19, 'application');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (20, 'groups');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (21, 'parameter');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (22, 'parmetertype');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (23, 'menu');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (24, 'Component');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (25, 'Main');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (26, 'Report');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (27, 'Log');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (28, 'Log SMTP');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (29, 'Log FTP');
INSERT INTO `GuardianPro`.`pages` (`page_id`, `page_name`) VALUES (30, 'Log Download');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`User_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`User_status` (`ID`, `status_ID`, `User_ID`) VALUES (1, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Parameter_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (1, 'TERMINAL', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'Terminal');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (2, 'ACQUIRER', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'Acquirer');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (3, 'ISSUER', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'Issuer');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (4, 'CARDRANGE', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'CardRange');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (5, 'EMVL2APP', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'EMVLevel2App');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (6, 'EMVCTLAPP', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'EMVCtlApp');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (7, 'EMVL2KEY', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'EMVLevel2Key');
INSERT INTO `GuardianPro`.`Parameter_type` (`ID`, `type`, `create_date`, `update_date`, `XML_header`) VALUES (8, 'OTHER', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'OTHER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Input_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Input_type` (`ID`, `type`, `create_date`, `update_date`) VALUES (1, 'ASCII', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Input_type` (`ID`, `type`, `create_date`, `update_date`) VALUES (2, 'VALUE', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Input_type` (`ID`, `type`, `create_date`, `update_date`) VALUES (3, 'HEX', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Input_type` (`ID`, `type`, `create_date`, `update_date`) VALUES (4, 'List', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Parameter`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Parameter` (`ID`, `Field_Name`, `Display_Name`, `Input_Length`, `Note`, `Allow_Null`, `Input_type_ID`, `create_date`, `update_date`, `Default_value`) VALUES (1, 'APN', 'APN', 3, '', 1, 1, '2018-05-23 22:28:58', '2018-05-24 13:41:58', NULL);
INSERT INTO `GuardianPro`.`Parameter` (`ID`, `Field_Name`, `Display_Name`, `Input_Length`, `Note`, `Allow_Null`, `Input_type_ID`, `create_date`, `update_date`, `Default_value`) VALUES (2, 'DE', 'DE', 32, '', 1, 1, '2018-05-23 22:29:10', '2018-05-23 22:29:10', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Parameter_Group`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Parameter_Group` (`ID`, `Group_name`, `create_date`, `update_date`, `User_ID`, `Parameter_type_ID`) VALUES (1, 'he', '2018-05-23 22:29:38', '2018-05-23 22:29:38', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Group_Has_Parameter`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Group_Has_Parameter` (`ID`, `Parameter_ID`, `Parameter_Group_ID`, `create_date`, `update_date`) VALUES (1, 1, 1, '2018-05-23 22:29:43', '2018-05-23 22:29:43');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Groups`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Groups` (`ID`, `name`, `AD_name`, `description`, `create_date`, `update_date`) VALUES (1, 'admins', 'admins', 'admins', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Role`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Role` (`ID`, `name`, `Description`, `create_date`, `update_date`) VALUES (1, 'admin', 'admin', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`component`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (1, 'accessory.xhtml', 'accessory.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'accessory');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (2, 'Accessorygroup.xhtml', 'Accessorygroup.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (3, 'Actionbar.xhtml', 'Actionbar.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (4, 'Apps.xhtml', 'Apps.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (5, 'Appsgroup.xhtml', 'Appsgroup.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (6, 'bower_components', 'bower_components', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (7, 'CompinentOfRole.xhtml', 'CompinentOfRole.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (8, 'Config.xhtml', 'Config.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (9, 'Groups.xhtml', 'Groups.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (10, 'index.xhtml', 'index.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (11, 'input_type.xhtml', 'input_type.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (12, 'login.xhtml', 'login.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (13, 'Main.xhtml', 'Main.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (14, 'Parameter.xhtml', 'Parameter.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (15, 'ParameterGroup.xhtml', 'ParameterGroup.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (16, 'Parmeter_type.xhtml', 'Parmeter_type.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (17, 'Parts.xhtml', 'Parts.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (18, 'profile.xhtml', 'profile.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (19, 'Roles.xhtml', 'Roles.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (20, 'Slider.xhtml', 'Slider.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (21, 'Terminal.xhtml', 'Terminal.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (22, 'TerminalGroup.xhtml', 'TerminalGroup.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (23, 'TerminalTemplate.xhtml', 'TerminalTemplate.xhtml', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (24, 'accessory_Create', 'accessory_Create', 1, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (25, 'accessory_Edit', 'accessory_Edit', 1, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (26, 'accessorygroup_edit', 'accessorygroup_edit', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (27, 'accessorygroup_remove', 'accessorygroup_remove', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (28, 'accessorygroup_submit', 'accessorygroup_submit', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (29, 'accessorygroup_add_submit', 'accessorygroup_add_submit', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (30, 'accessorygroup_select_one_menu', 'accessorygroup_select_one_menu', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (31, 'accessorygroup__select_aplicatin', 'accessorygroup__select_aplicatin', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (32, 'accessorygroup__select_aplicatin_Group', 'accessorygroup__select_aplicatin_Group', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (33, 'accessorygroup__select_aplicatin_Group_submit', 'accessorygroup__select_aplicatin_Group_submit', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (34, 'apps_view', 'apps_view', 4, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (35, 'apps_multi_part', 'apps_multi_part', 4, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (36, 'app_group', 'app_group', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (37, 'app_group_remove', 'app_group_remove', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (38, 'app_group_submit', 'app_group_submit', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (39, 'app_groups_add', 'app_groups_add', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (40, 'app_groups_select', 'app_groups_select', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (41, 'app_groups_select_submit', 'app_groups_select_submit', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (42, 'groups_edit', 'groups_edit', 9, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (43, 'groups_add', 'groups_add', 9, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (44, 'paramter_edit', 'paramter_edit', 14, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (45, 'paramter_submit', 'paramter_submit', 14, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (46, 'paramter_select', 'paramter_select', 14, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (47, 'paramter_add', 'paramter_add', 14, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (48, 'paramterGroup_form_edit', 'paramterGroup_form_edit', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (49, 'paramtergroup_remove', 'paramtergroup_remove', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (50, 'paramtergroup_removegroup', 'paramtergroup_removegroup', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (51, 'paramtergroup_form_add', 'paramtergroup_form_add', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (52, 'paramtergroup_add', 'paramtergroup_add', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (53, 'paramtergroup_assign_group_form', 'paramtergroup_assign_group_form', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (54, 'paramtergroup_assign', 'paramtergroup_assign', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (55, 'paramter_type_remove', 'paramter_type_remove', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (56, 'paramter_type_add', 'paramter_type_add', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (57, 'parts_edit', 'parts_edit', 17, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (58, 'parts_edit_submit', 'parts_edit_submit', 17, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (59, 'parts_add', 'parts_add', 17, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (60, 'parts_add_submit', 'parts_add_submit', 17, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (61, 'termenal_edit', 'termenal_edit', 21, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (62, 'termenal_edit_submit', 'termenal_edit_submit', 21, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (63, 'termenal_add', 'termenal_add', 21, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (64, 'terminalgroup_edit_submit', 'terminalgroup_edit_submit', 22, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'aa');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (65, 'termenalgroup_add', 'termenalgroup_add', 22, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (66, 'termenalgroup_termenal_remove', 'termenalgroup_termenal_remove', 22, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (67, 'termenalgroup_termenal_add', 'termenalgroup_termenal_add', 22, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (68, 'TerminalGroup_log', 'TerminalGroup log', 22, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (69, 'Terminal_log', 'Terminal log', 21, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (70, 'TerminalTemplate_log', 'TerminalTemplate log', 23, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (71, 'Appsgroup_log', 'Appsgroup log', 5, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (72, 'Parameter_log', 'Parameter log', 14, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (73, 'ParameterGroup_log', 'ParameterGroup log', 15, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (74, 'Apps_log', 'Apps log', 4, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (75, 'Accessorygroup_log', 'Accessorygroup log', 2, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (76, 'accessory_log', 'accessory log', 1, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (77, 'admin', 'Admin', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (78, 'Config_log', 'Config log', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (79, 'paramter_configration', 'paramter_configration', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (80, 'report_configration', 'report configration', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (81, 'report_paramter_configration', 'report paramter configration', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (82, 'report_paramter_configration_add', 'report paramter configration_add', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (83, 'email_configration', 'email configration', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (84, 'email_configration_add', 'email configration add', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (85, 'paramter_configration_add', 'paramter_configration_add', 8, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (86, 'profile_list', 'profile list', 18, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (87, 'profile_add', 'profile add', 18, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (88, 'profile_log', 'profile_log', 18, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (89, 'roles_edit', 'roles edit', 19, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (90, 'roles_add', 'roles add', 19, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (91, 'roles_log', 'roles log', 19, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (92, 'RGroups_log', 'RGroups log', 9, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (93, 'component_edit', 'component edit', 94, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (94, 'component', 'component', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (95, 'component_log', 'component_log', 94, 'component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (96, 'reports', 'reports', 0, 'Screen', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (97, 'reports_edit', 'reports Edit', 96, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (98, 'apps_edit', 'apps edit', 4, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (99, 'apps_add', 'apps add', 4, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (100, 'apps_group_log', 'apps group log', 5, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (101, 'component_of_role_edit', 'component of roles edit', 7, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (102, 'component_of_role_log', 'component of roles log', 7, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (103, 'config_edit', 'config edit', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (104, 'config_add', 'config add', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (105, 'config_list', 'config List', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (106, 'paramter_group_log', 'paramter group log', 15, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (107, 'parts_log', 'parts log', 17, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (108, 'group_log', 'group log', 9, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (109, 'TerminalTemplate_edit', 'TerminalTemplate edit', 23, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (110, 'TerminalTemplate_add', 'TerminalTemplate add', 23, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (111, 'TerminalTemplate_select', 'TerminalTemplate_select', 23, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (112, 'input_type_edit', 'input_type edit', 11, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (113, 'input_type_add', 'input_type_add', 11, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (114, 'input_type_log', 'input_type_log', 11, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (115, 'role_of_component_edit', 'role_of_component edit', 7, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (116, 'role_of_component_log', 'role_of_component_log', 7, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (117, 'configration_paramter', 'configration_paramter', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (118, 'report', 'report', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (119, 'report_paramter', 'report_paramter', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (120, 'email_edit', 'email_edit', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `GuardianPro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES (121, 'email_add', 'email_add', 8, 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Role_has_Groups`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Role_has_Groups` (`ID`, `create_date`, `update_date`, `Role_ID`, `Groups_ID`) VALUES (1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Groups_has_User`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Groups_has_User` (`ID`, `User_ID`, `create_date`, `update_date`, `Groups_ID`) VALUES (1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Role_has_component`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (1, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 1);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (2, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 2);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (3, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 3);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (4, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 4);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (5, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 5);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (6, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 6);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (7, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 7);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (8, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 8);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (9, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 9);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (10, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 10);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (11, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 11);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (12, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 12);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (13, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 13);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (14, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 14);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (15, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 15);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (16, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 16);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (17, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 17);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (18, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 18);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (19, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 19);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (20, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 20);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (21, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 21);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (22, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 22);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (23, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 23);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (24, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 24);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (25, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 25);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (26, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 26);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (27, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 27);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (28, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 28);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (29, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 29);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (30, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 30);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (31, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 31);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (32, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 32);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (33, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 33);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (34, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 34);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (35, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 35);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (36, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 36);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (37, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 37);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (38, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 38);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (39, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 39);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (40, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 40);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (41, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 41);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (42, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 42);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (43, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 43);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (44, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 44);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (45, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 45);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (46, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 46);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (47, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 47);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (48, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 48);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (49, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 49);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (50, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 50);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (51, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 51);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (52, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 52);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (53, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 53);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (54, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 54);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (55, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 55);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (56, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 56);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (57, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 57);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (58, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 58);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (59, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 59);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (60, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 60);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (61, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 61);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (62, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 62);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (63, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 63);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (64, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 64);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (65, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 65);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (66, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 66);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (67, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 67);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (68, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 68);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (69, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 69);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (70, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 70);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (71, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 71);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (72, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 72);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (73, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 73);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (74, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 74);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (75, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 75);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (76, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 76);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (77, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 77);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (78, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 78);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (79, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 79);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (80, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 80);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (81, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 81);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (82, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 82);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (83, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 83);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (84, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 84);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (85, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 85);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (86, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 86);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (87, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 87);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (88, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 88);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (89, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 89);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (90, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 90);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (91, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 91);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (92, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 92);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (93, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 93);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (94, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 94);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (95, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 95);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (96, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 96);
INSERT INTO `GuardianPro`.`Role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES (97, 1, 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 97);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Config_parmeter`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (1, 'LOCAL_APP_DIR', 'D:\\\\TMS2\\\\applications', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (2, 'smtp_host', 'smtp.gmail.com', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (3, 'smtp_from', 'spectra.test.v1@gmail.com', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (4, 'smtp_password', 'TgiDbTmesexGZ+eGQeg8ofwJNIlhYMXw+kSaKcbrNDw=', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (5, 'smtp_to', 'spectra.test.v1@gmail.com', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (6, 'smtp_port', '587', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (7, 'smtp_TLS', '1', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (8, 'FTP_server', 'localhost', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (9, 'FTP_port', '21', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (10, 'FTP_user', 'ahmed', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (11, 'FTP_pass', 'D4ej0Wr9fhZ6xoT2yZ6tNQ==', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 1, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (13, 'TIMER_PARSER_FLAG', 'false', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (14, 'TERMINAL_LOG_FILE_PATH', '\\\\LOG\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (15, 'FTP_APP_DIR', '\\\\APPLICATION\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (16, 'FTP_APP_Live_DIR', '\\\\APP\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (17, 'FTP_LOCAL_DIR', 'D:\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (18, 'FTP_XML_Live_DIR', '\\\\POS\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (19, 'Repot_DIR', 'D:\\\\report1.jrxml', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (20, 'FTP_Mirror_Live', '\\\\MIRROR\\\\', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (21, 'INFO_MESSAGE_FORMATE', 'INFO : ', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (22, 'ERROR_MESSAGE_FORMATE', 'ERROR : ', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);
INSERT INTO `GuardianPro`.`Config_parmeter` (`ID`, `Parameter`, `PValue`, `create_date`, `update_date`, `Encryption`, `User_ID`) VALUES (23, 'EXCEPTION_MESSAGE_FORMATE', 'EXCP : ', '2018-06-08 23:48:54', '2018-06-08 23:48:54', 0, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Terminal_template`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Terminal_template` (`ID`, `TName`, `Tdesc`, `User_ID`, `create_date`, `update_date`) VALUES (1, 'T1000', NULL, 1, '2018-05-23 22:26:38', '2018-05-23 22:26:38');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Download_method`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (1, 'S9000', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (2, 'S9010', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (3, 'S9090', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (4, 'P2000', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (5, 'UNIVER', '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`Download_method` (`ID`, `DName`, `create_date`, `update_date`) VALUES (6, 'NEW-UNIVER', '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Terminal_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Terminal_status` (`ID`, `Tstatus`, `Tdescrip`, `create_date`, `update_date`) VALUES (1, 'Active', NULL, '2018-05-23 22:26:38', '2018-05-23 22:26:38');
INSERT INTO `GuardianPro`.`Terminal_status` (`ID`, `Tstatus`, `Tdescrip`, `create_date`, `update_date`) VALUES (2, 'schedule', NULL, '2018-05-23 22:26:38', '2018-05-23 22:26:38');
INSERT INTO `GuardianPro`.`Terminal_status` (`ID`, `Tstatus`, `Tdescrip`, `create_date`, `update_date`) VALUES (3, 'suspended', NULL, '2018-05-23 22:26:38', '2018-05-23 22:26:38');
INSERT INTO `GuardianPro`.`Terminal_status` (`ID`, `Tstatus`, `Tdescrip`, `create_date`, `update_date`) VALUES (4, 'Outservice', NULL, '2018-05-23 22:26:38', '2018-05-23 22:26:38');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Terminal`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Terminal` (`ID`, `TID`, `Owner_Name`, `Merchant_Name`, `Shop_Name`, `Address`, `Contact_person`, `Tel_No`, `officeContact`, `officeTelNo`, `POS_SerialNo`, `Terminal_template_ID`, `create_date`, `update_date`, `Terminal_status_ID`, `schedule_start`, `schedule_end`) VALUES (1, '40000001', 'hamed', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2K264587', 1, '2018-05-23 22:26:38', '2018-05-23 22:26:38', 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Terminal_Group`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Terminal_Group` (`ID`, `Group_name`, `Group_desc`, `User_ID`, `create_date`, `update_date`) VALUES (1, 'hamed', NULL, 1, '2018-05-23 22:21:25', '2018-05-23 22:21:25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Tgroup_has_Gparameter`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Tgroup_has_Gparameter` (`ID`, `Terminal_Group_ID`, `Parameter_Group_ID`, `create_date`, `update_date`, `terminal_id`, `ACC_id`, `ISS_id`, `Card_id`, `XML_update`, `filename`, `file_length`) VALUES (1, 1, 1, '2018-05-23 22:31:07', '2018-05-23 22:31:07', NULL, NULL, NULL, NULL, 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`TGroup_has_terminal`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`TGroup_has_terminal` (`ID`, `Terminal_ID`, `Terminal_Group_ID`, `create_date`, `update_date`, `XML_update`, `DLL_name`) VALUES (1, 1, 1, '2018-05-23 22:21:25', '2018-05-23 22:21:25', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Parmeter_schema`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Parmeter_schema` (`ID`, `Terminal_ID`, `Acquirer_ID`, `Issuer_ID`, `CardRange_ID`) VALUES (1, '1', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Config_email`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Config_email` (`ID`, `email`, `create_date`, `update_date`, `User_ID`) VALUES (1, 'spectra.test.v1@gmail.com', '2018-06-24 14:25:13', '2018-06-24 14:25:13', 1);
INSERT INTO `GuardianPro`.`Config_email` (`ID`, `email`, `create_date`, `update_date`, `User_ID`) VALUES (2, 'Mostafa.morad49@gmail.com', '2018-06-24 14:25:24', '2018-06-24 14:25:24', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Menu`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (1, 'HomePage', 'Main.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (2, 'TerminalGroup', 'TerminalGroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (3, 'ParmeterGroup', 'ParameterGroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (4, 'ApplicationGroup', 'Appsgroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (5, 'AccessoryGroup', 'Accessorygroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (6, 'Admin', 'Main.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (7, 'LOG', 'Log.xhtml', 1);
INSERT INTO `GuardianPro`.`Menu` (`ID`, `name`, `Link`, `User_ID`) VALUES (8, 'Report', 'Reports.xhtml', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Menu_sub`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (1, 'Parmeter', 'Parameter.xhtml', 3);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (2, 'Application', 'Apps.xhtml', 4);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (3, 'Terminal', 'Terminal.xhtml', 2);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (4, 'TerminalTemplate', 'TerminalTemplate.xhtml', 2);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (5, 'Parts', 'Parts.xhtml', 2);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (6, 'Accessory', 'accessory.xhtml', 5);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (7, 'Config', 'Config.xhtml', 6);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (8, 'Users', 'profile.xhtml', 6);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (9, 'Roles', 'Roles.xhtml', 6);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (10, 'Groups', 'RGroups.xhtml', 6);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (11, 'Component', 'Component.xhtml', 6);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (12, 'Download Log', 'Log_download.xhtml', 7);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (13, 'SMTP Log', 'Log_SMTP.xhtml', 7);
INSERT INTO `GuardianPro`.`Menu_sub` (`ID`, `name`, `Link`, `Menu_ID`) VALUES (14, 'FTP Log', 'Log_ftp.xhtml', 7);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Action_bar`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Action_bar` (`ID`, `name`, `link`, `User_ID`) VALUES (1, 'Terminal Group', 'TerminalGroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Action_bar` (`ID`, `name`, `link`, `User_ID`) VALUES (2, 'Parmeter Group', 'ParameterGroup.xhtml', 1);
INSERT INTO `GuardianPro`.`Action_bar` (`ID`, `name`, `link`, `User_ID`) VALUES (3, 'Parameter', 'Parameter.xhtml', 1);
INSERT INTO `GuardianPro`.`Action_bar` (`ID`, `name`, `link`, `User_ID`) VALUES (4, 'Terminal', 'Terminal.xhtml', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Component_name`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (24, 'accessory_Create', 'accessory_Create', 'accessory_Create', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 24);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (25, 'accessory_Edit', 'accessory_Edit', 'accessory_Edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 25);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (26, 'accessorygroup_edit', 'accessorygroup_edit', 'accessorygroup_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 26);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (27, 'accessorygroup_remove', 'accessorygroup_remove', 'accessorygroup_remove', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 27);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (28, 'accessorygroup_submit', 'accessorygroup_submit', 'accessorygroup_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 28);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (29, 'accessorygroup_add_submit', 'accessorygroup_add_submit', 'accessorygroup_add_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 29);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (30, 'accessorygroup_select_one_menu', 'accessorygroup_select_one_menu', 'accessorygroup_select_one_menu', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 30);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (31, 'accessorygroup__select_aplicatin', 'accessorygroup__select_aplicatin', 'accessorygroup__select_aplicatin', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 31);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (32, 'accessorygroup__select_aplicatin_Group', 'accessorygroup__select_aplicatin_Group', 'accessorygroup__select_aplicatin_Group', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 32);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (33, 'accessorygroup__select_aplicatin_Group_submit', 'accessorygroup__select_aplicatin_Group_submit', 'accessorygroup__select_aplicatin_Group_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 33);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (34, 'apps_view', 'apps_view', 'apps_view', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 34);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (35, 'apps_multi_part', 'apps_multi_part', 'apps_multi_part', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 35);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (36, 'app_group', 'app_group', 'app_group', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 36);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (37, 'app_group_remove', 'app_group_remove', 'app_group_remove', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 37);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (38, 'app_group_submit', 'app_group_submit', 'app_group_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 38);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (39, 'app_groups_add', 'app_groups_add', 'app_groups_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 39);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (40, 'app_groups_select', 'app_groups_select', 'app_groups_select', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 40);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (41, 'app_groups_select_submit', 'app_groups_select_submit', 'app_groups_select_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 41);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (42, 'groups_edit', 'groups_edit', 'groups_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 42);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (43, 'groups_add', 'groups_add', 'groups_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 43);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (44, 'paramter_edit', 'paramter_edit', 'paramter_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 44);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (45, 'paramter_submit', 'paramter_submit', 'paramter_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 45);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (46, 'paramter_select', 'paramter_select', 'paramter_select', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 46);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (47, 'paramter_add', 'paramter_add', 'paramter_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 47);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (48, 'paramterGroup_form_edit', 'paramterGroup_form_edit', 'paramterGroup_form_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 48);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (49, 'paramtergroup_remove', 'paramtergroup_remove', 'paramtergroup_remove', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 49);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (50, 'paramtergroup_removegroup', 'paramtergroup_removegroup', 'paramtergroup_removegroup', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 50);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (51, 'paramtergroup_form_add', 'paramtergroup_form_add', 'paramtergroup_form_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 51);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (52, 'paramtergroup_add', 'paramtergroup_add', 'paramtergroup_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 52);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (53, 'paramtergroup_assign_group_form', 'paramtergroup_assign_group_form', 'paramtergroup_assign_group_form', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 53);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (54, 'paramtergroup_assign', 'paramtergroup_assign', 'paramtergroup_assign', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 54);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (55, 'paramter_type_remove', 'paramter_type_remove', 'paramter_type_remove', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 55);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (56, 'paramter_type_add', 'paramter_type_add', 'paramter_type_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 56);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (57, 'parts_edit', 'parts_edit', 'parts_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 57);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (58, 'parts_edit_submit', 'parts_edit_submit', 'parts_edit_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 58);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (59, 'parts_add', 'parts_add', 'parts_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 59);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (60, 'parts_add_submit', 'parts_add_submit', 'parts_add_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 60);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (61, 'termenal_edit', 'termenal_edit', 'termenal_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 61);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (62, 'termenal_edit_submit', 'termenal_edit_submit', 'termenal_edit_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 62);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (63, 'termenal_add', 'termenal_add', 'termenal_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 63);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (64, 'terminalgroup_edit_submit', 'terminalgroup_edit_submit', 'terminalgroup_edit_submit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 64);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (65, 'termenalgroup_add', 'termenalgroup_add', 'termenalgroup_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 65);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (66, 'termenalgroup_termenal_remove', 'termenalgroup_termenal_remove', 'termenalgroup_termenal_remove', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 66);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (67, 'termenalgroup_termenal_add', 'termenalgroup_termenal_add', 'termenalgroup_termenal_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 67);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (68, 'TerminalGroup_log', 'TerminalGroup log', 'TerminalGroup log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 68);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (69, 'Terminal_log', 'Terminal log', 'Terminal log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 69);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (70, 'TerminalTemplate_log', 'TerminalTemplate log', 'TerminalTemplate log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 70);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (71, 'Appsgroup_log', 'Appsgroup log', 'Appsgroup log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 71);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (72, 'Parameter_log', 'Parameter log', 'Parameter log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 72);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (73, 'ParameterGroup_log', 'ParameterGroup log', 'ParameterGroup log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 73);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (74, 'Apps_log', 'Apps log', 'Apps log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 74);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (75, 'Accessorygroup_log', 'Accessorygroup log', 'Accessorygroup log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 75);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (76, 'accessory_log', 'accessory log', 'accessory log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 76);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (78, 'Config_log', 'Config log', 'Config log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 78);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (79, 'paramter_configration', 'paramter_configration', 'paramter_configration', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 79);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (80, 'report_configration', 'report configration', 'report configration', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 80);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (81, 'report_paramter_configration', 'report paramter configration', 'report paramter configration', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 81);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (82, 'report_paramter_configration_add', 'report paramter configration_add', 'report paramter configration_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 82);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (83, 'email_configration', 'email configration', 'email configration', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 83);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (84, 'email_configration_add', 'email configration add', 'email configration add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 84);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (85, 'paramter_configration_add', 'paramter_configration_add', 'paramter_configration_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 85);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (86, 'profile_list', 'profile list', 'profile list', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 86);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (87, 'profile_add', 'profile add', 'profile add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 87);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (88, 'profile_log', 'profile_log', 'profile_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 88);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (89, 'roles_edit', 'roles edit', 'roles edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 89);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (90, 'roles_add', 'roles add', 'roles add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 90);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (91, 'roles_log', 'roles log', 'roles log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 91);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (92, 'RGroups_log', 'RGroups log', 'RGroups log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 92);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (93, 'component_edit', 'component edit', 'component edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 93);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (95, 'component_log', 'component_log', 'component_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 95);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (97, 'reports_edit', 'reports Edit', 'reports Edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 97);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (98, 'apps_edit', 'apps edit', 'apps_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 98);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (99, 'apps_add', 'apps add', 'apps_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 99);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (100, 'apps_group_log', 'apps group log', 'apps_group_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 100);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (101, 'component_of_role_edit', 'component of roles edit', 'component_of_role_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 101);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (102, 'component_of_role_log', 'component of roles log', 'component_of_role_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 102);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (103, 'config_edit', 'config edit', 'config_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 103);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (104, 'config_add', 'config add', 'config_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 104);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (105, 'config_list', 'config List', 'config_list', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 105);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (106, 'paramter_group_log', 'paramter group log', 'paramter_group_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 106);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (107, 'parts_log', 'parts log', 'parts_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 107);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (108, 'group_log', 'group log', 'group_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 108);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (109, 'TerminalTemplate_edit', 'TerminalTemplate edit', 'TerminalTemplate_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 109);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (110, 'TerminalTemplate_add', 'TerminalTemplate add', 'TerminalTemplate_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 110);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (111, 'TerminalTemplate_select', 'TerminalTemplate_select', 'TerminalTemplate_select', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 111);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (112, 'input_type_edit', 'input_type edit', 'input_type edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 112);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (113, 'input_type_add', 'input_type_add', 'input_type_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 113);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (114, 'input_type_log', 'input_type_log', 'input_type_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 114);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (115, 'role_of_component_edit', 'role_of_component edit', 'role_of_component_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 115);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (116, 'role_of_component_log', 'role_of_component_log', 'role_of_component_log', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 116);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (117, 'Configration_paramter', 'Configration paramter', 'Configration_paramter', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 117);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (118, 'report', 'report', 'report', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 118);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (119, 'report_paramter', 'report paramter', 'report_paramter', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 119);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (120, 'email_edit', 'email edit', 'email_edit', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 120);
INSERT INTO `GuardianPro`.`Component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES (121, 'email_add', 'email add', 'email_add', 0, '2018-04-12 23:48:54', '2018-04-12 23:48:54', 121);

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`Reports`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`Reports` (`ID`, `Report_DIR`, `Report_name`, `Report_SQL`, `User_ID`, `create_date`, `update_date`) VALUES (1, 'D:\\\\GuadianPro\\\\Core\\\\GardianPro\\\\files\\\\report1.jasper', 'report1', 'SELECT \'a\' as field1,\'a\'  as field2,\'a\'  as field3,\'a\'  as field4,\'a\'  as field5 FROM guardianpro.pages', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;


-- -----------------------------------------------------
-- Data for table `GuardianPro`.`R_parameter`
-- -----------------------------------------------------
START TRANSACTION;
USE `GuardianPro`;
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (1, 'parameter1', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (2, 'parameter2', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (3, 'parameter3', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (4, 'parameter4', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (5, 'parameter5', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (6, 'Header', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (7, 'Subheader', 'parameter1', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');
INSERT INTO `GuardianPro`.`R_parameter` (`ID`, `R_para`, `Para_value`, `Reports_ID`, `create_date`, `update_date`) VALUES (8, 'CHARACTER_ENCODING', 'UTF-8', 1, '2018-04-12 23:48:54', '2018-04-12 23:48:54');

COMMIT;

