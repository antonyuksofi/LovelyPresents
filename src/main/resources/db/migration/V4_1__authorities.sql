/*truncate users;*/

alter table users add column enabled tinyint not null default 1 after discount;
alter table users add column username varchar(100) not null unique after id;


insert into users
(username, email, password, name, created_at, updated_at)
values
('sofia', 'testmail@test', '111', 'Софія', now(), now()),
('frost', 'testmail@test', '111', 'frost', now(), now()),
('john', 'testmail@test', '111', 'джон', now(), now()),
('sunny', 'testmail@test', '111', 'sun', now(), now());



create table authorities (
  id int not null auto_increment primary key,
  user_id int not null,
  authority varchar(50) not null,
  constraint authorities_fk_user_id foreign key(user_id) references users(id),
  constraint authorities_uniq unique key uniq_userid_authority(user_id, authority)
);

insert into authorities
(user_id, authority)
values
  (1, 'ROLE_ADMIN'),
  (1, 'ROLE_DBA'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_SUPERUSER'),
  (4, 'ROLE_DBA');