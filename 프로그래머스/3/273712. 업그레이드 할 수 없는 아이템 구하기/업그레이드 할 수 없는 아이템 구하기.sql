select i.item_id,
       i.item_name,
       i.rarity
from item_tree t
    join item_info i on t.item_id = i.item_id
where not exists (
    select 1
    from item_tree sub_t
    where sub_t.parent_item_id = t.item_id
)
order by i.item_id desc;