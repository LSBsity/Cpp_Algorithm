select
  p1.id,
  p1.name,
  p1.host_id
from places p1
where p1.host_id in (
  select p2.host_id
  from places p2
  group by p2.host_id
  having count(p2.host_id) >= 2
)
order by p1.id asc;

