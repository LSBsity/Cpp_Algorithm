select
  distinct cp.cart_id
from cart_products cp
where
  exists (select 1 from cart_products p where cp.cart_id = p.cart_id and p.name = 'Milk') and
  exists (select 1 from cart_products p where cp.cart_id = p.cart_id and p.name = 'Yogurt')