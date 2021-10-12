FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/adservice-app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
