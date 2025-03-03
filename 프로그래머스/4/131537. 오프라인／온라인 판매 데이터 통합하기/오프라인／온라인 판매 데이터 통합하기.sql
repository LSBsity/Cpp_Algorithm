select date_format(sales_date, '%Y-%m-%d') as sales_date,
       product_id,
       user_id,
       sales_amount
from (
    select date_format(ons.sales_date, '%Y-%m-%d') as sales_date,
       ons.product_id,
       ons.user_id,
       ons.sales_amount
    from online_sale ons
    where year(ons.sales_date) = 2022 and
          month(ons.sales_date) = 3
    
    union all
    
    select date_format(offs.sales_date, '%Y-%m-%d') as sales_date,
       offs.product_id,
       null as user_id,
       offs.sales_amount
    from offline_sale offs
    where year(offs.sales_date) = 2022 and
          month(offs.sales_date) = 3
) as total_sale
order by sales_date asc, product_id asc, user_id asc;