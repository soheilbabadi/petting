FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_channel_service.jar
ENTRYPOINT ["java","-jar","/petting-channel_service.jar"]