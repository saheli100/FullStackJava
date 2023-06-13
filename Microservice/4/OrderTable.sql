CREATE TABLE `order_table` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  PRIMARY KEY (`order_id`)
);
CREATE TABLE `customer_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

select * from order_table;
select * from customer_table;