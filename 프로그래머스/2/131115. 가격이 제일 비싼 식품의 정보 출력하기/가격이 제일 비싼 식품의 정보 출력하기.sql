-- 코드를 입력하세요
SELECT 
    PRODUCT_ID,
    PRODUCT_NAME,
    PRODUCT_CD,
    CATEGORY,
    MAX(PRICE) as PRICE
from food_product
where PRICE = (SELECT MAX(price) from food_product)