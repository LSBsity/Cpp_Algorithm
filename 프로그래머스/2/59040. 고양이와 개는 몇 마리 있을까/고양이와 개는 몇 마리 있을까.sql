select ai.animal_type, count(*) as count
from animal_ins ai
where ai.animal_type in ('Cat', 'Dog')
group by ai.animal_type
order by ai.animal_type asc;
