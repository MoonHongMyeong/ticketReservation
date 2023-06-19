DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`(
        `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    	`password`	VARCHAR(100) NOT NULL,
    	`email` VARCHAR(50) NOT NULL,
    	`name`	VARCHAR(20)	NOT NULL,
    	`company_name` VARCHAR(100) NOT NULL,
    	`business_reg_no` VARCHAR(50) NOT NULL,
    	`phone` VARCHAR(15) NOT NULL,
    	`created_date`	DATETIME	NULL,
    	`modified_date`	DATETIME	NULL,
    	`role`	VARCHAR(15)	NOT NULL
);
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    `created_date` DATETIME NULL,
    `modified_date` DATETIME NULL
);