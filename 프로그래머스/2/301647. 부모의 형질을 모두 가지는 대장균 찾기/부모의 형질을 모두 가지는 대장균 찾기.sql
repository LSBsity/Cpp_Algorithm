select d.id,
       d.genotype,
       (select sub_d.genotype
       from ecoli_data sub_d
       where sub_d.id = d.parent_id) as parent_genotype
from ecoli_data d
where d.genotype | (
    select sub_d.genotype
    from ecoli_data sub_d
    where sub_d.id = d.parent_id
) = d.genotype
order by d.id asc;