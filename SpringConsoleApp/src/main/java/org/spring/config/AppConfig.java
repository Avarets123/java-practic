package org.spring.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.spring")
public class AppConfig {

  @Autowired
  private Environment environment;


  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }


  @Bean
  public DataSource dataSource() {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setUsername(environment.getProperty("db.username"));
    hikariDataSource.setPassword(environment.getProperty("db.password"));
    hikariDataSource.setJdbcUrl(environment.getProperty("db.url"));
    hikariDataSource.setMaximumPoolSize(environment.getProperty("db.hikari.maxPoolSize", Integer.class));
    return hikariDataSource;
  }

}
