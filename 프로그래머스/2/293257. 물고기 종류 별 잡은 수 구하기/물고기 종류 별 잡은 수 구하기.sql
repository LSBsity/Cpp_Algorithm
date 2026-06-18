select
  count(i.id) fish_count,
  ni.fish_name
from fish_name_info ni
  join fish_info i on ni.fish_type = i.fish_type
group by ni.fish_type, ni.fish_name
order by count(i.id) desc