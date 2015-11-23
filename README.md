# twitter
Please follow the below instructions!!!

This project is developed on IntelliJ Idea IDE with oracle java 8 and Postgresql(9.5) database is used.
Database related authenticates are given in application.properties.
just copy the below queries:

Create first table "twitter_users"

create table twitter_users( email char(40) not null, firstname char(20) not null, lastname char(20) not null, password varchar(20) not null);

Create second table "following"

create table following(id serial, email char(40), followinguser char(40));

Create third table "tweet"

create table tweet(id serial, email char(40), tweets varchar(150), tweeettimestamp timestamp);
