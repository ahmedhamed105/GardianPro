CREATE TABLE `gardianpro`.`national_id` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Namtional_ID` INT NOT NULL,
  `Front_image` VARCHAR(300) NULL,
  `back_image` VARCHAR(300) NULL,
  `date_issue` DATE NULL,
  `place_Issue` VARCHAR(300) NULL,
  `religion_ID` INT NOT NULL,
  `Military_status_ID` INT NOT NULL,
  `Army_Area_ID` INT NOT NULL,
  PRIMARY KEY (`id`));
