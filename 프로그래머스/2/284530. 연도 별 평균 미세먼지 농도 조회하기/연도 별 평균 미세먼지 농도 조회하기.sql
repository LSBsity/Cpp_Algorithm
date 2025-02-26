select year(ap.ym) as year,
       round(avg(ap.pm_val1), 2) as 'pm10',
       round(avg(ap.pm_val2), 2) as 'pm2.5'
from air_pollution ap
where ap.location2 = '수원'
group by year(ap.ym)
order by year asc;