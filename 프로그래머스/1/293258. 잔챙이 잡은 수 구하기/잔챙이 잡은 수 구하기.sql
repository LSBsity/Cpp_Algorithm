select count(fi.id) as fish_count
from fish_info fi
where fi.length <= 10 or fi.length is null;