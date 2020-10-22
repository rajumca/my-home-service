package com.rajuboddupalli.home.music.store.config;

import com.rajuboddupalli.home.common.domain.StorageType;
import com.rajuboddupalli.home.music.store.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@PropertySource("application.properties")
@Configuration
@EnableCassandraRepositories(basePackages = "com.rajuboddupalli.home.music.store.repository")
public class CassndraConfig extends AbstractCassandraConfiguration {
    @Autowired
    private Environment env;
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
        return new String[]{"com.rajuboddupalli.home.domain.entity"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

}
