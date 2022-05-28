FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-config-server.jar
ENTRYPOINT ["java","-jar","/petty-config-server.jar"]