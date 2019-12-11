create table allfood(
id serial primary key,
foodgenreid int not null,
foodname text not null,
foodpicture text not null,
foodid int not null,
tasteid int not null
);

create table washoku(
id serial primary key,
foodGenreId int not null,
foodName text not null,
foodPicture text not null,
foodId int not null
);

create table youshoku(
id serial primary key,
foodGenreId int not null,
foodName text not null,
foodPicture text not null,
foodId int not null
);

create table chuka(
id serial primary key,
foodGenreId int not null,
foodName text not null,
foodPicture text not null,
foodId int not null
);