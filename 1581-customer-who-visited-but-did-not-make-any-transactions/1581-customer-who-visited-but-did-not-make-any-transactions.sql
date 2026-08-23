# Write your MySQL query statement below
SELECT v.customer_id,count(*) as count_no_trans
from visits as v
LEFT JOIN Transactions as t
ON v.visit_id = t.visit_id
WHERE t.visit_id is null
GROUP BY v.customer_id;