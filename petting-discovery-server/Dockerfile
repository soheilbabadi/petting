FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_discovery-server.jar
ENTRYPOINT ["java","-jar","/petting-discovery-server.jar"]