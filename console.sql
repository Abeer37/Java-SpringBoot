#DDL
create database store;
Create table countries(
    code int,
    name varchar(20) unique,
    continent_name varchar(20) not null
);
Create table users(
    id int primary key,
    full_name varchar(20),
    email varchar(20) unique,
    gender char(1) check('m'or'f'),
    date_of_birth varchar(15),
    created_at decimal,
    country_code int,
    foreign key (country_code) references countries(code)
);
Create table orders(
    id int,
    user_id int,
    status varchar(6) check('start'or'finish'),
    created_at decimal,
    foreign key (user_id) references users(id)
);
Create table order_products(
    order_id int,
    product_id int,
    quantity int default 0,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);
Create table products(
    id int,
    name varchar(10) not null,
    price int default 0,
    status varchar(10) check ('valid'or'expired'),
    created_at decimal
);

#DML
insert into countries values('1241','Abeer','KSA');
insert into users values('134542','Abeer','abeer@gmail.com','female','1991/12/17','2.332','+966');
insert into orders values('1241','2134','start','1');
insert into products values('1234','Abeer','1000','expired','2.34543');
insert into order_products values('1241','1234','1000');

update countries set name='sara' where code='1241';

delete from products where id='1241';
