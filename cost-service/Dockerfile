FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cost-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cost-service-0.0.1-SNAPSHOT.jar"]