select di.id, di.email, di.first_name, di.last_name
from developer_infos di
where di.skill_1 = 'Python' or
  di.skill_2 = 'Python' or
  di.skill_3 = 'Python'
 order by di.id