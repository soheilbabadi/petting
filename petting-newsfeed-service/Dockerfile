FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-newsfeed-service.jar
ENTRYPOINT ["java","-jar","/petty-newsfeed-service.jar"]