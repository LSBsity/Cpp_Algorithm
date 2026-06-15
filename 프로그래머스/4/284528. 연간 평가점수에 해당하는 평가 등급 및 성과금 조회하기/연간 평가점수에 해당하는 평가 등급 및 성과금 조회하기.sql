select
  e.emp_no,
  e.emp_name,
  case
    when score >= 96 then 'S'
    when score >= 90 then 'A'
    when score >= 80 then 'B'
    else 'C'
  end as 'grade',
  case
    when score >= 96 then e.sal * 0.2
    when score >= 90 then e.sal * 0.15
    when score >= 80 then e.sal * 0.1
    else 0
  end as 'bonus'
from hr_employees e
join (
  select
    g.emp_no,
    avg(g.score) as score
    from hr_grade g
    where g.year = 2022
    group by g.emp_no
) as g on g.emp_no = e.emp_no
order by e.emp_no asc;

