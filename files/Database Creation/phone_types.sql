CREATE TABLE `gardianpro`.`phone_types` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `tele_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `tele_type_UNIQUE` (`tele_type` ASC));
