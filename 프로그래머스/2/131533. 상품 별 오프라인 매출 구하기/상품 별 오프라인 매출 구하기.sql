select
  p.product_code,
  sum(p.price * s.sales_amount) as sales
from product p
  join offline_sale s on s.product_id = p.product_id
group by p.product_code
order by sales desc, p.product_code asc;