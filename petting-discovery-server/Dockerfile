FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-discovery-server.jar
ENTRYPOINT ["java","-jar","/petty-discovery-server.jar"]