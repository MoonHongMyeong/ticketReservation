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
DROP TABLE IF EXISTS `venues`;
CREATE TABLE `venues`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `manager_id` BIGINT NOT NULL,
    `type` VARCHAR(15) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    `homepage_url` VARCHAR(100) NULL,
    `address_name` VARCHAR(200) NOT NULL,
    `region_1depth_name` VARCHAR(50) NULL,
    `region_2depth_name` VARCHAR(50) NULL,
    `region_3depth_name` VARCHAR(50) NULL,
    `road_name` VARCHAR(100) NULL,
    `underground_yn` VARCHAR(2) NULL,
    `main_building_no` VARCHAR(20) NULL,
    `sub_building_no` VARCHAR(20) NULL,
    `building_name` VARCHAR(100) NULL,
    `zone_no` VARCHAR(5) NULL,
    `x` VARCHAR(50) NULL,
    `y` VARCHAR(50) NULL,
    created_date DATETIME NULL,
    modified_date DATETIME NULL
)