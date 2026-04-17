select round(avg(rcc.daily_fee), 0) as AVERAGE_FEE
from car_rental_company_car rcc
where rcc.car_type = 'SUV';