select p.id,
       p.name,
       p.host_id
from places p
where p.host_id in (
    select sub_p.host_id
    from places sub_p
    group by host_id
    having count(*) >= 2
)
group by p.id
order by p.id asc;