FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-album.jar
ENTRYPOINT ["java","-jar","/petty-channel.jar"]