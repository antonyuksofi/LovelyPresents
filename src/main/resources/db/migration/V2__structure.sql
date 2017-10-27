create table Users (
	id int not null auto_increment,
	email varchar(100) not null,
	password tinyint(255) unsigned not null,
	name varchar(100) not null,
	phone int(10),
	address varchar(255),
	birthday date,
	discount int(2),
	created_at datetime not null,
	updated_at datetime not null,
	primary key(id)
);

/*alter table Users modify column password varchar(255) not null;*/

create table Products (
	id int not null auto_increment,
    name varchar(255) not null,
    code varchar(100) not null unique,
    description text,
    category_id int not null,
    color_id int,
    price int not null,
    count_left int not null,
	created_at datetime not null,
	updated_at datetime not null,
	primary key(id)
);

create table Orders (
	id int not null auto_increment,
    user_id int not null,
    user_name varchar(100) not null,
	user_phone int(10) not null,
    user_address varchar(255),
    delivery_id int not null,
    discount int,
    total_price int not null,
    comment varchar(255),
    status_id int not null,
	created_at datetime not null,
	updated_at datetime not null,
	primary key(id)
);

create table OrdersProducts (
	id int primary key auto_increment,
	order_id int not null,
    product_id int not null,
    image varchar(500) not null,
    count int not null
);

create table CartItems (
	id int primary key auto_increment,
	user_id int not null,
    product_id int not null,
    image varchar(500) not null,
    count int not null
);

/*alter table Carts rename CartItems;*/

/*alter table Carts modify column image varchar(500) not null;
alter table OrdersProducts modify column image varchar(500) not null;*/

create table Categories (
	id int not null auto_increment,
    name varchar(255) not null,
    code varchar(100) not null unique,
    description text,
    parent_id int not null,
	created_at datetime not null,
	updated_at datetime not null,
	primary key(id)
);

create table Comments (
	id int not null auto_increment,
    product_id int not null,
    user_id int not null,
    description text,
    mark int,
    enabled tinyint(1) not null,
	created_at datetime not null,
	updated_at datetime not null,
	primary key(id)
);

create table Colors (
	id int not null primary key auto_increment,
    name varchar(100),
    code varchar(100)
);

create table Deliveries (
	id int not null primary key auto_increment,
    name varchar(100),
    code varchar(100)
);

create table StatusesOfOrders (
	id int not null primary key auto_increment,
    name varchar(100),
    code varchar(100)
);

create table Wishlists (
	id int not null primary key auto_increment,
    user_id int not null,
	created_at datetime not null,
	updated_at datetime not null
);

create table WishlistsProducts (
	id int not null primary key auto_increment,
    wishlist_id int not null,
    product_id int not null,
    image mediumblob
);



alter table Orders add constraint orders_fk_user_id
foreign key (user_id)
references Users(id);

alter table Orders add constraint orders_fk_delivery_id
foreign key (delivery_id)
references Deliveries(id);

alter table Orders add constraint orders_fk_status_id
foreign key (status_id)
references StatusesOfOrders(id);


alter table OrdersProducts add constraint ordersproducts_fk_order_id
foreign key (order_id)
references Orders(id);

alter table OrdersProducts add constraint ordersproducts_fk_product_id
foreign key (product_id)
references Products(id);


alter table Products add constraint products_fk_color_id
foreign key (color_id)
references Colors(id);

alter table Products add constraint products_fk_category_id
foreign key (category_id)
references Categories(id);


alter table CartItems add constraint carts_fk_user_id
foreign key (user_id)
references Users(id);

alter table CartItems add constraint carts_fk_product_id
foreign key (product_id)
references Products(id);

/*show create table Carts;*/


alter table Comments add constraint comments_fk_product_id
foreign key (product_id)
references Products(id);

alter table Comments add constraint comments_fk_user_id
foreign key (user_id)
references Users(id);


alter table Wishlists add constraint wishlists_fk_user_id
foreign key (user_id)
references Users(id);


alter table WishlistsProducts add constraint wishlistsproducts_fk_wishlist_id
foreign key (wishlist_id)
references Wishlists(id);

alter table WishlistsProducts add constraint wishlistsproducts_fk_product_id
foreign key (product_id)
references Products(id);