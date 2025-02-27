select d.id,
       (case
            when d.size_of_colony > 1000 then 'HIGH'
            when d.size_of_colony > 100 then 'MEDIUM'
            else 'LOW'
       end) as size
from ecoli_data d
order by d.id asc;
