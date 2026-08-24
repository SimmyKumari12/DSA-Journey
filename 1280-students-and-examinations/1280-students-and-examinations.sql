# Write your MySQL query statement below
Select st.student_id,st.student_name,su.subject_name,count(e.subject_name) as attended_exams
from Students st
cross join Subjects su
left join Examinations e
ON st.student_id = e.student_id AND e.subject_name = su.subject_name
GROUP BY st.student_id,su.subject_name,st.student_name
order by st.student_id,su.subject_name;