select ed.id,
    (
        select count(*)
        from ecoli_data ed2
        where ed.id = ed2.parent_id
    ) as child_count
from ecoli_data ed
order by ed.id;
