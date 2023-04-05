.PHONY: test
test:
	mvn test

.PHONY: ctest
ctest:
	mvn test -Dtest=**/*IntegrationTest

.PHONY: run
run:
	mvn spring-boot:run

.PHONY: jacoco
jacoco:
	mvn verify

