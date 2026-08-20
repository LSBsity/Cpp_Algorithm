select
  year(os.sales_date) as year,
  month(os.sales_date) as month,
  count(distinct ui.user_id) as purchased_users,
  round(count(distinct ui.user_id) /
  (select count(user_id) from user_info where year(joined) = 2021), 1) as puchased_ratio
from user_info ui
  join online_sale os on ui.user_id = os.user_id
where ui.user_id in (
    select user_id
    from user_info
    where year(joined) = 2021
)
group by year(os.sales_date), month(os.sales_date)
order by year asc, month asc;