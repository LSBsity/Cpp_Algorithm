select
  p.member_name,
  r.review_text,
  r.review_date
from member_profile p
  join rest_review r on r.member_id = p.member_id
where p.member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(review_id) desc
    limit 1
)
order by r.review_date asc, r.review_text asc;

# select *, count(review_id)
# from rest_review
# group by member_id
# order by count(review_id) desc
# limit 1;
