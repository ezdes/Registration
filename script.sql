create table users (
	user_id serial primary key,
	username varchar(255) not null,
	user_surname varchar(255) not null,
	user_birth_date varchar(255) not null,
	user_phone_number varchar(255) not null,
	user_email varchar(255) not null,
	user_password varchar(255) not null
);
