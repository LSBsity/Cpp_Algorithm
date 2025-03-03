select t.item_id,
       i.item_name,
       i.rarity
from item_info i
    join item_tree t on i.item_id = t.item_id
where t.parent_item_id in (
          select sub_i.item_id
          from item_info sub_i
          where sub_i.rarity = 'RARE'
      )
order by i.item_id desc;