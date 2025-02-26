select fp.category,
       fp.price,
       fp.product_name
from food_product fp
where fp.category in ('과자', '국', '김치', '식용유') and
      fp.price = (
          select max(sfp.price)
          from food_product sfp
          where sfp.category = fp.category
      )
group by fp.category
order by fp.price desc;