SELECT A.machine_id,Round(Avg(B.timestamp - A.timestamp),3) AS processing_time
FROM Activity A
JOIN Activity B
ON A.machine_id = B.machine_id
AND A.process_id = B.process_id
AND A.activity_type = 'start' 
AND B.activity_type = 'end'
GROUP BY machine_id;