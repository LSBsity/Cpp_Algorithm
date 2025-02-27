select count(fi.id) as fish_count
from fish_info fi
where year(fi.time) = 2021;