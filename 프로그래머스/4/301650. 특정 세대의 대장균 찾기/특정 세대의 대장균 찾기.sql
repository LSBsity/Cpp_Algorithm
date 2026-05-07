select ed1.id
from ecoli_data ed1
  join ecoli_data ed2 on ed1.parent_id = ed2.id
  join ecoli_data ed3 on ed2.parent_id = ed3.id
 where ed3.parent_id is null
order by ed1.id;