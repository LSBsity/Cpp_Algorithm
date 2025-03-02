WITH review_counts AS (
    SELECT p.member_id, COUNT(r.review_id) AS review_count
    FROM member_profile p
    JOIN rest_review r ON p.member_id = r.member_id
    GROUP BY p.member_id
),
max_reviewers AS (
    SELECT member_id
    FROM review_counts
    WHERE review_count = (SELECT MAX(review_count) FROM review_counts)
)
SELECT p.member_name,
       r.review_text,
       date_format(r.review_date, '%Y-%m-%d') as review_date
FROM member_profile p
JOIN rest_review r ON p.member_id = r.member_id
WHERE p.member_id IN (SELECT member_id FROM max_reviewers)
order by review_date asc, r.review_text asc;
