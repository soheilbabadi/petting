FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-admin-server.jar
ENTRYPOINT ["java","-jar","/petty-admin-server.jar"]