FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-notification-service.jar
ENTRYPOINT ["java","-jar","/petty-notification-service.jar"]