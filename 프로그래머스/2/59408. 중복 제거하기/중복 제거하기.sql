select count(distinct ai.name) as count
from animal_ins ai
where ai.name is not null;