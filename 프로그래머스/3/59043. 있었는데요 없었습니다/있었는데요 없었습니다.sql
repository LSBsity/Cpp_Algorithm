select
  ai.animal_id,
  ai.name
from animal_ins ai
  join animal_outs ao on ao.animal_id = ai.animal_id
where ai.datetime > ao.datetime
order by ai.datetime asc;