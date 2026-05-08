select
  h.car_id,
  max(
    case
    when '2022-10-16' between h.start_date and h.end_date then '대여 중'
    else '대여 가능'
  end) as 'availability'
from car_rental_company_rental_history h
group by h.car_id
order by h.car_id desc;