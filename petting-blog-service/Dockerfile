FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_blog_service.jar
ENTRYPOINT ["java","-jar","/petting-blog_service.jar"]