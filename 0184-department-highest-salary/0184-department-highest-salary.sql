# Write your MySQL query statement below
SELECT d.name as Department, e.name as Employee,e.salary as Salary
from Employee e
INNER JOIN Department d
ON e.departmentId = d.id
WHERE e.salary = (
    Select max(e0.salary)
    from Employee e0
    where e0.departmentId = e.departmentId
);