-- 코드를 입력하세요
SELECT
    c.car_id,
    c.car_type,
    floor(c.daily_fee*30*(100-p.discount_rate)/100) AS fee
from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
on c.car_id = h.car_id
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
on c.car_type = p.car_type
where c.car_id not in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where end_date > '2022-11-01' and start_date < '2022-12-01'   
) and p.duration_type = '30일 이상' 
group by c.car_id
having c.car_type in ('세단', 'SUV') and (fee >= 500000 and fee < 2000000)