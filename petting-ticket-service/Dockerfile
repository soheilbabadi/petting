FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_ticket_service.jar
ENTRYPOINT ["java","-jar","/petting-ticket_service.jar"]