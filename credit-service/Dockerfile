FROM openjdk:17
ARG JAR_FILE=target/credit-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /credit-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/credit-service-0.0.1-SNAPSHOT.jar"]