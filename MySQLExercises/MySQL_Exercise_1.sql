CREATE TABLE employees (
	employee_id INT (11) UNSIGNED NOT NULL,
	first_name VARCHAR(20),
	last_name VARCHAR(25) NOT NULL,
	email VARCHAR(25) NOT NULL,
	phone_number VARCHAR(20),
	hire_date DATE NOT NULL,
	job_id VARCHAR(10) NOT NULL,
	salary DECIMAL(8, 2) NOT NULL,
	commission_pct DECIMAL(2, 2),
	manager_id INT (11) UNSIGNED,
	department_id INT (11) UNSIGNED,
	PRIMARY KEY (employee_id)
	);
    
INSERT INTO employees
VALUES (
	100,
	'Steven',
	'King',
	'SKING',
	'515.123.4567',
	STR_TO_DATE('17-JUN-1987', '%d-%M-%Y'),
	'AD_PRES',
	24000,
	NULL,
	NULL,
	90
	);

INSERT INTO employees
VALUES (
	101,
	'Neena',
	'Kochhar',
	'NKOCHHAR',
	'515.123.4568',
	STR_TO_DATE('21-SEP-1989', '%d-%M-%Y'),
	'AD_VP',
	17000,
	NULL,
	100,
	90
	);
    select * from employees;
	select first_name as 'First Name', last_name as 'Last Name' from employees;
    select distinct first_name from employees;
    select * from employees order by first_name desc;
    SELECT first_name, last_name, salary, salary*.15 PF FROM employees;
    SELECT employee_id, first_name, last_name, salary FROM employees ORDER BY salary;
    SELECT SUM(salary) FROM employees;
	SELECT MAX(salary), MIN(salary) FROM employees;
    SELECT AVG(salary), COUNT(*) FROM employees;
    SELECT COUNT(*) FROM employees;
    SELECT COUNT(DISTINCT job_id) FROM employees;
    SELECT UPPER(first_name) FROM employees;
    SELECT SUBSTRING(first_name,1,3) FROM employees;
    SELECT 171*214+625 output;
    SELECT  CONCAT(first_name,' ', last_name) 'Employee Name' FROM employees;
    SELECT TRIM(first_name) FROM employees;
    SELECT first_name,last_name, LENGTH(first_name)+LENGTH(last_name)  'Length of  Names' FROM employees;
    SELECT *  FROM employees WHERE  first_name REGEXP  '[0-9]';
    SELECT employee_id, first_name FROM employees  LIMIT 10;
    SELECT first_name, last_name, round(salary/12,2) as 'Monthly Salary' FROM employees;