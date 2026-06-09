WITH RECURSIVE hours AS (
  SELECT 0 AS hour
  UNION ALL
  SELECT hour + 1 FROM hours WHERE hour < 23
)

SELECT
  h.hour,
  COUNT(ao.animal_id) AS count
FROM hours h
LEFT JOIN animal_outs ao ON HOUR(ao.datetime) = h.hour
GROUP BY h.hour
ORDER BY h.hour ASC;