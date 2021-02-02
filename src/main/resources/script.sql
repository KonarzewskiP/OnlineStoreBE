create table product_table
(
	id int not null,
	title varchar(100) not null,
	description varchar(500) null,
	image varchar(500) null,
	price double null,
	constraint product_table_pk
		primary key (id)
);

create table user_table
(
	id int auto_increment,
	name varchar(100) not null,
	surname varchar(100) null,
	email varchar(100) not null,
	phone varchar(15) null,
	password varchar(300) null,
	role varchar(20) null,
	address varchar(70) null,
	constraint user_table_pk
		primary key (id)
);

create unique index user_table_email_uindex
	on user_table (email);

create table purchase_item_table
(
	id int auto_increment,
	product_id int null,
	count int default 1 null,
	constraint purchase_item_table_pk
		primary key (id),
	constraint purchase_item_table_product_table_id_fk
		foreign key (product_id) references product_table (id)
);

create table order_table
(
	id int auto_increment,
	user_id int null,
	purchase_item_id int null,
	comment text null,
	constraint order_table_pk
		primary key (id),
	constraint order_table_purchase_item_table_id_fk
		foreign key (purchase_item_id) references purchase_item_table (id),
	constraint order_table_user_table_id_fk
		foreign key (user_id) references user_table (id)
);

