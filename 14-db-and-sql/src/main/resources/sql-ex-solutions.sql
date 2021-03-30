/*
product (id,model,maker,type)
laptop  (code,model,speed,ram,hd,screen,price)
pc      (code,model,speed,ram,hd,cd,price)
printer (code,model,color,type,price)*/

-- 6. Для каждого product.maker, выпускающего laptop c hd не < 10 Гбайт, найти speed. Вывод: производитель, скорость.
select distinct p.MAKER, l.SPEED from PRODUCT as p join LAPTOP l on p.MODEL = L.MODEL where HD>=10;

-- 7. Найдите model и price всех имеющихся в продаже продуктов (любого типа) где maker = B (латинская буква).
select PRODUCT.model, tmp.price
from PRODUCT
join (
    select PRICE, MODEL from PC
    union
    select PRICE, MODEL from LAPTOP
    union
    select p.PRICE, MODEL from PRINTER p) as tmp
        on PRODUCT.MODEL = tmp.model
where PRODUCT.MAKER = 'B';

-- 8. Найдите производителя, выпускающего ПК, но не выпускающего ПК-блокноты.
select distinct p.maker from PRODUCT p where p.TYPE in ( 'PC')
    EXCEPT
select p.maker from PRODUCT p where p.TYPE in ('Laptop');

-- 9. Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker
select distinct pr.maker from PRODUCT pr join PC p on p.MODEL = pr.MODEL where p.SPEED >=450;

-- 10. Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price
select model, PRICE from PRINTER where printer.price = (select max(PRINTER.PRICE) from PRINTER);

-- 11. Найдите среднюю скорость ПК.
select avg(speed) from pc;

-- 12. Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.
select avg(speed) from LAPTOP where PRICE>1000;

-- 13. Найдите среднюю скорость ПК, выпущенных производителем A.
select avg(SPEED) from PC inner join PRODUCT P on P.MODEL = PC.MODEL where p.MAKER = 'A'