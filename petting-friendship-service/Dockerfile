FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-freindship-service.jar
ENTRYPOINT ["java","-jar","/petty-freindship-service.jar"]