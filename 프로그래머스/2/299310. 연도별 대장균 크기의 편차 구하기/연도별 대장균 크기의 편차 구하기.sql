select
  year(d1.differentiation_date) as year,
  max_size - d1.size_of_colony as year_dev,
  d1.id as id
from ecoli_data d1
join (
  select
    year(differentiation_date) as d2_year,
    max(size_of_colony) as max_size
  from ecoli_data   
  group by year(differentiation_date)
) as d2 on d2_year = year(d1.differentiation_date)
order by year asc, year_dev asc;




