select fp.product_id, fp.product_name, fp.product_cd, fp.category, fp.price
from food_product fp
where fp.price = (
    select max(fp.price)
    from food_product fp
);
