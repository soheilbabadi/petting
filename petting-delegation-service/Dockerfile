FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-deligation-service.jar
ENTRYPOINT ["java","-jar","/petty-deligation-service.jar"]