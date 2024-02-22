-- 코드를 입력하세요
SELECT 
    b.author_id,
    a.author_name,
    b.category,
    sum(b.price*bs.sales) as total_sales
from book as b
join author as a 
on b.author_id = a.author_id 
join book_sales as bs
on b.book_id = bs.book_id
where date_format(bs.sales_date, '%Y-%m-%d') like '2022-01%'
group by a.author_name, b.category
order by b.author_id, b.category desc