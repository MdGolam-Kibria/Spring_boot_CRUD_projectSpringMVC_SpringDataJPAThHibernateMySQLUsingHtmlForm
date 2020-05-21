package com.example.controlProducts.productManager.AlternativeApplicationProperties;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration //congigaration annotation na use korle amra kono bean declare korte parbo na
public class DataSourceConfig  {
    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/salesdb")
                .username("root")
                .password("413152413152")
                .build();
    }
}
