select hour(ao.datetime) as hour,
       count(ao.datetime) as count
from animal_outs ao
where hour(ao.datetime) between 9 and 19
group by hour(ao.datetime)
order by hour(ao.datetime) asc;