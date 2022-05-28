FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_admin-server.jar
ENTRYPOINT ["java","-jar","/petting-admin-server.jar"]