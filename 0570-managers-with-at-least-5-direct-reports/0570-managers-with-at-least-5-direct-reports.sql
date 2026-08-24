# Write your MySQL query statement below
Select e1.name as name from Employee as e1 JOIN Employee as e2 where e1.id = e2.managerId GROUP BY e1.name,e1.id having count(e2.managerId) >= 5;