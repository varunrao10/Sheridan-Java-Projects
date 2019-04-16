/*CREATE database BookingSys;*/
DROP TABLE `bookingsys`.`booking`;
DROP TABLE `bookingsys`.`client`;
DROP TABLE `bookingsys`.`hall`;

CREATE TABLE `bookingsys`.`client` (
  `ClientID` INT NOT NULL,
  `ClientName` VARCHAR(45) NOT NULL,
  `CreditCard` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ClientID`));
  
  ALTER TABLE `bookingsys`.`client` 
ADD UNIQUE INDEX `ClientName_UNIQUE` (`ClientName` ASC) VISIBLE;
;
  CREATE TABLE `bookingsys`.`hall` (
  `HallID` INT NOT NULL,
  `HallName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`HallID`));
  
  ALTER TABLE `bookingsys`.`hall` 
ADD UNIQUE INDEX `HallName_UNIQUE` (`HallName` ASC) VISIBLE;
;

  CREATE TABLE `bookingsys`.`booking` (
  `BookingID` INT NOT NULL,
  `HallID` INT NOT NULL,
  `ClientID` INT NOT NULL,
  `BookingDate` DATETIME NOT NULL,
  PRIMARY KEY (`BookingID`));
  
  ALTER TABLE `bookingsys`.`booking` 
ADD INDEX `HallID_idx` (`HallID` ASC) VISIBLE,
ADD INDEX `ClientID_idx` (`ClientID` ASC) VISIBLE;
;

ALTER TABLE `bookingsys`.`booking`  ADD UNIQUE `unique_booking`(`HallID`, `ClientID`, `BookingDate`);


ALTER TABLE `bookingsys`.`booking` 
ADD CONSTRAINT `HallID`
  FOREIGN KEY (`HallID`)
  REFERENCES `bookingsys`.`hall` (`HallID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `ClientID`
  FOREIGN KEY (`ClientID`)
  REFERENCES `bookingsys`.`client` (`ClientID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


