select count(ui.user_id) as USERS
from user_info ui
where ui.age is null;