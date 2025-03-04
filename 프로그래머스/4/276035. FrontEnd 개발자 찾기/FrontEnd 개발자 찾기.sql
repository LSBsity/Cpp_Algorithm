with FrontCode as (
    select bit_or(c.code) as codes
    from skillcodes c
    where c.category = 'Front End'
)

select d.id,
       d.email,
       d.first_name,
       d.last_name
from developers d
where d.skill_code & (
    select c.codes
    from frontcode c
)
order by d.id asc;
