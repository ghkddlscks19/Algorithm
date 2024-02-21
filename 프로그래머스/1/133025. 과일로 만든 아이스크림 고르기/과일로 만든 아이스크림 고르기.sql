-- 코드를 입력하세요
SELECT f.flavor
from first_half as f
left join icecream_info as i
on f.flavor = i.flavor
where f.total_order > 3000 and i.ingredient_type = 'fruit_based'
order by total_order desc