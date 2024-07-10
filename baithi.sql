create database baithi;
use baithi;


create table products(
id int primary key auto_increment,
name varchar(255) not null,
price decimal(10,2) not null,
discount decimal(5,2),
stock int);

create table employees(
id int primary key auto_increment,
name varchar(255) not null,
dOB date not null,
address varchar(255) not null);

create table customers(
id int primary key auto_increment,
name varchar(255) not null,
dOB date not null,
address varchar(255) not null,
phone varchar(11) not null,
email varchar(60) not null);

create table orders(
id int primary key auto_increment,
payment_method varchar(255) not null,
oder_date date not null,
delivery_date date not null,
delivery_address varchar(255) not null,
p_id int not null,
c_id int not null,
e_id int not null,
foreign key (p_id) references products (id),
foreign key (c_id) references customers (id),
foreign key (e_id) references employees (id));

create table order_details(
quantity int,
o_id int,
p_id int,
foreign key (o_id) references orders (id),
foreign key (p_id) references products (id))



