create database jukebox;
use jukebox;

drop table songs;

insert into class_tbl(class_name, section) values('10', 'B');

create table artist(artist_id int primary key auto_increment,
artist_name varchar(20) not null
);

create table genre(genre_id int primary key auto_increment,
genre_name varchar(20) not null
);

create table songs (song_id int primary key auto_increment, 
song_name varchar(20) not null, 
artist varchar(20) not null,
genre varchar(20) not null,
duration varchar(10) not null,
year_released int not null,
root_source varchar(50) not null
);

create table playlist(playlist_id int primary key auto_increment,
playlist_name varchar(20) not null,
playlist_content varchar(50) default ''
);

drop table playlist;

insert into playlist(playlist_name) values('Favourites');

delete from playlist;
ALTER TABLE playlist AUTO_INCREMENT = 1;
update playlist set playlist_content = '1, 3, 5, ' where playlist_id = 1;
update playlist set playlist_content = concat(playlist_content, '7, ') where playlist_id = 1;

insert into artist(artist_name) values('Taylor');
insert into genre(genre_name) values('Pop');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Blank Space', 'Taylor', 'Pop', 'NA', 2014, 'NA');

update songs set root_source = 'resources/Wav_Files_24mb.wav' where song_id = 1;
delete from songs where song_id = 1;
update songs set song_name = 'Heartbeat Song' where song_id = 1;
update songs set song_id = 1 where song_id = 2;
delete from artist where artist_id = 5;
update artist set artist_id = 1 where artist_id = 2;
update artist set artist_id = 2 where artist_id = 3;
update songs set root_source = 'resources/pop/Heartbeat Song.wav' where song_id = 1;
update songs set root_source = 'resources/pop/We Can\'t Stop.wav' where song_id = 2;
delete from songs;

ALTER TABLE artist AUTO_INCREMENT = 3;
ALTER TABLE songs AUTO_INCREMENT = 1;

insert into artist(artist_name) values('Kelly Clarkson');
insert into artist(artist_name) values('Miley Cyrus');
insert into artist(artist_name) values('AC/DC');
insert into artist(artist_name) values('OneRepublic');
insert into artist(artist_name) values('Marshmello');
insert into artist(artist_name) values('Calvin Harris');
insert into artist(artist_name) values('Metallica');

insert into genre(genre_name) values('Pop');
insert into genre(genre_name) values('Rock');
insert into genre(genre_name) values('Dance/Electronic');
insert into genre(genre_name) values('Metal');

insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Heartbeat Song', 'Kelly Clarkson', 'Pop', '3:18', 2015, 'resources/pop/Heartbeat Song.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('We can\'t stop', 'Miley Cyrus', 'Pop', '3:51', 2013, 'resources/pop/We Can\'t Stop.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Back in Black', 'AC/DC', 'Rock', '4:15', 1980, 'resources/rock/Back In Black.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('I Ain\'t Worried', 'OneRepublic', 'Rock', '2:28', 2022, 'resources/rock/I Ain’t Worried.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Alone', 'Marshmello', 'Dance/Electronic', '3:20', 2016, 'resources/danceelectronic/Alone.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Summer', 'Calvin Harris', 'Dance/Electronic', '3:44', 2014, 'resources/danceelectronic/Summer.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Master of Puppets', 'Metallica', 'Metal', '8:37', 1986, 'resources/metal/Master of Puppets.wav');
insert into songs(song_name, artist, genre, duration, year_released, root_source) values('Enter Sandman', 'Metallica', 'Metal', '5:32', 1991, 'resources/metal/Enter Sandman.wav');