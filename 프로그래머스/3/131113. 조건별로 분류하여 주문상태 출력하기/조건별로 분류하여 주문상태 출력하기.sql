select 
    fo.order_id, 
    fo.product_id, 
    date_format(fo.out_date, '%Y-%m-%d') as out_date,
    case 
        when fo.out_date is null then '출고미정'
        when fo.out_date <= '2022-05-01' then '출고완료'
        else '출고대기'
    end as 출고여부
from food_order fo
order by fo.order_id asc;