select
    ed.id,
    case 
      when ed.size_of_colony >= 1000 then 'HIGH'
      when ed.size_of_colony > 100 then 'MEDIUM'
      else 'LOW'
    end as size
from ecoli_data ed
order by ed.id;