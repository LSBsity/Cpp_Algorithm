select
  ai.animal_id,
  ai.name
from animal_ins ai
where ai.name like '%el%' and animal_type = 'Dog'
order by ai.name asc, ai.animal_id asc