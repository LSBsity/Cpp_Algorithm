select ff.factory_id, ff.factory_name, ff.address
from food_factory ff
where ff.address LIKE '강원도%'
order by ff.factory_id;