select
  ons.sales_date,
  ons.product_id,
  ons.user_id,
  ons.sales_amount
from online_sale ons
where ons.sales_date >= '2022-03-01' and
  ons.sales_date < '2022-04-01'
  
union 

select
  offs.sales_date,
  offs.product_id,
  NULL,
  offs.sales_amount
from offline_sale offs
where offs.sales_date >= '2022-03-01' and
  offs.sales_date < '2022-04-01'
  
order by sales_date, product_id, user_id;