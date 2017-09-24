create table Users (
  id int not null,
  email varchar(100) not null,
  password tinyint(256) unsigned not null,
  name varchar(100) not null,
  phone int(10) not null,
  address varchar(256),
  birthday date,
  discount int(2),
  created_at datetime not null,
  updated_at datetime not null
)