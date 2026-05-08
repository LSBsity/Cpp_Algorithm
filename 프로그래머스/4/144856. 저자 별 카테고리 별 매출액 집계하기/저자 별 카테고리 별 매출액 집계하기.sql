select
  b.author_id,
  a.author_name,
  b.category,
  sum(b.price * s.sales) as total_sales
from book_sales s
  join book b on s.book_id = b.book_id
  join author a on b.author_id = a.author_id
where s.sales_date between '2022-01-01' and '2022-01-31'
group by b.author_id, b.category
order by b.author_id, b.category desc;