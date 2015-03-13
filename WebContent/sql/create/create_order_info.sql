create table order_info (
	order_no int not null auto_increment primary key,
	order_date datetime not null,
	order_quantity int not null,
	customer_id varchar(30) not null,
	product_no int not null,
	payment_type varchar(20) not null,
	shipping_message text
);