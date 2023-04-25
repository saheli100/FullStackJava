UPDATE person set age=28 where age=88 or first_name='kelly';

select first_name,last_name,age from person where age<50 and first_name like '%lly';
select last_name,age from person order by age asc;
select * from person order by age desc;

select * from person order by age desc limit 2;

select 3+6 as 'sum of 3 and 6';
select department_id,count(employee_id) as employee_count from employees groupby employee_id having employee_count=2;
select count(age) from person;
select avg(age) from person;
select sum(age) from person;
select min(age) from person;
select max(age) from person;