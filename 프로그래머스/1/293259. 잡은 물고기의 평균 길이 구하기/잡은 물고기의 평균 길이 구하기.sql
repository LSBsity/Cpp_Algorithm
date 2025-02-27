select round(avg(coalesce(fi.length, 10)), 2) as average_length
from fish_info fi;