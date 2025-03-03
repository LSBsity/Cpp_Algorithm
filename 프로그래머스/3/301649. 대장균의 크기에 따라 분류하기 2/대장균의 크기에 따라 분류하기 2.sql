WITH Ranked AS (
    SELECT 
        d.id,
        d.size_of_colony,
        ROW_NUMBER() OVER (ORDER BY d.size_of_colony DESC) AS row_num,
        COUNT(*) OVER () AS total_count
    FROM ecoli_data d
)
SELECT 
    r.id,
    CASE 
        WHEN r.row_num <= total_count * 0.25 THEN 'CRITICAL'
        WHEN r.row_num <= total_count * 0.50 THEN 'HIGH'
        WHEN r.row_num <= total_count * 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS colony_name
FROM Ranked r
ORDER BY r.id;
