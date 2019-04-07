package com.rajuboddupalli.home.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.rajuboddupalli.home.music.repository")
public class CassndraConfig extends AbstractCassandraConfiguration {
    @Override
    protected String getKeyspaceName() {
        return "keyspace1";
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints("127.0.0.1");
        cluster.setPort(9042);
        cluster.setJmxReportingEnabled(false);
        return cluster;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.rajuboddupalli.home.music.entity"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

}
