ALTER TABLE `shop`.`product` 
ADD COLUMN `product_category` VARCHAR(20) NULL AFTER `product_detail`,
ADD COLUMN `product_stock` INT NULL AFTER `product_category`;
