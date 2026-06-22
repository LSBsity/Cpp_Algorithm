select
  ai.animal_id
from animal_ins ai
where ai.name is not null
order by ai.animal_id asc;