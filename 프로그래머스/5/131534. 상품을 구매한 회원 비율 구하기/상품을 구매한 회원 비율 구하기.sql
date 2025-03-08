select year(s.sales_date) as year,
       month(s.sales_date) as month,
       count(distinct s.user_id) as purchased_users,
       round(count(distinct s.user_id) / 
             (
                 select count(*)
                 from user_info sub_i
                 where year(sub_i.joined) = 2021
             ), 1) as puchased_ratio
from user_info i
    join online_sale s on i.user_id = s.user_id
where year(i.joined) = 2021
group by year, month
order by year asc, month asc;

# select *
# from user_info i
#     join online_sale s on i.user_id = s.user_id
# where year(i.joined) = 2021
# order by i.user_id asc;