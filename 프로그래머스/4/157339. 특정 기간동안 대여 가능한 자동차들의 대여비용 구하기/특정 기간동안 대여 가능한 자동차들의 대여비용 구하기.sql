WITH Available_Cars AS (
    SELECT c.car_id, c.car_type, c.daily_fee
    FROM car_rental_company_car c
    WHERE c.car_type IN ('세단', 'SUV')
    AND NOT EXISTS (
        SELECT 1
        FROM car_rental_company_rental_history h
        WHERE h.car_id = c.car_id
        AND h.start_date <= '2022-11-30' 
        AND h.end_date >= '2022-11-01'
    )
)
SELECT 
    ac.car_id,
    ac.car_type,
    FLOOR(ac.daily_fee * (1 - IFNULL(dp.discount_rate, 0) / 100) * 30) AS fee
FROM Available_Cars ac
LEFT JOIN car_rental_company_discount_plan dp 
ON ac.car_type = dp.car_type AND dp.duration_type = '30일 이상'
WHERE FLOOR(ac.daily_fee * (1 - IFNULL(dp.discount_rate, 0) / 100) * 30) BETWEEN 500000 AND 2000000
ORDER BY fee DESC, ac.car_type ASC, ac.car_id DESC;
