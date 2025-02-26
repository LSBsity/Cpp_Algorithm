select fh.flavor
from first_half fh
    join icecream_info ii on fh.flavor = ii.flavor
where ii.ingredient_type = 'fruit_based'
group by fh.flavor
having sum(fh.total_order) >= 3000
order by sum(fh.total_order) desc;
