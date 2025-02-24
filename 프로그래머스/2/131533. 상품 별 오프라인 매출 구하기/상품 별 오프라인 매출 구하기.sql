select p.product_code,
       sum(os.sales_amount * p.price) as sales
from offline_sale os
    join product p on os.product_id = p.product_id
group by p.product_code
order by sum(os.sales_amount * p.price) desc, p.product_code asc;

