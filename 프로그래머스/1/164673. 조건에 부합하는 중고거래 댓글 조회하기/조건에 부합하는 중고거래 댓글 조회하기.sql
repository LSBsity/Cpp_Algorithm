select b.title,
       b.board_id,
       r.reply_id,
       r.writer_id,
       r.contents,
       date_format(r.created_date, '%Y-%m-%d') as created_date
from used_goods_board b
    join used_goods_reply r on b.board_id = r.board_id
where year(b.created_date) = 2022 and
      month(b.created_date) = 10
order by created_date asc, b.title asc;
