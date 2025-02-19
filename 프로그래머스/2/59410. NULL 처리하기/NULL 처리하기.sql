select ai.animal_type,coalesce(ai.name, 'No name') as name, ai.sex_upon_intake
from animal_ins ai
order by ai.animal_id asc;