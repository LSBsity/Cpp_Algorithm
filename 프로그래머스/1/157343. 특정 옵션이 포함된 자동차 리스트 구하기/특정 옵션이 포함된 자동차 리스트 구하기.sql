select
  c.car_id,
  c.car_type,
  c.daily_fee,
  c.options
from car_rental_company_car c
where c.options like '%네비게이션%'
order by c.car_id desc;