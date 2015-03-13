ALTER TABLE `shop`.`order_info` 
ADD COLUMN `payment_check` TINYINT(1) NOT NULL AFTER `payment_type`,
ADD COLUMN `shipping_status` VARCHAR(20) NULL AFTER `shipping_message`;
