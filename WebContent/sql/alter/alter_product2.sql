ALTER TABLE `shop`.`product` 
ADD COLUMN `product_image` VARCHAR(256) NOT NULL AFTER `product_price`,
ADD COLUMN `product_content` VARCHAR(45) NULL AFTER `product_image`,
ADD COLUMN `product_detail` TEXT NULL AFTER `product_content`;
