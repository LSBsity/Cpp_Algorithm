select
  concat(quarter(ed.differentiation_date), 'Q') as quarter,
  count(ed.id)
from ecoli_data ed
group by quarter(ed.differentiation_date)
order by quarter asc;