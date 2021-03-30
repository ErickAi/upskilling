CREATE TABLE product
(
    id    integer not null primary key auto_increment,
    maker varchar NOT NULL,        -- производитель
    model varchar NOT NULL unique, -- No модели
    type  varchar                  -- тип (пк, лаптоп, принтер
);
CREATE TABLE laptop
(
    code   integer not null primary key auto_increment,
    model  varchar NOT NULL, -- модель
    speed  integer,          -- скорость процессора
    ram    integer,          -- объем оперативки МБ
    hd     real,             -- объем жесткого ГБ
    screen integer,          -- диагональ
    price  integer,          -- цена
    foreign key (model) references product (model)
);
CREATE TABLE pc
(
    code  integer not null primary key auto_increment,
    model varchar NOT NULL, -- модель
    speed integer,          -- скорость процессора
    ram   integer,          -- объем оперативки МБ
    hd    real,             -- объем жесткого ГБ
    cd    varchar,          -- диагональ
    price integer,          -- цена
    foreign key (model) references product (model)
);
CREATE TABLE printer
(
    code  integer not null primary key auto_increment,
    model varchar NOT NULL, -- модель
    color char,             -- y - цветной, n - ч/б
    type  varchar,          -- laser, jet, matrix
    price integer,          -- цена
    foreign key (model) references product (model)
);

insert into product (maker, model, type)
values ('B', '1121', 'PC'),
       ('A', '1232', 'PC'),
       ('A', '1233', 'PC'),
       ('E', '1260', 'PC'),
       ('A', '1276', 'Printer'),
       ('D', '1288', 'Printer'),
       ('A', '1298', 'Laptop'),
       ('C', '1321', 'Laptop'),
       ('A', '1401', 'Printer'),
       ('A', '1408', 'Printer'),
       ('D', '1433', 'Printer'),
       ('E', '1434', 'Printer'),
       ('B', '1750', 'Laptop'),
       ('A', '1752', 'Laptop'),
       ('E', '2112', 'PC'),
       ('E', '2113', 'PC');
insert into laptop (model, speed, ram, hd, screen, price)
values ('1298', 350, 32, 4.0, 11, 700),
       ('1321', 500, 64, 8.0, 12, 970),
       ('1750', 750, 128, 12.0, 14, 1200),
       ('1298', 600, 64, 10.0, 15, 1050),
       ('1752', 750, 128, 10.0, 14, 1150),
       ('1298', 450, 64, 10.0, 12, 950);
insert into pc (model, speed, ram, hd, cd, price)
values ('1232', 500, 64, 5.0, '12x', 600),
       ('1121', 750, 128, 14.0, '40x', 850),
       ('1233', 500, 64, 5.0, '12x', 600),
       ('1121', 600, 128, 14.0, '40x', 850),
       ('1121', 600, 128, 8.0, '40x', 850),
       ('1233', 750, 128, 20.0, '50x', 950),
       ('1232', 500, 32, 10.0, '12x', 400),
       ('1232', 450, 64, 8.0, '24x', 350),
       ('1232', 450, 32, 10.0, '24x', 350),
       ('1260', 500, 32, 10.0, '12x', 350),
       ('1233', 900, 128, 40.0, '40x', 980),
       ('1233', 800, 128, 20.0, '50x', 970);
insert into printer (model, color, type, price)
values ('1276', 'n', 'Laser', 400),
       ('1433', 'y', 'Jet', 270),
       ('1434', 'y', 'Jet', 290),
       ('1401', 'n', 'Matrix', 150),
       ('1408', 'n', 'Matrix', 270),
       ('1288', 'n', 'Laser', 400);
