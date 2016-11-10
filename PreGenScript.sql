-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Address` (
  `idAddress` INT NOT NULL COMMENT '',
  `line1` VARCHAR(45) NOT NULL COMMENT '',
  `line2` VARCHAR(45) NULL COMMENT '',
  `town` VARCHAR(45) NOT NULL COMMENT '',
  `postcode` VARCHAR(6) NOT NULL COMMENT '',
  PRIMARY KEY (`idAddress`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `firstName` VARCHAR(45) NOT NULL COMMENT '',
  `lastName` VARCHAR(45) NOT NULL COMMENT '',
  `phoneNum` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  `Address_idAddress` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCustomer`)  COMMENT '',
  UNIQUE INDEX `idCustomer_UNIQUE` (`idCustomer` ASC)  COMMENT '',
  INDEX `fk_Customer_Address1_idx` (`Address_idAddress` ASC)  COMMENT '',
  CONSTRAINT `fk_Customer_Address1`
    FOREIGN KEY (`Address_idAddress`)
    REFERENCES `mydb`.`Address` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BillingDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BillingDetails` (
  `idBillingDetails` INT NOT NULL COMMENT '',
  `cardno` VARCHAR(13) NOT NULL COMMENT '',
  `sortcode` VARCHAR(6) NOT NULL COMMENT '',
  `Address_idAddress` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idBillingDetails`)  COMMENT '',
  INDEX `fk_BillingDetails_Address1_idx` (`Address_idAddress` ASC)  COMMENT '',
  CONSTRAINT `fk_BillingDetails_Address1`
    FOREIGN KEY (`Address_idAddress`)
    REFERENCES `mydb`.`Address` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CustomerOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CustomerOrder` (
  `idCustomerOrder` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `status` VARCHAR(45) NOT NULL COMMENT '',
  `datePlaced` VARCHAR(45) NULL COMMENT '',
  `dateDispatched` VARCHAR(45) NULL COMMENT '',
  `Customer_idCustomer` INT NOT NULL COMMENT '',
  `BillingDetails_idBillingDetails` INT NOT NULL COMMENT '',
  `Address_idAddress` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCustomerOrder`)  COMMENT '',
  INDEX `fk_CustomerOrder_Customer1_idx` (`Customer_idCustomer` ASC)  COMMENT '',
  INDEX `fk_CustomerOrder_BillingDetails1_idx` (`BillingDetails_idBillingDetails` ASC)  COMMENT '',
  INDEX `fk_CustomerOrder_Address1_idx` (`Address_idAddress` ASC)  COMMENT '',
  CONSTRAINT `fk_CustomerOrder_Customer1`
    FOREIGN KEY (`Customer_idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CustomerOrder_BillingDetails1`
    FOREIGN KEY (`BillingDetails_idBillingDetails`)
    REFERENCES `mydb`.`BillingDetails` (`idBillingDetails`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CustomerOrder_Address1`
    FOREIGN KEY (`Address_idAddress`)
    REFERENCES `mydb`.`Address` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Product` (
  `idProductGroup` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `description` VARCHAR(45) NOT NULL COMMENT '',
  `images` VARCHAR(45) NULL COMMENT '',
  `price` FLOAT NOT NULL COMMENT '',
  `category` VARCHAR(45) NULL COMMENT '',
  `stockLevel` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idProductGroup`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrderLine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrderLine` (
  `CustomerOrder_idCustomerOrder` INT NOT NULL COMMENT '',
  `Product_idProductGroup` INT NOT NULL COMMENT '',
  `quantity` INT NOT NULL COMMENT '',
  `salePrice` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`CustomerOrder_idCustomerOrder`, `Product_idProductGroup`)  COMMENT '',
  INDEX `fk_ProductItem_CustomerOrder1_idx` (`CustomerOrder_idCustomerOrder` ASC)  COMMENT '',
  INDEX `fk_OrderLine_Product1_idx` (`Product_idProductGroup` ASC)  COMMENT '',
  CONSTRAINT `fk_ProductItem_CustomerOrder1`
    FOREIGN KEY (`CustomerOrder_idCustomerOrder`)
    REFERENCES `mydb`.`CustomerOrder` (`idCustomerOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderLine_Product1`
    FOREIGN KEY (`Product_idProductGroup`)
    REFERENCES `mydb`.`Product` (`idProductGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Supplier` (
  `idSupplier` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idSupplier`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `fistName` VARCHAR(45) NOT NULL COMMENT '',
  `lastName` VARCHAR(45) NOT NULL COMMENT '',
  `userName` VARCHAR(45) NOT NULL COMMENT '',
  `password` VARCHAR(45) NOT NULL COMMENT '',
  `title` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idEmployee`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`supplierOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`supplierOrder` (
  `idsupplierOrder` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `dateOrdered` VARCHAR(45) NOT NULL COMMENT '',
  `dateReceived` VARCHAR(45) NULL COMMENT '',
  `Supplier_idSupplier` INT NOT NULL COMMENT '',
  `Employee_idEmployee` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idsupplierOrder`)  COMMENT '',
  INDEX `fk_supplierOrder_Supplier1_idx` (`Supplier_idSupplier` ASC)  COMMENT '',
  INDEX `fk_supplierOrder_Employee1_idx` (`Employee_idEmployee` ASC)  COMMENT '',
  CONSTRAINT `fk_supplierOrder_Supplier1`
    FOREIGN KEY (`Supplier_idSupplier`)
    REFERENCES `mydb`.`Supplier` (`idSupplier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplierOrder_Employee1`
    FOREIGN KEY (`Employee_idEmployee`)
    REFERENCES `mydb`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wishlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`wishlist` (
  `Customer_idCustomer` INT NOT NULL COMMENT '',
  `Product_idProductGroup` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Customer_idCustomer`, `Product_idProductGroup`)  COMMENT '',
  INDEX `fk_Customer_has_ProductGroup_Customer1_idx` (`Customer_idCustomer` ASC)  COMMENT '',
  INDEX `fk_wishlist_Product1_idx` (`Product_idProductGroup` ASC)  COMMENT '',
  CONSTRAINT `fk_Customer_has_ProductGroup_Customer1`
    FOREIGN KEY (`Customer_idCustomer`)
    REFERENCES `mydb`.`Customer` (`idCustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wishlist_Product1`
    FOREIGN KEY (`Product_idProductGroup`)
    REFERENCES `mydb`.`Product` (`idProductGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Product_has_Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Product_has_Supplier` (
  `Product_idProductGroup` INT NOT NULL COMMENT '',
  `Supplier_idSupplier` INT NOT NULL COMMENT '',
  `supplierPrice` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`Product_idProductGroup`, `Supplier_idSupplier`)  COMMENT '',
  INDEX `fk_Product_has_Supplier_Supplier1_idx` (`Supplier_idSupplier` ASC)  COMMENT '',
  INDEX `fk_Product_has_Supplier_Product1_idx` (`Product_idProductGroup` ASC)  COMMENT '',
  CONSTRAINT `fk_Product_has_Supplier_Product1`
    FOREIGN KEY (`Product_idProductGroup`)
    REFERENCES `mydb`.`Product` (`idProductGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Supplier_Supplier1`
    FOREIGN KEY (`Supplier_idSupplier`)
    REFERENCES `mydb`.`Supplier` (`idSupplier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`supplierOrder_has_Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`supplierOrder_has_Product` (
  `supplierOrder_idsupplierOrder` INT NOT NULL COMMENT '',
  `Product_idProductGroup` INT NOT NULL COMMENT '',
  `quantiyOrderd` INT NOT NULL COMMENT '',
  `quantityReceived` INT NULL COMMENT '',
  `PricePerUnit` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`supplierOrder_idsupplierOrder`, `Product_idProductGroup`)  COMMENT '',
  INDEX `fk_supplierOrder_has_Product_Product1_idx` (`Product_idProductGroup` ASC)  COMMENT '',
  INDEX `fk_supplierOrder_has_Product_supplierOrder1_idx` (`supplierOrder_idsupplierOrder` ASC)  COMMENT '',
  CONSTRAINT `fk_supplierOrder_has_Product_supplierOrder1`
    FOREIGN KEY (`supplierOrder_idsupplierOrder`)
    REFERENCES `mydb`.`supplierOrder` (`idsupplierOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplierOrder_has_Product_Product1`
    FOREIGN KEY (`Product_idProductGroup`)
    REFERENCES `mydb`.`Product` (`idProductGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
