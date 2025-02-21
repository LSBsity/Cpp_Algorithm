select sum(ii.price) as total_price
from item_info ii
where ii.rarity = 'LEGEND';