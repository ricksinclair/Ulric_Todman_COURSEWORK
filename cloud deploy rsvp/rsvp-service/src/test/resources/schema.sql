create schema if not exists rsvp_test;
use rsvp_test;

create table if not exists rsvp (
	rsvp_id int not null auto_increment primary key,
    guest_name varchar(50) not null,
    total_attending int not null
);