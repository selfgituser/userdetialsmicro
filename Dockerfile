
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} userDetailservice.jar
ENTRYPOINT ["java", "-jar", "/userDetailservice.jar"]
