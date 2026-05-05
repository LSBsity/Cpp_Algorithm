select count(*)
from user_info ui
where year(ui.joined) = 2021 and
  ui.age between 20 and 29