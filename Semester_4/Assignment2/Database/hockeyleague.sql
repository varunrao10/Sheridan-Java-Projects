CREATE database hockeyleague;
DROP TABLE `hockeyleague`.`team`;
DROP TABLE `hockeyleague`.`player`;

CREATE TABLE `hockeyleague`.`team` (
  `TeamID` INT NOT NULL,
  `TeamName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`TeamID`),
  UNIQUE INDEX `TeamName_UNIQUE` (`TeamName` ASC) VISIBLE);
  
  CREATE TABLE `hockeyleague`.`player` (
  `PlayerID` INT NOT NULL,
  `PlayerName` VARCHAR(50) NOT NULL,
  `PlayerAddress` VARCHAR(50) NOT NULL,
  `PlayerRole` VARCHAR(50) NOT NULL,  
  `Active` boolean NOT NULL,
  `TeamID` VARCHAR(45) NULL,
  PRIMARY KEY (`PlayerID`),
  UNIQUE INDEX `PlayerName_UNIQUE` (`PlayerName` ASC) VISIBLE);

INSERT INTO `hockeyleague`.`team`(TeamID,TeamName) VALUES(1,'RED');
INSERT INTO `hockeyleague`.`team`(TeamID,TeamName) VALUES(2,'BLUE');
INSERT INTO `hockeyleague`.`team`(TeamID,TeamName) VALUES(3,'GREEN');
INSERT INTO `hockeyleague`.`team`(TeamID,TeamName) VALUES(4,'YELLOW');