select fi.id, fni.fish_name, fi.length
from fish_info fi
    join fish_name_info fni on fi.fish_type = fni.fish_type
where fi.length = (
    select max(sub_fi.length)
    from fish_info sub_fi
    where sub_fi.fish_type = fi.fish_type
)
order by fi.id asc;