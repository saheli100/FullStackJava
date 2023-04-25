create database hr;
show databases;
use mydb;
drop table person;
create table person(person_id integer not null auto_increment,
					first_name varchar(45) not null,
                    last_name varchar(45) not null,
                    age integer,
                    primary key(person_id)) engine=InnoDB;
                    
alter table  person rename to person1;

create table countries(country_id smallint unsigned not null,
					country_name varchar(45) not null,
                    region_id varchar(45) not null,
                    primary key(country_id));
                    
show tables;

alter table person add age integer(3) not null;

select * from person;

create database temp_db;
create database mydb;

use mydb;

create table temp_table(temp_id integer not null primary key,
					temp_whatever varchar(255));
                    

select * from employees;
desc employees;

create table student(student_id integer primary key auto_increment,
					first_name varchar(255),
                    last_name varchar(255),
                    age integer,
                    grade varchar(45));
                    
select * from temp_db.temp_table;
select * from mydb.student;
select * from mydb.person;

drop table student;

insert into mydb.student(first_name, last_name, age, grade) values('mao', 'asada', 19, 5);
insert into mydb.person(first_name, last_name, age) values('sang', 'shin', 88);

insert into mydb.person(first_name, last_name, age) values('kelly', 'jones', 22),
('jack', 'kenedy', 56);

select * from person;
show databases;
use mydb;

UPDATE person set age=28 where age=88 or first_name='kelly';
create table employees(employee_id integer not null primary key auto_increment,
					first_name varchar(255) not null ,
                    last_name varchar(255) not null ,
                    salary decimal(7,2) not null,
                    index(name));
drop table employees;
insert into employees (name ,salary) values ('angle', '5500.00'),('nancy', '5000.00'),('jones', '4000.00');
desc employess;
select * from employees where name regexp 'jones|mary';
select * from employees where name regexp '^jones';
select * from employees where name regexp 'e$';

select distinct salary from employees;
drop table employees;


set @my_var1=10,@may_var2=20;
set @my_var3='sang',@may_var4='shin';
select upper(@my_var3,@my_var4),lower(@my_var3,@my_var4);

