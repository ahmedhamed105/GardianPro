CREATE TABLE `gardianpro`.`national_id_has_marital_status_has_address` (
  `National_ID_has_Marital_status_National_ID_ID` INT NOT NULL,
  `National_ID_has_Marital_status_Marital_status_ID` INT NOT NULL,
  `Address_ID` INT NOT NULL,
  PRIMARY KEY (`National_ID_has_Marital_status_National_ID_ID`, `National_ID_has_Marital_status_Marital_status_ID`, `Address_ID`));
