package pl.wb.demo.security.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/wojtek?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("wojtek");
        dataSourceBuilder.password("op9p6a!@dWeZu");
        return dataSourceBuilder.build();

        // or   #spring.datasource.driver=com.mysql.cj.jdbc.Driver
        //      #spring.datasource.url=jdbc:mysql://...
        //      #spring.datasource.username=...
        //      #spring.datasource.password=...
        // in application properties

        //from https://www.baeldung.com/spring-boot-configure-data-source-programmatic:
        // "Externalizing DataSource Configuration with the application.properties file"  - not working as describe;
        // check comment section (@Primary might be the answer? https://stackoverflow.com/questions/28821521/configure-datasource-programmatically-in-spring-boot
    }
}