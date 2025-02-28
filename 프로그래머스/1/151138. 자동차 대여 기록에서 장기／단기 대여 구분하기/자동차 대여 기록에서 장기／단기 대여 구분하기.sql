select h.history_id,
       h.car_id,
       date_format(h.start_date, '%Y-%m-%d') as start_date,
       date_format(h.end_date, '%Y-%m-%d') as end_date,
       (case
            when year(h.start_date) = 2022 and month(h.start_date) = 9 and
                 datediff(h.end_date, h.start_date) + 1 >= 30
            then '장기 대여'
            else '단기 대여'
       end) as rent_type
from car_rental_company_rental_history h
WHERE YEAR(h.start_date) = 2022 AND MONTH(h.start_date) = 9
order by h.history_id desc;