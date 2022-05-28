FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_abuse_service.jar
ENTRYPOINT ["java","-jar","/petting-abuse_service.jar"]