select d.id, 
       (select count(sub_d.parent_id) 
        from ecoli_data sub_d 
        where sub_d.parent_id = d.id) as child_count
from ecoli_data d
order by d.id asc;