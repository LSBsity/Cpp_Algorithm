select
  year(ap.ym) as 'YEAR',
  round(avg(ap.pm_val1), 2) as 'PM10',
  round(avg(ap.pm_val2), 2) as 'PM2.5'
from air_pollution ap
where ap.location2 = '수원'
group by year(ap.ym)
order by year(ap.ym) asc;