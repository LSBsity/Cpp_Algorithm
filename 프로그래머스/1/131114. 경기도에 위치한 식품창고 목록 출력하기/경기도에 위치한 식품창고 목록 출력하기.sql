select fw.warehouse_id, fw.warehouse_name, fw.address, coalesce(fw.freezer_yn, 'N') as freezer_yn
from food_warehouse fw
where fw.address like '경기도%'
order by fw.warehouse_id;
