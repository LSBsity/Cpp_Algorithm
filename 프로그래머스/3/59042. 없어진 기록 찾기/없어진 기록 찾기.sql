select ao.animal_id,
       ao.name
from animal_outs ao
    left join animal_ins ai on ao.animal_id = ai.animal_id
where ao.animal_id is not null and
      ai.animal_id is null
order by ai.animal_id asc;