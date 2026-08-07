select
  ai.animal_id,
  ai.name
from animal_ins ai
  join animal_outs ao on ai.animal_id = ao.animal_id
where ao.datetime is not null
order by datediff(ao.datetime, ai.datetime) desc
limit 2;