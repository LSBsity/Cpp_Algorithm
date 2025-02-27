select distinct u.user_id,
       u.nickname,
       concat(u.city, ' ', u.street_address1, ' ', u.street_address2) as '전체주소',
       concat(
           substring(u.tlno, 1, 3), '-', 
           substring(u.tlno, 4, 4), '-', 
           substring(u.tlno, 8, 4)
       ) AS tlno
from used_goods_board b
    join used_goods_user u on b.writer_id = u.user_id
where b.writer_id in (
    select sub_b.writer_id
    from used_goods_board sub_b
    group by sub_b.writer_id
    having count(sub_b.writer_id) >= 3
)
order by u.user_id desc;