FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-payment-service.jar
ENTRYPOINT ["java","-jar","/petty-payment-service.jar"]