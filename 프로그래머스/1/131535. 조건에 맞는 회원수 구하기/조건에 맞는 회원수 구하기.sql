 select count(ui.user_id) as users
 from user_info ui
 where ui.age >= 20 and ui.age <= 29 and ui.joined between '2021-01-01' and '2021-12-31';