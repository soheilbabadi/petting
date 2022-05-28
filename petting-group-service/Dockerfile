FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-group-service.jar
ENTRYPOINT ["java","-jar","/petty-group-service.jar"]