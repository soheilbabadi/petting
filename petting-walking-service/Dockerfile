FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_walking_service.jar
ENTRYPOINT ["java","-jar","/petting-walking_service.jar"]