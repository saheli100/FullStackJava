CREATE TABLE `movies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `movie_id` int NOT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `roles_movie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
  );
  INSERT INTO `roles_movie` VALUES (1,'ROLE_EMPLOYEE');
  select * from roles_movie;
  CREATE TABLE `movie_users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
ALTER TABLE movieuser_movieroles ADD COLUMN `movie_name` varchar(255) DEFAULT NULL ;
UPDATE movieuser_movieroles t1
INNER JOIN movies t2 ON t1.movie_users_id = t2.id 
SET t1.movie_name = t2.movie_name;
CREATE TABLE `movieuser_movieroles` (
  `movie_users_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`movie_users_id`,`role_id`),
    FOREIGN KEY (`role_id`) REFERENCES `roles_movie` (`id`),
    FOREIGN KEY (`movie_users_id`) REFERENCES `movie_users` (`id`)
) ;
use hr;
drop table movieuser_movieroles;
select * from movieuser_movieroles;
select * from movie_users;
select * from movies;

delete from movies;

