select
  b.category,
  sum(bs.sales) as total_sales
from book_sales bs
  join book b on bs.book_id = b.book_id
where bs.sales_date between '2022-01-01' and '2022-01-31'
group by b.category
order by b.category asc;