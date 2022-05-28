FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-wall-service.jar
ENTRYPOINT ["java","-jar","/petty-wall-service.jar"]