select
  month(h.start_date) as month,
  h.car_id as car_id,
  count(h.history_id) as records
from car_rental_company_rental_history h
join (
  select
    car_id
  from car_rental_company_rental_history
  where start_date between '2022-08-01' and '2022-10-31'
  group by car_id
  having count(history_id) >= 5
) as h2 on h.car_id = h2.car_id
where h.start_date between '2022-08-01' and '2022-10-31'
group by month(h.start_date), h.car_id
order by month(h.start_date) asc, h.car_id desc;




