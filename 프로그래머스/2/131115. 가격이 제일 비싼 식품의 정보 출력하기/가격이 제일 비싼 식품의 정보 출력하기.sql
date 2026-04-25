select
  p.product_id,
  p.product_name,
  p.product_cd,
  p.category,
  p.price
from food_product p
where p.price = (
    select max(p2.price)
    from food_product p2
);