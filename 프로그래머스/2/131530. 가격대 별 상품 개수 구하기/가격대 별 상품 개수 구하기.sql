select
  floor(p.price / 10000) * 10000 as price_group,
  count(p.product_id) as products
from product p
group by floor(p.price / 10000) * 10000
order by price_group;