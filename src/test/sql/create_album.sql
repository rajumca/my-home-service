CREATE TABLE keyspace1.album (
	id uuid,
	name text,
	path text,
	composer text,
	year int,
	accessed int,
	rating int,
	PRIMARY KEY (id, name)
);
