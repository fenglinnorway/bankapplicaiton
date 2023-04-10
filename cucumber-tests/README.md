### Features

Cucumber Testing: The project uses Cucumber, a Behavior-Driven Development (BDD) testing framework, to define tests in a natural language format that is easy to understand for non-technical stakeholders. The project includes dependencies like cucumber-core, cucumber-java, cucumber-junit, and cucumber-spring.

Integration with Spring Boot: The project is configured to work with the Spring Boot framework by including the spring-boot-starter-test and cucumber-spring dependencies, which provide support for integration and unit testing of Spring Boot applications.

Testing Dependencies: The project relies on a variety of testing libraries, such as JUnit 4, Hamcrest, Reactor Test, and Rest-Assured. JUnit 4 is used as the primary testing framework, while Hamcrest offers matchers for writing more expressive assertions. Reactor Test is included for testing reactive applications, and Rest-Assured enables easy testing of RESTful APIs.

JSON Path: The project uses the JSON Path library to enable querying and manipulating JSON data in the tests.

Maven Surefire Plugin: The project employs the Maven Surefire Plugin to execute unit tests, excluding integration tests from the test run. It also sets the spring.profiles.active system property to test.

Maven Failsafe Plugin: The project utilizes the Maven Failsafe Plugin to run integration tests, specifically those with the *IntegrationTest.java naming pattern. The spring.profiles.active system property is set to integration, and the cucumber.options system property is configured to use the appropriate glue path for the Cucumber tests.

Spring Boot Maven Plugin: The project includes the Spring Boot Maven Plugin, which provides functionality for packaging, running, and creating an executable JAR for the Spring Boot application.