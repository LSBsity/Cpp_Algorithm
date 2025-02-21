select ap.mcdp_cd as '진료과코드',
       count(ap.apnt_ymd) as '5월예약건수'
from appointment ap
where date_format(ap.apnt_ymd, '%Y-%m') = '2022-05'
group by ap.mcdp_cd
order by count(ap.apnt_ymd) asc, ap.mcdp_cd asc;
