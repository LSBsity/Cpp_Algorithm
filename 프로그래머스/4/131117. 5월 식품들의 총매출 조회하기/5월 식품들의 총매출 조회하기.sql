select fo.product_id,
       fp.product_name,
       sum(fo.amount * fp.price) as total_sales
from food_order fo
    join food_product fp on fo.product_id = fp.product_id
where year(fo.produce_date) = 2022 and
      month(fo.produce_date) = 5
group by fo.product_id, fp.product_name
order by total_sales desc, fo.product_id asc;