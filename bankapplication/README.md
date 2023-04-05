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





### Code Snippets
1. #### Maven Dependencies
    Need to add below dependencies to enable H2 DB related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- update -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```

   Added Reactive spring support with below dependencies in this application.
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>

    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```



2. #### Properties file
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

3. #### Jacoco Configuration
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

