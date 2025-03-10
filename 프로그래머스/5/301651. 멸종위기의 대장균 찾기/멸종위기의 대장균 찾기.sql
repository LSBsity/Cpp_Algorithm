with recursive ecoli_generations as (
    select d.id,
           1 as generation
    from ecoli_data d
    where d.parent_id is null
    
    union all
    select e.id,
           eg.generation + 1
    from ecoli_data e
        join ecoli_generations eg on e.parent_id = eg.id
)

select count(*) as count,
       eg.generation
from ecoli_generations eg
    left join ecoli_data e on eg.id = e.parent_id
where e.parent_id is null
group by eg.generation
order by eg.generation