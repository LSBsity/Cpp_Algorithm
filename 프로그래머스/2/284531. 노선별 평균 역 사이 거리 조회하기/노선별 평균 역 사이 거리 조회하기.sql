select
  d.route as ROUTE,
  concat(round(sum(d.d_between_dist), 1), 'km') as TOTAL_DISTANCE,
  concat(round(avg(d.d_between_dist), 2), 'km') as AVERAGE_DISTANCE
from subway_distance d
group by d.route
order by sum(d.d_between_dist) DESC;