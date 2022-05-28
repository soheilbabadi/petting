FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_freindship_service.jar
ENTRYPOINT ["java","-jar","/petting-freindship_service.jar"]