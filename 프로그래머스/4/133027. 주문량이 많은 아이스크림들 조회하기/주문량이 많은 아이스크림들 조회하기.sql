select flavor 
from (
    select sum(fh.total_order) + sum(j.total_order) as sum,
       fh.flavor
    from first_half fh
        join july j on fh.flavor = j.flavor
    group by fh.flavor
    order by sum desc
    limit 3
) as result;

