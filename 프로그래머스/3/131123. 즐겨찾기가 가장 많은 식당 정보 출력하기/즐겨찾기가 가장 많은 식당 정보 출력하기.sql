select
  i.food_type,
  i.rest_id,
  i.rest_name,
  i.favorites
from rest_info i
where i.favorites = (
    select max(i2.favorites)
    from rest_info i2
    where i2.food_type = i.food_type
)
order by i.food_type desc;