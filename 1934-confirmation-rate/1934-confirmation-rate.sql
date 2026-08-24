# Write your MySQL query statement below
SELECT s.user_id,COALESCE(round(avg(c.action = 'confirmed'),2),0) as confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id
ORDER BY confirmation_rate;