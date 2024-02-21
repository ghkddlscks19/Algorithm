-- 코드를 입력하세요
SELECT
    MCDP_CD as 진료과코드,
    count(APNT_YMD) as 5월예약건수
from APPOINTMENT 
where APNT_YMD like '2022-05%'
group by 진료과코드
order by count(APNT_YMD), 진료과코드