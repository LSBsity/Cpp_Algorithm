select i.id,
       i.email,
       i.first_name,
       i.last_name
from developer_infos i
where i.skill_1 = 'Python' or i.skill_2 = 'Python' or i.skill_3 = 'Python'
order by i.id asc;