select b.category,
       sum(bs.sales) as total_sales
from book b
    join book_sales bs on b.book_id = bs.book_id
where year(bs.sales_date) = 2022
    and month(bs.sales_date) = 1
group by b.category
order by b.category asc;