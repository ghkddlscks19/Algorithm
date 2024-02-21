-- 코드를 입력하세요
SELECT
    date_format(SALES_DATE, '%Y') as YEAR,
    date_format(SALES_DATE, '%m') as MONTH,
    u.GENDER,
    count(distinct u.USER_ID) as USERS
from user_info as u
join online_sale as o
on u.USER_ID = o.USER_ID
where u.GENDER is not null
group by YEAR,MONTH,u.GENDER
order by YEAR, MONTH, u.GENDER