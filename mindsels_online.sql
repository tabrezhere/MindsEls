SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mindsels_online
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mindsels_online` DEFAULT CHARACTER SET utf8 ;

-- Schema mindsels_online
-- -----------------------------------------------------
USE `mindsels_online` ;

-- -----------------------------------------------------
-- Table `mindsels_online`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `Firstname` VARCHAR(200) NULL,
  `MiddleName` VARCHAR(200) NULL,
  `Lastname` VARCHAR(200) NULL,
  `password` VARCHAR(200) NOT NULL,
  `Address1` VARCHAR(200) NULL,
  `Address2` VARCHAR(200) NULL,
  `City` VARCHAR(200) NULL,
  `State` VARCHAR(200) NULL,
  `Createat` DATETIME NULL,
  `Updatedat` DATETIME NULL,
  `Deleted` BIGINT NULL,
  `hasher` varchar(255) DEFAULT NULL,
  `salt` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`user_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`user_login` (
  `id` BIGINT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `phone_number` DECIMAL(10,0) NULL,
  `verified` TINYINT(1) NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC),
  INDEX `fk_user_login_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_login_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mindsels_online`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Context`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Context` (
  `id` INT NOT NULL,
  `context` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `context_UNIQUE` (`context` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`organization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `activated` TINYINT(1) NULL DEFAULT 0,
  `paid` TINYINT(1) NULL DEFAULT 0,
  `deleted` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`campus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`campus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `campus_name` VARCHAR(45) NULL,
  `organization_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_campus_organization1_idx` (`organization_id` ASC),
  CONSTRAINT `fk_campus_organization1`
    FOREIGN KEY (`organization_id`)
    REFERENCES `mindsels_online`.`organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`User_context`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`User_context` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `context_id` INT NOT NULL,
  `campus_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_context_user1_idx` (`user_id` ASC),
  INDEX `fk_user_context_context1_idx` (`context_id` ASC),
  INDEX `fk_user_context_campus1_idx` (`campus_id` ASC),
  CONSTRAINT `fk_user_context_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mindsels_online`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_context1`
    FOREIGN KEY (`context_id`)
    REFERENCES `mindsels_online`.`Context` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_campus1`
    FOREIGN KEY (`campus_id`)
    REFERENCES `mindsels_online`.`campus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Capability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Capability` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `capability_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `create` TINYINT(1) NULL DEFAULT 0,
  `delete` TINYINT(1) NULL DEFAULT 0,
  `update` TINYINT(1) NULL DEFAULT 0,
  `read` TINYINT(1) NULL DEFAULT 0,
  `role_id` INT NOT NULL,
  `capability_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_permission_role1_idx` (`role_id` ASC),
  INDEX `fk_permission_capability1_idx` (`capability_id` ASC),
  CONSTRAINT `fk_permission_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `mindsels_online`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permission_capability1`
    FOREIGN KEY (`capability_id`)
    REFERENCES `mindsels_online`.`Capability` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`User_context_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`User_context_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_context_id` BIGINT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_user_context_has_role_role1_idx` (`role_id` ASC),
  INDEX `fk_user_context_has_role_user_context1_idx` (`user_context_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_context_has_role_user_context1`
    FOREIGN KEY (`user_context_id`)
    REFERENCES `mindsels_online`.`User_context` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_has_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `mindsels_online`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`term_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`term_type` (
  `id` INT NOT NULL,
  `term_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`term` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `deleted` TINYINT(1) NULL,
  `term_type_id` INT NOT NULL,
  `campus_id` INT NOT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_term_term_type1_idx` (`term_type_id` ASC),
  INDEX `fk_term_campus1_idx` (`campus_id` ASC),
  CONSTRAINT `fk_term_term_type1`
    FOREIGN KEY (`term_type_id`)
    REFERENCES `mindsels_online`.`term_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_term_campus1`
    FOREIGN KEY (`campus_id`)
    REFERENCES `mindsels_online`.`campus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`class` (
  `id` VARCHAR(45) NOT NULL,
  `campus_id` INT NOT NULL,
  `term_id` INT NOT NULL,
  `class_name` VARCHAR(45) NULL,
  `deleted` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_class_campus1_idx` (`campus_id` ASC),
  INDEX `fk_class_term1_idx` (`term_id` ASC),
  CONSTRAINT `fk_class_campus1`
    FOREIGN KEY (`campus_id`)
    REFERENCES `mindsels_online`.`campus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_term1`
    FOREIGN KEY (`term_id`)
    REFERENCES `mindsels_online`.`term` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindselsdb`.`Student_Details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Student_Details` (
  `id` BIGINT NOT NULL,
  `user_context_id` BIGINT NOT NULL,
  `Studentadminno` VARCHAR(50) NULL,
  INDEX `fk_student_user_context1_idx` (`user_context_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_student_user_context1`
    FOREIGN KEY (`user_context_id`)
    REFERENCES `mindsels_online`.`User_context` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`user_term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`user_term` (
  `id` INT NOT NULL,
  `user_context_id` INT NOT NULL,
  `term_id` INT NOT NULL,
  `active` TINYINT(1) NULL,
  `deleted` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_enrollment_term1_idx` (`term_id` ASC),
  INDEX `fk_user_enrollment_user_context1_idx` (`user_context_id` ASC),
  CONSTRAINT `fk_user_enrollment_user_context1`
    FOREIGN KEY (`user_context_id`)
    REFERENCES `mindselsdb`.`Student_Details` (`user_context_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_enrollment_term1`
    FOREIGN KEY (`term_id`)
    REFERENCES `mindsels_online`.`term` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`student_class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`student_class` (
  `id` INT NULL,
  `user_context_id` INT NOT NULL,
  `class_id` VARCHAR(45) NOT NULL,
  INDEX `fk_user_context_has_class_class1_idx` (`class_id` ASC),
  INDEX `fk_user_context_has_class_user_context1_idx` (`user_context_id` ASC),
  CONSTRAINT `fk_user_context_has_class_user_context1`
    FOREIGN KEY (`user_context_id`)
    REFERENCES `mindselsdb`.`Student_Details` (`user_context_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_context_has_class_class1`
    FOREIGN KEY (`class_id`)
    REFERENCES `mindsels_online`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`test_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`test_type` (
  `id` INT NOT NULL,
  `test_type` VARCHAR(45) NULL,
  `campus_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_test_type_campus1_idx` (`campus_id` ASC),
  CONSTRAINT `fk_test_type_campus1`
    FOREIGN KEY (`campus_id`)
    REFERENCES `mindsels_online`.`campus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`course` (
  `id` INT NOT NULL,
  `course_name` VARCHAR(45) NULL,
  `deleted` VARCHAR(45) NULL,
  `class_id` VARCHAR(45) NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_class1_idx` (`class_id` ASC),
  INDEX `fk_course_course1_idx` (`course_id` ASC),
  CONSTRAINT `fk_course_class1`
    FOREIGN KEY (`class_id`)
    REFERENCES `mindsels_online`.`class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `mindsels_online`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`assignment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`assignment` (
  `id` INT NOT NULL,
  `assignment_name` VARCHAR(45) NULL,
  `max_score` DECIMAL(10,0) NULL,
  `sequence` INT NULL,
  `due_date` DATETIME NULL,
  `remindar_date` DATETIME NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_assignment_course1_idx` (`course_id` ASC),
  CONSTRAINT `fk_assignment_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `mindsels_online`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindselsdb`.`Staff_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Staff_details` (
  `id` BIGINT NOT NULL,
  `user_contextid` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Staffdetails_Context_idx` (`user_contextid` ASC),
  CONSTRAINT `FK_Staffdetails_Context`
    FOREIGN KEY (`user_contextid`)
    REFERENCES `mindsels_online`.`User_context` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`course_staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`course_staff` (
  `id` INT NOT NULL,
  `role_name` VARCHAR(45) NULL,
  `course_id` INT NOT NULL,
  `Staff_details_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_instructor_course1_idx` (`course_id` ASC),
  INDEX `fk_course_staff_Staff_details1_idx` (`Staff_details_id` ASC),
  CONSTRAINT `fk_course_instructor_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `mindsels_online`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_staff_Staff_details1`
    FOREIGN KEY (`Staff_details_id`)
    REFERENCES `mindselsdb`.`Staff_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`assignment_grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`assignment_grade` (
  `id` INT NOT NULL,
  `score` DECIMAL(10,0) NULL,
  `grade` DECIMAL(10,0) NULL,
  `assignment_id` INT NOT NULL,
  `user_context_role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_assignment_grade_assignment1_idx` (`assignment_id` ASC),
  INDEX `fk_assignment_grade_user_context_role1_idx` (`user_context_role_id` ASC),
  CONSTRAINT `fk_assignment_grade_assignment1`
    FOREIGN KEY (`assignment_id`)
    REFERENCES `mindsels_online`.`assignment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_assignment_grade_user_context_role1`
    FOREIGN KEY (`user_context_role_id`)
    REFERENCES `mindsels_online`.`User_context_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Vehicle_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Vehicle_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Vehicle_type` VARCHAR(120) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Vehicle_Details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Vehicle_Details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Vehicle_no` VARCHAR(120) NULL,
  `Vehicle_code` VARCHAR(120) NULL,
  `No_of_Seat` VARCHAR(120) NULL,
  `Maximum_capacity` VARCHAR(120) NULL,
  `insurance` VARCHAR(120) NULL,
  `tax_remitted` VARCHAR(120) NULL,
  `permit` VARCHAR(120) NULL,
  `staus` VARCHAR(120) NULL,
  `Vehicle_type` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `Fk_Vehicletype_idx` (`Vehicle_type` ASC),
  CONSTRAINT `Fk_Vehicletype`
    FOREIGN KEY (`Vehicle_type`)
    REFERENCES `mindsels_online`.`Vehicle_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Route_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Route_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Route_Name` VARCHAR(120) NULL,
  `No_of_Stops` INT NULL,
  `Vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Route_details_Vehicle_details1_idx` (`Vehicle_id` ASC),
  CONSTRAINT `fk_Route_details_Vehicle_details1`
    FOREIGN KEY (`Vehicle_id`)
    REFERENCES `mindsels_online`.`Vehicle_Details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`Stop_Details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`Stop_Details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Stop_Name` VARCHAR(120) NULL,
  `fare` VARCHAR(120) NULL,
  `Arival_Mrng` TIME NULL,
  `Departure_Mrng` TIME NULL,
  `Arival_Evng` TIME NULL,
  `Departure_Evng` TIME NULL,
  `Route_details_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Stop_Details_Route_details1_idx` (`Route_details_id` ASC),
  CONSTRAINT `fk_Stop_Details_Route_details1`
    FOREIGN KEY (`Route_details_id`)
    REFERENCES `mindsels_online`.`Route_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mindsels_online`.`center`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`center` (
  `id` MEDIUMINT(9) NOT NULL AUTO_INCREMENT,
  `centername` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mindsels_online`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `customername` VARCHAR(45) NULL DEFAULT NULL,
  `centerid_fk` MEDIUMINT(9) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`centerid_fk` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`centerid_fk`)
    REFERENCES `mindsels_online`.`center` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mindsels_online`.`organizaion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mindsels_online`.`organizaion` (
  `id` VARCHAR(50) NOT NULL,
  `orgname` VARCHAR(45) NULL DEFAULT NULL,
  `orglocation` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

