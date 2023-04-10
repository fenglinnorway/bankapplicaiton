# Bank transition test with spring boot, jpa repository and h2 in-memory db


## Prerequisites
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)
- [Jacoco](https://www.eclemma.org/jacoco/)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Maven
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


- Swagger can be launched in Browser: http://localhost:9010/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config


- H2 Console On Browser: http://localhost:9010/h2-console


- Code Coverage: After building the projects you can find code coverage in the target path :- /target/site/jacoco/index.html


<br/>


###  Build and Run application

> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command



### Techniques used

Spring Boot: The application uses Spring Boot as its foundation, a framework that simplifies the development and deployment of Java-based applications.

Web Application: The application is a web application, as it includes the "spring-boot-starter-web" dependency, which provides support for building web applications using Spring MVC.

Aspect-Oriented Programming (AOP): The application uses AOP techniques, as it includes the "spring-boot-starter-aop" dependency. AOP is a programming paradigm that enables the modularization of cross-cutting concerns, such as logging and security.

Data Persistence: The application employs the Java Persistence API (JPA) to manage data persistence, using the "spring-boot-starter-data-jpa" dependency. JPA is a standard for mapping Java objects to relational database tables.

In-Memory Database: The application uses an H2 in-memory database for data storage, as indicated by the "h2" dependency.

Lombok: The application uses Project Lombok, a library that simplifies Java code by generating boilerplate code like getters, setters, and constructors through annotations.

File I/O: The application utilizes the Apache Commons IO library to handle file I/O operations.

API Documentation: The application uses Springdoc OpenAPI UI to generate and display API documentation.

Reactive Programming: The application includes support for reactive programming using Spring WebFlux, with the "spring-boot-starter-webflux" dependency. Reactive programming enables the development of non-blocking, asynchronous, and event-driven applications.

Testing: The application uses various testing libraries, such as Spring Boot Starter Test, JUnit 5 (Jupiter), JUnit Vintage Engine, Hamcrest, and Reactor Test, for unit and integration testing.

REST API Testing: The application uses Rest-Assured for testing RESTful APIs.

Code Coverage: The application uses JaCoCo, a code coverage library, to ensure a minimum level of code coverage in the project.

Maven Failsafe Plugin: The application uses the Maven Failsafe Plugin for executing integration tests and verifying the results.

#### Properties file
    Reading H2 DB related properties from **application.properties** file and configuring JPA connection factory for H2 database.

    **src/main/resources/application.properties**
     ```
     server.port=9010

     spring.datasource.url=jdbc:h2:mem:sampledb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=password
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

     spring.h2.console.enabled=true

     #spring.data.rest.base-path=/phone
     spring.data.rest.base-default-page-size=10
     spring.data.rest.base-max-page-size=20

     springdoc.version=1.0.0
     springdoc.swagger-ui.path=/swagger-ui-custom.html
     ```

Swagger can be launched in Browser: http://localhost:9010/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

H2 Console On Browser: http://localhost:9010/h2-console
#### Jacoco Configuration
    Jacoco plugin is used for getting Code coverage Report, Offcial Documentation [Jacoco](https://www.eclemma.org/jacoco/)

    **pom.xml**
     ```
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.5</version>
                <configuration>
                    <rules>
                        <rule implementation="org.jacoco.maven.RuleConfiguration">
                            <element>BUNDLE</element>
                            <limits>
                                <limit implementation="org.jacoco.report.check.Limit">
                                    <counter>INSTRUCTION</counter>
                                    <value>COVEREDRATION</value>
                                    <minimun>0.80</minimun>

                                </limit>
                            </limits>
                        </rule>
                    </rules>
                </configuration>
                <executions>
                    <execution>
                        <id>default-prepare-agent</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>default-report</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
     ```

