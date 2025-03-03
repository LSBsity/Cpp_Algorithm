select d.id
from ecoli_data d
where d.parent_id in (
    select sub_sub_d.id
    from ecoli_data sub_sub_d
    where sub_sub_d.parent_id in (
        select sub_d.id
        from ecoli_data sub_d
        where sub_d.parent_id is null
    )
)
order by d.id asc;
    
