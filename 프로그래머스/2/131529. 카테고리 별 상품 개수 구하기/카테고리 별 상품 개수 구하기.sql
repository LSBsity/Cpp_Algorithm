select
  left(p.product_code, 2) as category,
  count(p.product_id) as products
from product p
group by LEFt(p.product_code, 2)
order by category asc;