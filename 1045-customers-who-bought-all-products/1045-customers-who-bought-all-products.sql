# Write your MySQL query statement below
SELECT customer_id
from Customer
GROUP BY customer_id
HAVING count(DISTINCT product_key) = (SELECT count(*) from Product);