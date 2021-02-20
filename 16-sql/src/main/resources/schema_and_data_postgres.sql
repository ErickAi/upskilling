

CREATE TABLE Salespeople
(
  snum integer NOT NULL,
  sname char (10) NOT NULL,
  city char (10),
  comm decimal
);

CREATE TABLE Customers
(
  cnum integer NOT NULL,
  cname char (10) NOT NULL,
  city char (10),
  rating integer,
  snum integer
);

CREATE TABLE Orders
(
  onum integer NOT NULL,
  amt decimal (10,2),
  odate date,
  cnum integer,
  snum integer
);



INSERT INTO Salespeople(snum, sname, city, comm) VALUES(1001, 'Peel','London', .12);
INSERT INTO Salespeople(snum, sname, city, comm) VALUES(1002, 'Serres','San Jose', .13);
INSERT INTO Salespeople(snum, sname, city, comm) VALUES(1004, 'Motika','London', .11);
INSERT INTO Salespeople(snum, sname, city, comm) VALUES(1007, 'Rifkin','Barcelona', .15);
INSERT INTO Salespeople(snum, sname, city, comm) VALUES(1003, 'Axelrod','New York', .10);

INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2001, 'Hoffman','London', 100, 1001);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2002, 'Giovanni','Rome', 200, 1003);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2003, 'Liu','San Jose', 200, 1002);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2004, 'Grass','Berlin', 300, 1002);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2006, 'Clemens','London', 100, 1001);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2008, 'Cisneros','San Jose', 300, 1007);
INSERT INTO Customers(cnum, cname, city, rating, snum) VALUES(2007, 'Pereira','Rome', 100, 1004);

INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3001, 18.69, '1990-10-03', 2008, 1007);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3003, 767.19,  '1990-10-03', 2001, 1001);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3002, 1900.10, '1990-10-03', 2007, 1004);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3005, 5160.45, '1990-10-03', 2003, 1002);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3006, 1098.16, '1990-10-03', 2008, 1007);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3009, 1713.23, '1990-10-04', 2002, 1003);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3007, 75.75,   '1990-10-04', 2004, 1002);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3008, 4723.00, '1990-10-05', 2006, 1001);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3010, 1309.95, '1990-10-06', 2004, 1002);
INSERT INTO Orders(onum, amt, odate, cnum, snum) VALUES(3011, 9891.88, '1990-10-06', 2006, 1001);
