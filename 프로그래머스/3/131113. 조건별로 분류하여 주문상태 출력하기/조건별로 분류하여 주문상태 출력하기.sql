select
  o.order_id,
  o.product_id,
  out_date,
  case
    when o.out_date <= '2022-05-01' then '출고완료'
    when o.out_date > '2022-05-01' then '출고대기'
    else '출고미정'
  end as '출고여부'
from food_order o
order by o.order_id asc;