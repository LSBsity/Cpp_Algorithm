select
  f.product_id,
  f.product_name,
  sum(f.price * o.amount) as total_sales
from food_product f
  join food_order o on f.product_id = o.product_id
where o.produce_date between '2022-05-01' and '2022-05-31'
group by f.product_id, f.product_name
order by sum(f.price * o.amount) desc, f.product_id