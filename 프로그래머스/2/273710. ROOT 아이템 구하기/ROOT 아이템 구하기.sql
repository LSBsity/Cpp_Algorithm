select ii.item_id,
       ii.item_name
from item_info ii
    join item_tree it on ii.item_id = it.item_id
where it.parent_item_id is null
order by ii.item_id asc;