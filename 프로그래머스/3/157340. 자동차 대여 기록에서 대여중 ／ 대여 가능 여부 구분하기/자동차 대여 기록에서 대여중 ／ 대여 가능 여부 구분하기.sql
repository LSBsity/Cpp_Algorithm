select distinct h.car_id,
       (case
            when exists (
                select 1
                from car_rental_company_rental_history sub_h
                where sub_h.car_id = h.car_id and
                      '2022-10-16' between sub_h.start_date and sub_h.end_date
            )
            then '대여중'
            else '대여 가능'
       end) as availability
from car_rental_company_rental_history h
order by h.car_id desc;