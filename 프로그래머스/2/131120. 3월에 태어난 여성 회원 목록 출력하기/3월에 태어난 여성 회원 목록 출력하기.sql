select
  mp.member_id,
  mp.member_name,
  mp.gender,
  mp.date_of_birth
from member_profile mp
where MONTH(mp.date_of_birth) = 3 and
  gender = 'W' and
  tlno is not null
order by mp.member_id