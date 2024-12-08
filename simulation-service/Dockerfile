FROM openjdk:17
ARG JAR_FILE=target/simulation-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /simulation-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/simulation-service-0.0.1-SNAPSHOT.jar"]