-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS cassandra_key_space WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };
