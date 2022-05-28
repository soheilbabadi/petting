FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_wall_service.jar
ENTRYPOINT ["java","-jar","/petting-wall_service.jar"]