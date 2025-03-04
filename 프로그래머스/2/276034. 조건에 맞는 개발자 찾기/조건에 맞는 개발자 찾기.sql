select d.id,
       d.email,
       d.first_name,
       d.last_name
from developers d
where d.skill_code & (
    select bit_or(c.code)
    from skillcodes c
    where c.name in ('Python', 'C#')
)
order by d.id asc;