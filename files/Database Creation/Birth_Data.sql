CREATE TABLE `gardianpro`.`birth_data` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Birth_Date` DATETIME NOT NULL,
  `Birth_Cert` VARCHAR(500) NULL,
  `Birth_place` VARCHAR(500) NULL,
  `City_ID` INT NOT NULL,
  `Country_ID` INT NOT NULL,
  PRIMARY KEY (`ID`));
