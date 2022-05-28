FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-album-service.jar
ENTRYPOINT ["java","-jar","/petty-album-service.jar"]