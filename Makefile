#!make

MVNW=./mvnw

run-dev:
	@SPRING_PROFILES_ACTIVE=dev $(MVNW) spring-boot:run

run-prod:
	@SPRING_PROFILES_ACTIVE=prod $(MVNW) spring-boot:run

.PHONY: run-dev run-prod