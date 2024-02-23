-- 코드를 입력하세요
SELECT
    m.member_name,
    r.review_text,
    date_format(r.review_date, '%Y-%m-%d') as review_date
from member_profile as m
join rest_review as r
on m.member_id = r.member_id
where m.member_id in(
    select member_id
    from rest_review
    group by member_id
    having count(member_id) =(
        select count(*) as total
        FROM rest_review 
        GROUP BY MEMBER_ID
        ORDER BY count(*) DESC
        LIMIT 1
    )
)
order by review_date, r.review_text