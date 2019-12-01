# my-com.rajuboddupalli.home-service

Kafka and casandra
Startup:
1.  bin/windows/zookeeper-server-start.bat config/zookeeper.properties
2.  bin/windows/kafka-server-start.bat config/server.properties
3.  bin/cassandra -f
4. Run CQL scripts: file://cql-script.cql

 2  bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092
 3  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.MUSIC.EXTRACT
 4  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.CASSANDRA.STORE
 5  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.FILE.COPY
 6  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.IMAGE.EXTRACT
 7  bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092


1.bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.MUSIC.EXTRACT
2. bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.MUSIC.EXTRACT
4. bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic <topic_name>
5. bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092

DELETE topics
 bin/windows/kafka-topics.bat --zookeeper localhost:9002 --delete --topic '*'

--Purge
$ bin/windows/kafka-topics.bat --zookeeper localhost:2181 --alter --topic MYHOME.TOPIC.MUSIC.EXTRACT --config retention.ms=1000
$ bin/windows/kafka-topics.bat --zookeeper localhost:2181 --alter --topic MYHOME.TOPIC.CASSANDRA.STORE --config retention.ms=1000
$ bin/windows/kafka-topics.bat --zookeeper localhost:2181 --alter --topic MYHOME.TOPIC.FILE.COPY --config retention.ms=1000
$ bin/windows/kafka-topics.bat --zookeeper localhost:2181 --alter --topic MYHOME.IMAGE.EXTRACT --config retention.ms=1000


--Publish
 bin/windows/kafka-console-producer.bat --broker-list localhost:9092 --topic MYHOME.TOPIC.CASSANDRA.STORE