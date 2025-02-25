select ii.ingredient_type,
       sum(fh.total_order) as total_order
from first_half fh
    join icecream_info ii on fh.flavor = ii.flavor
group by ii.ingredient_type;
