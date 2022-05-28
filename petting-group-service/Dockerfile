FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_group_service.jar
ENTRYPOINT ["java","-jar","/petting-group_service.jar"]