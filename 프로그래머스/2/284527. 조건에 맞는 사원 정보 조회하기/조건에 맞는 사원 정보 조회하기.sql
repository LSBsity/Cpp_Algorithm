# select
#     g.emp_no as emp_no2,
#     sum(g.score) as score_sum
#   from hr_grade g
#   group by g.emp_no


select
  g.score_sum,
  e.emp_no,
  e.emp_name,
  e.position,
  e.email
from hr_employees e
join (
  select
    g.emp_no as emp_no2,
    sum(g.score) as score_sum
  from hr_grade g
  group by g.emp_no
) g on g.emp_no2 = e.emp_no
order by g.score_sum desc
limit 1;