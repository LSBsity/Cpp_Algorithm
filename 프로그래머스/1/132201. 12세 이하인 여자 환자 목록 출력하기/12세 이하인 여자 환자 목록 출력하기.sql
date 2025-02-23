select p.pt_name, p.pt_no, p.gend_cd, p.age, coalesce(p.tlno, 'NONE') as tlno
from patient p
where p.age <= 12 and p.gend_cd = 'W'
order by p.age desc, p.pt_name asc;