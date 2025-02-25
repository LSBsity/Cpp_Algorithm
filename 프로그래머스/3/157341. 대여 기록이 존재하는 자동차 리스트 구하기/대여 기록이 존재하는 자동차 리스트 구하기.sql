select distinct rh.car_id
from car_rental_company_rental_history rh
    join car_rental_company_car cc on rh.car_id = cc.car_id
where month(rh.start_date) = 10 and 
      cc.car_type = '세단'
order by rh.car_id desc;