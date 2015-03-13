create table customer (
	customer_id varchar(30) primary key,
	customer_password varchar(30) not null,
	customer_name varchar(30) not null,
	customer_email varchar(45) not null,
	customer_phone varchar(13) not null
);