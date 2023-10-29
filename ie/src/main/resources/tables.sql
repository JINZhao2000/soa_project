create table client (
    email varchar(40) primary key,
    name varchar(40),
    address varchar(60),
    tel varchar(20),
    amount int,
    duration int,
    descr varchar(200),
    income double,
    spent double
)