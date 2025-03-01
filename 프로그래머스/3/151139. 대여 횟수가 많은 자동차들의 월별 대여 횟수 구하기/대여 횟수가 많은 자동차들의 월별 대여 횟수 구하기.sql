select month(h.start_date) as month,
       h.car_id,
       count(*) as records
from car_rental_company_rental_history h
where year(h.start_date) = 2022
      and month(h.start_date) between 8 and 10
      and car_id in (
          select sub_h.car_id
          from car_rental_company_rental_history sub_h
          where year(sub_h.start_date) = 2022
                and month(sub_h.start_date) between 8 and 10
          group by sub_h.car_id
          having count(*) >= 5
      )
group by month(start_date), h.car_id
order by month asc, h.car_id desc;