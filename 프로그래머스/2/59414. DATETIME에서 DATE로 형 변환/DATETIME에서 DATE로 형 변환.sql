select ai.animal_id, ai.name, date_format(ai.datetime, '%Y-%m-%d') as '날짜'
from animal_ins ai
order by ai.animal_id asc;
