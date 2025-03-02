select count(fi.id) as fish_count,
       max(fi.length) as max_length,
       fi.fish_type
from fish_info fi
group by fi.fish_type
having avg(coalesce(fi.length, 10)) >= 33
order by fi.fish_type asc;