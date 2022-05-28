FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-chat-service.jar
ENTRYPOINT ["java","-jar","/petty-chat-service.jar"]