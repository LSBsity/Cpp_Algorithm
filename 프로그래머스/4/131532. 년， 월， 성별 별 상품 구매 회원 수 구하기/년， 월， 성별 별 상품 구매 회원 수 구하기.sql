select
  year(s.sales_date) as year,
  month(s.sales_date) as month,
  i.gender,
  count(distinct s.user_id) as users
from user_info i
  join online_sale s on i.user_id = s.user_id
where i.gender is not null
group by year(s.sales_date), month(s.sales_date), i.gender
order by year(s.sales_date) asc, month(s.sales_date) asc, i.gender asc;
