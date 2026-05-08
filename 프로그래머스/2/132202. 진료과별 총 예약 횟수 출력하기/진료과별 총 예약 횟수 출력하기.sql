select 
  ap.mcdp_cd as '진료과코드',
  count(*) as '5월예약건수'
from appointment ap
where apnt_ymd >= '2022-05-01' and apnt_ymd < '2022-06-01'
group by ap.mcdp_cd
order by count(*) asc, ap.mcdp_cd asc;