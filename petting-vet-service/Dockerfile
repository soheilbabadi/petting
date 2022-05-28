FROM openjdk-17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petting_vet_service.jar
ENTRYPOINT ["java","-jar","/petting-vet_service.jar"]