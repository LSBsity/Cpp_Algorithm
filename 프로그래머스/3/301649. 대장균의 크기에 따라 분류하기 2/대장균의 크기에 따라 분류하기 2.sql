select
  ed.id,
  case ntile(4) over (order by ed.size_of_colony desc)
    when 1 then 'CRITICAL'
    when 2 then 'HIGH'
    when 3 then 'MEDIUM'
    else 'LOW'
  end as 'colony_name'
from ecoli_data ed
order by ed.id;