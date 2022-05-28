FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-events-service.jar
ENTRYPOINT ["java","-jar","/petty-events-service.jar"]