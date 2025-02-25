select p.member_id,
       p.member_name,
       p.gender,
       date_format(p.date_of_birth, '%Y-%m-%d') as date_of_birth
from member_profile p
where month(p.date_of_birth) = 3 and
      p.gender = 'W' and
      p.tlno is not null
order by p.member_id asc;