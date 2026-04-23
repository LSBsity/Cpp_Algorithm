select b.book_id, b.published_date
from book b
where b.published_date >= '2021-01-01'
  and b.published_date < '2022-01-01'
  and b.category = '인문'
order by b.published_date;