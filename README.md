# Spring_boot_CRUD_projectSpringMVC_SpringDataJPAThHibernateMySQLUsingHtmlForm
This is Spring_boot_CRUD_project Spring MVC, Spring Data JPA, ThymeLeaf, Hibernate, MySQL   using html form


#Features : = 

For Products:

1.save
2.update
3.delete

### Mysql Database :-

<img src="https://user-images.githubusercontent.com/61331272/79671958-c7f35000-81ef-11ea-88f0-1495e3768e67.png" width="500" height="300" />

### MySql Database code:-

- if you want to make your database manually use the below code :-

`CREATE TABLE `product` (  `id` int(11) NOT NULL AUTO_INCREMENT,  `name` varchar(45) NOT NULL,  `brand` varchar(45) NOT NULL,  `madein` varchar(45) NOT NULL,  `price` float NOT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;`

### **Dependencies  Pom.xml**

- From@https://start.spring.io/



		`<dependency>
		    <groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>`
		
		
### Applications.properties := 
		
`server.port=8085
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto = none
spring.jpa.show-sql = true
spring.datasource.url =jdbc:mysql://localhost:3306/salesdb
spring.datasource.username = root
spring.datasource.password=413152413152
logging.level.root=WARN`

### Applications.properties  Alternative way Programmatically := 

- step 1 :  im main method : = 

`@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`

 - step 2 : make a class and paste the below code:
 
 
 
`@Configuration
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
}`
