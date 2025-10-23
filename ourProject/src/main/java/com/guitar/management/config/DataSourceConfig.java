package com.guitar.management.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(Environment env) {
        String url = env.getProperty("DB_URL", env.getProperty("SPRING_DATASOURCE_URL", "jdbc:mysql://localhost:3306/guitardb?serverTimezone=UTC"));
        String user = env.getProperty("DB_USER", env.getProperty("SPRING_DATASOURCE_USERNAME", "root"));
        String password = env.getProperty("DB_PASSWORD", env.getProperty("SPRING_DATASOURCE_PASSWORD", ""));

        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl(url);
        cfg.setUsername(user);
        cfg.setPassword(password);
        cfg.setMinimumIdle(1);
        cfg.setMaximumPoolSize(10);
        cfg.setPoolName("app-hikari-pool");
        // Recommended defaults
        cfg.addDataSourceProperty("cachePrepStmts", "true");
        cfg.addDataSourceProperty("prepStmtCacheSize", "250");
        cfg.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(cfg);
    }
}
