# Write your MySQL query statement below
SELECT teacher_id, count(DISTINCT subject_id) as cnt
from Teacher
GROUP BY teacher_id;