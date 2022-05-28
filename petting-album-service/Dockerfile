FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_album_service.jar
ENTRYPOINT ["java","-jar","/petting-album_service.jar"]