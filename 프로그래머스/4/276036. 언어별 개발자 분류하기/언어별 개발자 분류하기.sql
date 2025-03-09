with front_end_codes as (
    select bit_or(c.code) as codes
    from skillcodes c
    where c.category = 'Front End'
), grades as (
    select (case
            when d.skill_code & (
                select codes
                from front_end_codes
            ) > 0 and
                 d.skill_code & (
                select sub_c.code
                from skillcodes sub_c
                where sub_c.name = 'Python'
            ) > 0 then 'A'
            when d.skill_code & (
                select sub_c.code
                from skillcodes sub_c
                where sub_c.name = 'C#'
            ) > 0 then 'B'
            when d.skill_code & (
                select codes
                from front_end_codes
            ) > 0 then 'C'
            end) as grade,
            d.id,
            d.email
    from developers d
)

select 
    g.grade,
    g.id,
    g.email
from grades g
where g.grade is not null
order by grade asc, g.id asc;

