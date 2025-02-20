select ai.animal_id, ai.name
from animal_ins ai
where ai.name LIKE '%el%'
    and ai.animal_type = 'Dog'
order by ai.name;