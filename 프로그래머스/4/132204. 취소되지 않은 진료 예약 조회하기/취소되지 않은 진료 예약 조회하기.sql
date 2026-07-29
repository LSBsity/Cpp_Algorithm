select
  ap.apnt_no,
  p.pt_name,
  ap.pt_no,
  d.mcdp_cd,
  d.dr_name,
  ap.apnt_ymd
from appointment ap
join patient p on p.pt_no = ap.pt_no
join doctor d on d.dr_id = ap.mddr_id
where d.mcdp_cd = 'CS' and
  year(ap.apnt_ymd) = 2022 and
  month(ap.apnt_ymd) = 4 and
  day(ap.apnt_ymd) = 13 and
  ap.apnt_cncl_ymd is null
order by ap.apnt_ymd asc;