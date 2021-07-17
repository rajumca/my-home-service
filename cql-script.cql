-- Export of keyspace keyspace1
CREATE KEYSPACE keyspace1
WITH durable_writes = true
AND replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

CREATE TABLE keyspace1.song (
	album_name text,
	name text,
	accessed int,
	lyricist text,
	path text,
	rating int,
	singers LIST<text>,
	PRIMARY KEY (album_name, name)
) WITH CLUSTERING ORDER BY ( name ASC )
AND bloom_filter_fp_chance = 0.01
AND comment = ''
AND crc_check_chance = 1.0
AND dclocal_read_repair_chance = 0.1
AND default_time_to_live = 0
AND gc_grace_seconds = 864000
AND max_index_interval = 2048
AND memtable_flush_period_in_ms = 0
AND min_index_interval = 128
AND read_repair_chance = 0.0
AND speculative_retry = '99.0PERCENTILE'
AND caching = {
	'keys' : 'ALL',
	'rows_per_partition' : 'NONE'
}
AND compression = {
	'chunk_length_in_kb' : 64,
	'class' : 'LZ4Compressor',
	'enabled' : true
}
AND compaction = {
	'bucket_high' : 1.5,
	'bucket_low' : 0.5,
	'class' : 'SizeTieredCompactionStrategy',
	'enabled' : true,
	'max_threshold' : 32,
	'min_sstable_size' : 50,
	'min_threshold' : 4,
	'tombstone_compaction_interval' : 86400,
	'tombstone_threshold' : 0.2,
	'unchecked_tombstone_compaction' : false
};

CREATE TABLE keyspace1.album (
	name text,
	accessed int,
	composer text,
	path text,
	rating int,
	year int,
	image blob,
	PRIMARY KEY (name)
) WITH bloom_filter_fp_chance = 0.01
AND comment = ''
AND crc_check_chance = 1.0
AND dclocal_read_repair_chance = 0.1
AND default_time_to_live = 0
AND gc_grace_seconds = 864000
AND max_index_interval = 2048
AND memtable_flush_period_in_ms = 0
AND min_index_interval = 128
AND read_repair_chance = 0.0
AND speculative_retry = '99.0PERCENTILE'
AND caching = {
	'keys' : 'ALL',
	'rows_per_partition' : 'NONE'
}
AND compression = {
	'chunk_length_in_kb' : 64,
	'class' : 'LZ4Compressor',
	'crc_check_chance' : 1.0,
	'enabled' : true
}
AND compaction = {
	'bucket_high' : 1.5,
	'bucket_low' : 0.5,
	'class' : 'SizeTieredCompactionStrategy',
	'enabled' : true,
	'max_threshold' : 32,
	'min_sstable_size' : 50,
	'min_threshold' : 4,
	'tombstone_compaction_interval' : 86400,
	'tombstone_threshold' : 0.2,
	'unchecked_tombstone_compaction' : false
};

CREATE TABLE keyspace1.image_audit (
	name text,
	destination text,
	migration_status text,
	month text,
	path text,
	year text,
	PRIMARY KEY (name)
) WITH bloom_filter_fp_chance = 0.01
AND comment = ''
AND crc_check_chance = 1.0
AND dclocal_read_repair_chance = 0.1
AND default_time_to_live = 0
AND gc_grace_seconds = 864000
AND max_index_interval = 2048
AND memtable_flush_period_in_ms = 0
AND min_index_interval = 128
AND read_repair_chance = 0.0
AND speculative_retry = '99.0PERCENTILE'
AND caching = {
	'keys' : 'ALL',
	'rows_per_partition' : 'NONE'
}
AND compression = {
	'chunk_length_in_kb' : 64,
	'class' : 'LZ4Compressor',
	'enabled' : true
}
AND compaction = {
	'class' : 'SizeTieredCompactionStrategy',
	'max_threshold' : 32,
	'min_threshold' : 4
};

