select
  ii.item_id,
  ii.item_name,
  ii.rarity
from item_info ii
  join item_tree it on ii.item_id = it.item_id
  join item_info ii2 on it.parent_item_id = ii2.item_id
where ii2.rarity = 'RARE'
order by ii.item_id desc;