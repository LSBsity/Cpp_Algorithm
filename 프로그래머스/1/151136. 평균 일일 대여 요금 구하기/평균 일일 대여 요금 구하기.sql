select round(avg(cc.daily_fee), 0) as average_fee
from car_rental_company_car cc
where cc.car_type = 'SUV';
