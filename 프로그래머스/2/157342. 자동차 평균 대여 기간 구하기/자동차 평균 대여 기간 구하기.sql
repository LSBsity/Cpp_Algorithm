select h.car_id,
       round(avg(datediff(h.end_date, h.start_date) + 1), 1) as average_duration
from car_rental_company_rental_history h
group by h.car_id
having avg(datediff(h.end_date, h.start_date) + 1) >= 7
order by average_duration desc, h.car_id desc;