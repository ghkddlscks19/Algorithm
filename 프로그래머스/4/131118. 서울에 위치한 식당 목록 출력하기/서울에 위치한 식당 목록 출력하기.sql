-- 코드를 입력하세요
SELECT
    r.REST_ID,
    r.REST_NAME,
    r.FOOD_TYPE,
    r.FAVORITES,
    r.ADDRESS,
    ROUND(AVG(rv.REVIEW_SCORE),2) as score
from REST_INFO as r
join REST_REVIEW as rv
on r.REST_ID = rv.REST_ID
where r.ADDRESS like '서울%'
group by r.REST_NAME
order by score desc, r.FAVORITES desc
