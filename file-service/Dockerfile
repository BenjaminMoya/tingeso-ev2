FROM openjdk:17
ARG JAR_FILE=target/file-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /file-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/file-service-0.0.1-SNAPSHOT.jar"]