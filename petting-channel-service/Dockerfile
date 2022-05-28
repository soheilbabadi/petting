FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-channel-service.jar
ENTRYPOINT ["java","-jar","/petty-channel-service.jar"]