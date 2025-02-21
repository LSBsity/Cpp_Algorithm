select substring(p.product_code, 1, 2) as category,
       count(p.product_id) as products
from product p
group by substring(p.product_code, 1, 2)
