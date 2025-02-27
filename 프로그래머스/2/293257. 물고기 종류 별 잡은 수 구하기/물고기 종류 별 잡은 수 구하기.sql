select count(fi.id) as fish_count,
       fni.fish_name
from fish_info fi
    join fish_name_info fni on fi.fish_type = fni.fish_type
group by fi.fish_type, fni.fish_name
order by fish_count desc;