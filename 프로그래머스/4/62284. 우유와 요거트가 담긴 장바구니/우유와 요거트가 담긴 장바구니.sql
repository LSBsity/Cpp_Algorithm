select p.cart_id
from cart_products p
where p.cart_id in (
    select sub_p.cart_id
    from cart_products sub_p
    where sub_p.name in ('Milk', 'Yogurt')
    group by sub_p.cart_id
    having count(distinct sub_p.name) = 2
)
group by p.cart_id