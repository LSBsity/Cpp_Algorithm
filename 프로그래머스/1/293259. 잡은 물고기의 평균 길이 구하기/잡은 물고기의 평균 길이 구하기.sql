select
  round(avg(greatest(coalesce(fi.length, 10), 10)), 2) as average_length
from fish_info fi