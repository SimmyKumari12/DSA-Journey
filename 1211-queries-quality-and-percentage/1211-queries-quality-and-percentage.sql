# Write your MySQL query statement below
-- SELECT COUNT(*)
-- FROM Queries
-- WHERE rating < 3
-- GROUP BY query_name;

-- SELECT count(*)
-- from Queries
-- GROUP BY query_name;

SELECT query_name, round(avg(rating/position),2) as quality, round(sum(rating < 3) * 100 / count(*),2) as poor_query_percentage
FROM Queries 
WHERE query_name is not null
GROUP BY query_name;
