SELECT COUNT(*) AS USERS
FROM user_info
WHERE YEAR(joined) = 2021
  AND age >= 20
  AND age <= 29;
