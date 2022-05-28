FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_config-server.jar
ENTRYPOINT ["java","-jar","/petting-config-server.jar"]