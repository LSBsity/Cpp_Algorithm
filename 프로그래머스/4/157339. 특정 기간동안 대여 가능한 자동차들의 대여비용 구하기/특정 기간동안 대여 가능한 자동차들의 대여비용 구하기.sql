select
  c.car_id,
  c.car_type,
  (c.daily_fee * 30) * (1 - (p.discount_rate * 0.01)) as fee
from car_rental_company_car c
  join car_rental_company_discount_plan p on c.car_type = p.car_type and p.duration_type = '30일 이상'
where
  (c.daily_fee * 30) * (1 - (p.discount_rate * 0.01)) between 500000 and 1999999
    and
  c.car_id not in (
    select s.car_id
    from car_rental_company_rental_history s
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
      and s.car_id = c.car_id
  )
order by fee desc, c.car_type asc, c.car_id desc;