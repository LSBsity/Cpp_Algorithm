select sum(ii.price) as TOTAL_PRICE
from item_info ii
where ii.rarity = 'LEGEND'