package org.example.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:app.properties")
public class AppConfig {
   @Autowired
   Environment env;
   @Bean
   DataSource dataSource(){
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setUrl(env.getProperty("dbUrl"));
       dataSource.setUsername(env.getProperty("dbUser"));
       dataSource.setPassword(env.getProperty("dbPass"));
       dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("dbDriver")));
       return dataSource;
   }
}
