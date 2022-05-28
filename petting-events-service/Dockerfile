FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_events_service.jar
ENTRYPOINT ["java","-jar","/petting-events_service.jar"]