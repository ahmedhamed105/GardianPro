CREATE TABLE `gardianpro`.`user` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Middle_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(100) NOT NULL,
  `National_ID_ID` INT NOT NULL,
  `Birth_Data_ID` INT NOT NULL,
  `Profile_Data_ID` INT NOT NULL,
  `Email` VARCHAR(300) NULL,
  PRIMARY KEY (`ID`));
