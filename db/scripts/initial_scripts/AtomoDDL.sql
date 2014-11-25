SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `atomo`;

CREATE SCHEMA IF NOT EXISTS `atomo` DEFAULT CHARACTER SET utf8 ;
USE `atomo` ;


-- -----------------------------------------------------
-- Table `atomo`.`participanttype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`participanttype` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all possible participant types.';


-- -----------------------------------------------------
-- Table `atomo`.`participant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`participant` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `idparticipanttype` VARCHAR(64) NOT NULL,
  `datecreated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateupdated` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all transaction participants.';


-- -----------------------------------------------------
-- Table `atomo`.`binarydatatype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`binarydatatype` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all possible binary data types.';


-- -----------------------------------------------------
-- Table `atomo`.`binarydata`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`binarydata` (
  `id` VARCHAR(8) NOT NULL,
  `binaryvalue` LONGBLOB NOT NULL,
  `idbinarydatatype` VARCHAR(64) NOT NULL,
  `datecreated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateupdated` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_binarydata_idbinarydatatype`
    FOREIGN KEY (`idbinarydatatype`)
    REFERENCES `atomo`.`binarydatatype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all binary data needed in Atomo system. Value in column IDBINARYDATATYPE determins the type of binary data.';

CREATE INDEX `ix_binarydata_idbinarydatatype` ON `atomo`.`binarydata` (`idbinarydatatype` ASC);


-- -----------------------------------------------------
-- Table `atomo`.`transactionstatustype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`transactionstatustype` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all possible transaction statuses.';


-- -----------------------------------------------------
-- Table `atomo`.`transactiontype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`transactiontype` (
  `id` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all transaction types.';


-- -----------------------------------------------------
-- Table `atomo`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`transaction` (
  `id` VARCHAR(8) NOT NULL,
  `idtransactiontype` VARCHAR(64) NOT NULL,
  `idparticipantsource` VARCHAR(8) NOT NULL,
  `idparticipanttarget` VARCHAR(8) NOT NULL,
  `data` VARCHAR(1024) NULL,
  `idbinarydata` VARCHAR(8) NULL,
  `idtransactionstatustype` VARCHAR(64) NOT NULL DEFAULT 'PENDING',
  `idparenttransaction` VARCHAR(8) NULL,
  `datecreated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateupdated` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_transaction_idtransactiontype`
    FOREIGN KEY (`idtransactiontype`)
    REFERENCES `atomo`.`transactiontype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_idparticipantsource`
    FOREIGN KEY (`idparticipantsource`)
    REFERENCES `atomo`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_idparticipanttarget`
    FOREIGN KEY (`idparticipanttarget`)
    REFERENCES `atomo`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_idbinarydata`
    FOREIGN KEY (`idbinarydata`)
    REFERENCES `atomo`.`binarydata` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_idtransactionstatustype`
    FOREIGN KEY (`idtransactionstatustype`)
    REFERENCES `atomo`.`transactionstatustype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_idparenttransaction`
    FOREIGN KEY (`idparenttransaction`)
    REFERENCES `atomo`.`transaction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table stores all transactions.';

CREATE INDEX `ix_transaction_idparticipantsource` ON `atomo`.`transaction` (`idparticipantsource` ASC);
CREATE INDEX `ix_transaction_idparticipanttarget` ON `atomo`.`transaction` (`idparticipanttarget` ASC);
CREATE INDEX `ix_transaction_idbinarydata` ON `atomo`.`transaction` (`idbinarydata` ASC);
CREATE INDEX `ix_transaction_idtransactiontype` ON `atomo`.`transaction` (`idtransactiontype` ASC);
CREATE INDEX `ix_transaction_idtransactionstatustype` ON `atomo`.`transaction` (`idtransactionstatustype` ASC);
CREATE INDEX `ix_transaction_idparenttransaction` ON `atomo`.`transaction` (`idparenttransaction` ASC);


-- -----------------------------------------------------
-- Table `atomo`.`dbversion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atomo`.`dbversion` (
  `iddbversion` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `versionnumber` VARCHAR(32) NOT NULL,
  `description` VARCHAR(16000) NULL,
  `startdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enddate` TIMESTAMP NULL,
  PRIMARY KEY (`iddbversion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'This table is for internal usage only. It stores information about all DB changes, in order to be able to easily find out which is the current version on which system.';

-- -----------------------------------------------------
-- Procedures `start_dbversion` and `end_dbversion`
-- -----------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `start_dbversion` (IN pversionnumber VARCHAR(32), IN pdescription VARCHAR(16000))
BEGIN
	INSERT INTO dbversion (versionnumber, description)
	VALUES (pversionnumber, pdescription);
END$$

CREATE PROCEDURE `end_dbversion` (IN pversionnumber VARCHAR(32))
BEGIN
	DECLARE lmaxiddbversion INT;

	SELECT MAX(iddbversion)
	INTO lmaxiddbversion
	FROM dbversion
	WHERE versionnumber = pversionnumber;

	UPDATE dbversion
	SET enddate = CURRENT_TIMESTAMP
	WHERE versionnumber = pversionnumber
	AND iddbversion = lmaxiddbversion;
END$$

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
