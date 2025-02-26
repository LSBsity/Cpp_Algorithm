select ri.food_type,
       ri.rest_id,
       ri.rest_name,
       ri.favorites
from rest_info ri
where ri.favorites = (
    select max(sub_ri.favorites)
    from rest_info sub_ri
    where ri.food_type = sub_ri.food_type
)
group by ri.food_type
order by ri.food_type desc;
