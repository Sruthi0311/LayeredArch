use test;
create table product(
    productId int primary key,
    productName VARCHAR(20),
    productPrice DOUBLE,
    productQuantity INT,
    productIsAvailable BOOLEAN
);
select * from product;