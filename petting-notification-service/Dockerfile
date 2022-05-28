FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_notification_service.jar
ENTRYPOINT ["java","-jar","/petting-notification_service.jar"]