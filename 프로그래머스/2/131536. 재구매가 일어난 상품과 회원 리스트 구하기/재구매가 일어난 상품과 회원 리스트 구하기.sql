select distinct os1.user_id, os1.product_id
from online_sale os1
where product_id in (
    select os2.product_id
    from online_sale os2
    where os1.user_id = os2.user_id
    and os1.online_sale_id != os2.online_sale_id
)
order by os1.user_id asc, os1.product_id desc;