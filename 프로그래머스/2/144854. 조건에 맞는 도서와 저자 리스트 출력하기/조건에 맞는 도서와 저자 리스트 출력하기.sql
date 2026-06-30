select
  b.book_id,
  a.author_name,
  b.published_date
from book b
  join author a on a.author_id = b.author_id
where b.category = '경제'
order by b.published_date asc;