FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ad-service.jar
ENTRYPOINT ["java","-jar","/ad-service.jar"]
EXPOSE 9092
