FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-person-service.jar
ENTRYPOINT ["java","-jar","/petty-person-service.jar"]