SELECT 
    YEAR(ed.differentiation_date) AS YEAR,
    ( 
        (SELECT MAX(sub_ed.size_of_colony) 
         FROM ecoli_data sub_ed 
         WHERE YEAR(sub_ed.differentiation_date) = YEAR(ed.differentiation_date)
        ) 
        - ed.size_of_colony
    ) AS YEAR_DEV,
    ed.id AS ID
FROM ecoli_data ed
ORDER BY YEAR(ed.differentiation_date) ASC, YEAR_DEV ASC;
