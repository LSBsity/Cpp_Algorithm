select
  p.category,
  max(p.price) as max_price,
  (
      select p2.product_name
      from food_product p2
      where p2.price = max(p.price) and p.category = p2.category
  ) as product_name
from food_product p
where p.category in ('과자', '국', '김치', '식용유')
group by p.category
order by max_price desc