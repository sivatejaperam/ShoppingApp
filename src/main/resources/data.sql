DROP TABLE IF EXISTS `products`;

create table products
(
    id  bigint not null auto_increment primary key,
    description varchar(255) null,
    name        varchar(255) NOT null,
    price       double       not null
);

INSERT INTO PRODUCTS( description, name, price) values ( 'desc1', 'phone 1', 1000);
INSERT INTO PRODUCTS( description, name, price) values ( 'desc2', 'phone 2', 2000);
INSERT INTO PRODUCTS( description, name, price) values ( 'desc3', 'phone 3', 3000);
INSERT INTO PRODUCTS( description, name, price) values ( 'desc4', 'phone 4', 4000);

