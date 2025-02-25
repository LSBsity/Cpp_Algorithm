select b.book_id,
       date_format(b.published_date, '%Y-%m-%d') as published_date
from book b
where year(b.published_date) = 2021 and
      b.category = '인문'
order by b.published_date asc;
          