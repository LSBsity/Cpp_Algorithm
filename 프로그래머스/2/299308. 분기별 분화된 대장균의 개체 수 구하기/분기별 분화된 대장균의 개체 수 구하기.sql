select concat(quarter(d.DIFFERENTIATION_DATE), 'Q') as quarter,
       count(d.id) as ecoli_count
from ecoli_data d
group by concat(quarter(d.DIFFERENTIATION_DATE), 'Q')
order by quarter asc;