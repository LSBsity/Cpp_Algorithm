select
  dr.dr_name,
  dr.dr_id,
  dr.mcdp_cd,
  dr.hire_ymd
from doctor dr
where dr.mcdp_cd in ('CS', 'GS')
order by dr.hire_ymd desc, dr.dr_name;