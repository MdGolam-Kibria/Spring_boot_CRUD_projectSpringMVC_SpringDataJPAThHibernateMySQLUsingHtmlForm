# Spring_boot_CRUD_projectSpringMVC_SpringDataJPAThHibernateMySQLUsingHtmlForm
This is Spring_boot_CRUD_project Spring MVC, Spring Data JPA, ThymeLeaf, Hibernate, MySQL   using html form



### Mysql Database :-

<img src="https://user-images.githubusercontent.com/61331272/79671958-c7f35000-81ef-11ea-88f0-1495e3768e67.png" width="500" height="300" />

### MySql Database code:-

- if you want to make your database manually use the below code :-

`CREATE TABLE `product` (  `id` int(11) NOT NULL AUTO_INCREMENT,  `name` varchar(45) NOT NULL,  `brand` varchar(45) NOT NULL,  `madein` varchar(45) NOT NULL,  `price` float NOT NULL,  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;`

### **Dependencies  Pom.xml**

- From@https://start.spring.io/



`<dependencies>
		<dependency>
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
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>`
