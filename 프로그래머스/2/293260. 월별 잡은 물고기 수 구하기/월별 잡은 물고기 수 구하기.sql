select
  count(i.id) as fish_count,
  month(i.time) as month
from fish_info i
group by month(i.time)
order by month asc;