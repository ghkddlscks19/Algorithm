-- 코드를 입력하세요
with recursive time as (
    select 9 as hour
    union all
    select hour+1 from time
    where hour<19
)

select 
    t.hour,
    count(hour(a.datetime)) as count
from time as t
join animal_outs as a
on t.hour = hour(a.datetime)
group by t.hour
order by t.hour