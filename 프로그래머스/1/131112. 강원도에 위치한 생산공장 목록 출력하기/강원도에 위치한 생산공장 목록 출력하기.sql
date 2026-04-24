select
  f.factory_id,
  f.factory_name,
  f.address
from food_factory f
where f.address like '강원도%'
order by f.factory_id;