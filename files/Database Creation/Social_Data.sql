CREATE TABLE `gardianpro`.`social_data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `facebook_URL` VARCHAR(300) NULL,
  `User_ID` INT NOT NULL,
  `Social_type_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `User_ID`));