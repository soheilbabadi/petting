FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-abuse-service.jar
ENTRYPOINT ["java","-jar","/petty-abuse-service.jar"]