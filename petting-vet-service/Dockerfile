FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-vet-service.jar
ENTRYPOINT ["java","-jar","/petty-vet-service.jar"]