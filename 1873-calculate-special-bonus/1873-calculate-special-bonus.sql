# Write your MySQL query statement below
SELECT employee_id, IF(employee_id % 2 = 0 OR name like 'm%',0,salary) AS bonus
FROM employees
Order by employee_id;