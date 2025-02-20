select ao.animal_id, ao.name
from animal_ins ai
    join animal_outs ao on ai.animal_id = ao.animal_id
order by timestampdiff(second, ai.datetime, ao.datetime) desc
limit 2;