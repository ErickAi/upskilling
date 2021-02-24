-- SIMPLE SELECT TASKS
select * from salespeople;

SELECT c.cnum, c.cname, c.snum
FROM customers c
WHERE snum = '1001' OR snum = '1002';
SELECT c.cnum id, c.cname "name", c.snum number
FROM customers c
WHERE snum in ('1001','1002');

SELECT * FROM customers WHERE cname like 'C%';
SELECT * FROM customers WHERE cname like 'C__________%';

-- JOIN TASKS
select c.cname customer_name, c.city city_customer, s.sname name_sales, s.city city_sales
from customers c
         join salespeople s on c.snum = s.snum and s.snum in (1002, 1001);

select c.cname, max(o.amt) from customers c join orders o on c.cnum = o.cnum group by c.cname limit 1;


select c.cname from customers c join orders o on c.cnum = o.cnum
     where o.odate between '1990-03-10' and '1990-05-10';

select c.cname as customers_name, c.city, c.rating, o.odate from customers c inner join orders o on c.cnum = o.cnum where o.odate between '1990-04-10' and '1990-10-05';

select * from customers cus left join orders ord on cus.cnum = ord.cnum where ord.amt in (select max(amt) from orders )
