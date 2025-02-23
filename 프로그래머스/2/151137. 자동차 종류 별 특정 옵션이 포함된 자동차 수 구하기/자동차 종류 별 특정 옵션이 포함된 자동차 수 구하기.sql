select crcr.car_type,
       count(crcr.options) as cars
from car_rental_company_car crcr
where crcr.options like '%통풍시트%' or crcr.options like '%열선시트%' or crcr.options like '%가죽시트%'
group by crcr.car_type
order by crcr.car_type asc;