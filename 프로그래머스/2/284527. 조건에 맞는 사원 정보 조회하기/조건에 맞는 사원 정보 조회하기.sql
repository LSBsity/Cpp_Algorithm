select total_score as score,
       e.emp_no,
       e.emp_name,
       e.position,
       e.email
from (
    select e.emp_no,
           sum(g.score) as total_score
    from hr_employees e
    join hr_department d on e.dept_id = d.dept_id
    join hr_grade g on e.emp_no = g.emp_no
    group by e.emp_no
) as scores
join hr_employees e on scores.emp_no = e.emp_no
order by total_score desc
limit 1;
