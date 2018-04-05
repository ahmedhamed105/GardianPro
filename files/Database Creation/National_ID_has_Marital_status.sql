CREATE TABLE `gardianpro`.`national_id_has_marital_status` (
  `National_ID_ID` INT NOT NULL,
  `Marital_status_ID` INT NOT NULL,
  `no_Childern` VARCHAR(45) NULL,
  `Wife_name` VARCHAR(300) NULL,
  `National_ID_has_Marital_statuscol` VARCHAR(300) NULL,
  PRIMARY KEY (`National_ID_ID`, `Marital_status_ID`));
