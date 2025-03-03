select h.history_id,
       floor(
        c.daily_fee * (datediff(h.end_date, h.start_date) + 1) 
        * (1 - coalesce(
            case 
                when datediff(h.end_date, h.start_date) + 1 >= 90 then 
                    (select discount_rate FROM car_rental_company_discount_plan 
                     where car_type = '트럭' AND duration_type = '90일 이상') / 100
                when datediff(h.end_date, h.start_date) + 1 >= 30 then 
                    (select discount_rate FROM car_rental_company_discount_plan 
                     where car_type = '트럭' AND duration_type = '30일 이상') / 100
                when datediff(h.end_date, h.start_date) + 1 >= 7 then 
                    (select discount_rate FROM car_rental_company_discount_plan 
                     where car_type = '트럭' AND duration_type = '7일 이상') / 100
                else 0 
            end, 0)
        ) 
    ) as fee

from car_rental_company_car c
    join car_rental_company_rental_history h on c.car_id = h.car_id
    join car_rental_company_discount_plan p on c.car_type = p.car_type
where c.car_type = '트럭'
group by h.history_id
order by fee desc, h.history_id desc;