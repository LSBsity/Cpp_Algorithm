select cc.car_id,
       cc.car_type,
       cc.daily_fee,
       cc.options
from car_rental_company_car cc
where cc.options like '%네비게이션%'
order by cc.car_id desc;