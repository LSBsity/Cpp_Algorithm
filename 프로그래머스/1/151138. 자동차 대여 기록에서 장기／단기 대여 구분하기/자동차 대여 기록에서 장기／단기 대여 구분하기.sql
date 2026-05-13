select
  h.history_id,
  h.car_id,
  h.start_date,
  h.end_date,
  case
    when DATEDIFF(h.end_date, h.start_date) + 1 >= 30 then '장기 대여'
    else '단기 대여'
  end as rent_type 
from car_rental_company_rental_history h
where start_date between '2022-09-01' and '2022-09-30'
order by h.history_id desc;