FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-ticket-service.jar
ENTRYPOINT ["java","-jar","/petty-ticket-service.jar"]