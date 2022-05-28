FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_shop_service.jar
ENTRYPOINT ["java","-jar","/petting-shop_service.jar"]