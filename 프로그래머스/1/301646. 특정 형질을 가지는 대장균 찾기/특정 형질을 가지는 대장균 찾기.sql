with not_in_two as (
    select d.genotype
    from ecoli_data d
    where not d.genotype >> 1 & 1
)

select count(*) as count
from not_in_two w
where w.genotype & 1 or w.genotype >> 2 & 1
