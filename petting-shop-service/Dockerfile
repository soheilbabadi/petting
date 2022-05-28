FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-shop-service.jar
ENTRYPOINT ["java","-jar","/petty-shop-service.jar"]