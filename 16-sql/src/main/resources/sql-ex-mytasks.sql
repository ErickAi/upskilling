/*
product (id,model,maker,type)
laptop  (code,model,speed,ram,hd,screen,price)
pc      (code,model,speed,ram,hd,cd,price)
printer (code,model,color,type,price)*/

-- 13. Найдите все ПК, выпущенных производителем A.
select * from PC join PRODUCT P on P.MODEL = PC.MODEL where p.MAKER = 'A';
select * from PC left join PRODUCT P on P.MODEL = PC.MODEL;
select * from PC right join PRODUCT P on P.MODEL = PC.MODEL