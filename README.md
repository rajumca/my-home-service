# my-com.rajuboddupalli.home-service

Kafka and casandra
Startup:
1.  bin/windows/zookeeper-server-start.bat config/zookeeper.properties
2.  bin/windows/kafka-server-start.bat config/server.properties

 1  bin/cassandra -f
 2  bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092
 3  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.MUSIC.EXTRACT
 4  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.STORE
 5  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.FILE.COPY
 6  bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.TOPIC.IMAGE.EXTRACT
 7  bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092


1.bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.MUSIC.EXTRACT
2. bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MYHOME.MUSIC.EXTRACT
4. bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic <topic_name>
5. bin/windows/kafka-topics.bat --list --bootstrap-server localhost:9092


