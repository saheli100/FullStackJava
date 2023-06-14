

DROP TABLE IF EXISTS `users`;

DROP TABLE IF EXISTS `authorities`;


/*!40101 SET @saved_cs_client     = @@character_set_client */;


/*!50503 SET character_set_client = utf8mb4 */;


CREATE TABLE `users` (


  `id` bigint NOT NULL AUTO_INCREMENT,


  `email` varchar(255) DEFAULT NULL,


  `name` varchar(255) DEFAULT NULL,


  `password` varchar(255) DEFAULT NULL,


  `username` varchar(255) DEFAULT NULL,


  PRIMARY KEY (`id`),


  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),


  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)


) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
DROP TABLE IF EXISTS `roles`;


/*!40101 SET @saved_cs_client     = @@character_set_client */;


/*!50503 SET character_set_client = utf8mb4 */;


CREATE TABLE `roles` (


  `id` bigint NOT NULL AUTO_INCREMENT,


  `name` varchar(60) DEFAULT NULL,


  PRIMARY KEY (`id`)


) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
DROP TABLE IF EXISTS `user_roles`;


/*!40101 SET @saved_cs_client     = @@character_set_client */;


/*!50503 SET character_set_client = utf8mb4 */;


CREATE TABLE `user_roles` (


  `user_id` bigint NOT NULL,


  `role_id` bigint NOT NULL,


  PRIMARY KEY (`user_id`,`role_id`),


  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),


  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),


  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)


) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table todo(todo_id integer primary key,todo_name varchar(255),is_completed boolean);

select * from todo;
delete from todo;
use hr;
select * from user_table;
select * from todo_table;

CREATE TABLE `users` ( `username` varchar(50) NOT NULL, `password` varchar(50) NOT NULL, `enabled` tinyint NOT NULL, PRIMARY KEY (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
select * from users;
select * from authorities;
CREATE TABLE `authorities` ( `username` varchar(50) NOT NULL, `authority` varchar(50) NOT NULL, UNIQUE KEY `authorities_idx_1` (`username`,`authority`), CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` VALUES ('john','ROLE_EMPLOYEE'), ('mary','ROLE_EMPLOYEE'), ('mary','ROLE_MANAGER'), ('susan','ROLE_EMPLOYEE'), ('susan','ROLE_MANAGER'), ('susan','ROLE_ADMIN');

INSERT INTO `users` VALUES ('john','{noop}test123',1), ('mary','{noop}test123',1), ('susan','{noop}test123',1);
