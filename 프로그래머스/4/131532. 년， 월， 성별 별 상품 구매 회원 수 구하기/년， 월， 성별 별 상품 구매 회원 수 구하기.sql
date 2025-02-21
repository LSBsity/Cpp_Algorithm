select year(os.sales_date) as year,
       month(os.sales_date) as month,
       ui.gender as gender,
       count(distinct os.user_id) as users
from online_sale os
    join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by year(os.sales_date), month(os.sales_date), ui.gender
order by year(os.sales_date) asc, month(os.sales_date) asc, ui.gender asc;
