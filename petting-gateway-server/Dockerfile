FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-gateway-server.jar
ENTRYPOINT ["java","-jar","/petty-gateway-server.jar"]