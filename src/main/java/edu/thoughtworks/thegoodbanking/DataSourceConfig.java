package edu.thoughtworks.thegoodbanking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Bean
    DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url(dataSourceUrl)
                .build();
    }
}
