select ap.apnt_no,
       p.pt_name,
       p.pt_no,
       ap.mcdp_cd,
       d.dr_name,
       ap.apnt_ymd
from appointment ap
    join patient p on ap.pt_no = p.pt_no
    join doctor d on ap.mddr_id = d.dr_id
where year(ap.apnt_ymd) = 2022 and
      month(ap.apnt_ymd) = 4 and
      day(ap.apnt_ymd) = 13 and
      apnt_cncl_yn = 'N'
order by ap.apnt_ymd asc;