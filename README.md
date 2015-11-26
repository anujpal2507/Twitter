# twitter
Please follow the below instructions!!!

This project is developed on IntelliJ Idea IDE with oracle java 8 and Postgresql(9.5) database is used.
Database related authenticates are given in application.properties.
just copy the below queries:

Create first table "twitter_users"

create table twitter_users( email varchar(40) not null primary key, firstname char(20) not null, lastname char(20) not null, password varchar(20) not null);

Create second table "following"

create table following(id serial, email varchar(40) not null, followinguser char(40) not null);

Create third table "tweet"

create table tweet(id serial, email varchar(40) not null , tweets varchar(150) not null, tweeettimestamp timestamp);
