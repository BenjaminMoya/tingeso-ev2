FROM openjdk:17
ARG JAR_FILE=target/tracking-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /tracking-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/tracking-service-0.0.1-SNAPSHOT.jar"]