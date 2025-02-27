select b.board_id,
       b.writer_id,
       b.title,
       b.price,
       (case
            when b.status = 'sale' then '판매중'
            when b.status = 'reserved' then '예약중'
            when b.status = 'done' then '거래완료' 
       end) as status
from used_goods_board b
where year(b.created_date) = 2022 and
      month(b.created_date) = 10 and
      day(b.created_date) = 5
order by b.board_id desc;