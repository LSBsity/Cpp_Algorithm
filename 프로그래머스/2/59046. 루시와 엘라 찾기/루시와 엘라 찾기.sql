select ai.animal_id, ai.name, ai.sex_upon_intake
from animal_ins ai
where ai.name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
order by ai.animal_id