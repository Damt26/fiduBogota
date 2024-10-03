package com.danielmercadotapias.fiduciariabogotaback.configuration.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url(url)
                .password(password)
                .username(username)
                .driverClassName("org.postgresql.Driver")
                .type(com.zaxxer.hikari.HikariDataSource.class)
                .build();
    }


    @Bean
    public Flyway flyway(DataSource dataSource) {

        Flyway configuration = Flyway
                .configure()
                .dataSource(dataSource)
                .defaultSchema("bank")
                .locations("/db/migration")
                .createSchemas(true)
                .load();

        configuration.migrate();

        return configuration;
    }
}
