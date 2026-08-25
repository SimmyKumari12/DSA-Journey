# Write your MySQL query statement belo

SELECT r.contest_id, round((count(r.user_id) * 100) / (select count(*) from users) , 2)as percentage
FROM Register r
JOIN Users u
ON u.user_id = r.user_id
GROUP BY contest_id
ORDER BY percentage desc, contest_id;