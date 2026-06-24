select
  h.flavor
from first_half h
join (
  select
    j.flavor,
    sum(j.total_order) total_sum
  from july j
  group by j.flavor
) s on h.flavor = s.flavor
group by h.flavor
order by sum(h.total_order) + s.total_sum desc
limit 3;
  