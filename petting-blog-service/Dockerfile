FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petty-blog-service.jar
ENTRYPOINT ["java","-jar","/petty-blog-service.jar"]