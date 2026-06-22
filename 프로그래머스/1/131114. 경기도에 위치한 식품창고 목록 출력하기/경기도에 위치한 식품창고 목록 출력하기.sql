select
  w.warehouse_id,
  w.warehouse_name,
  w.address,
  coalesce(w.freezer_yn, 'N') as freezer_yn
from food_warehouse w
where w.address like '경기도%'
order by w.warehouse_id asc;
