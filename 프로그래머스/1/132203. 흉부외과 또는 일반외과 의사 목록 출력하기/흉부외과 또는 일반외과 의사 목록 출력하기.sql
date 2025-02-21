select d.dr_name, d.dr_id, d.mcdp_cd, date_format(d.hire_ymd, '%Y-%m-%d') as hire_ymd
from doctor d
where d.mcdp_cd = 'CS' or d.mcdp_cd = 'GS'
order by d.hire_ymd desc, d.dr_name asc;