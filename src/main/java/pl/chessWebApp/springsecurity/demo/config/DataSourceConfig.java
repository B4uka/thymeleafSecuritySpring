package pl.chessWebApp.springsecurity.demo.config;

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
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/spring_security_custom_user_demo?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("hbstudent");
        dataSourceBuilder.password("hbstudent");
        return dataSourceBuilder.build();

        // or #spring.datasource.driver=com.mysql.cj.jdbc.Driver
        //#spring.datasource.url=jdbc:mysql://localhost:3306/spring_security_custom_user_demo?useSSL=false&serverTimezone=UTC
        //#spring.datasource.username=hbstudent
        //#spring.datasource.password=hbstudent
        // in application properties

        //from https://www.baeldung.com/spring-boot-configure-data-source-programmatic:
        // "Externalizing DataSource Configuration with the application.properties file"  - not working as describe;
        // check comment section (@Primary might be the answer? https://stackoverflow.com/questions/28821521/configure-datasource-programmatically-in-spring-boot

    }
}