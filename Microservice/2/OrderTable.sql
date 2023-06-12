CREATE TABLE `order_table` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  PRIMARY KEY (`order_id`)
);

select * from order_table;