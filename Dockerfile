FROM openjdk:23-ea-jdk-slim

WORKDIR /wishify

COPY target/*.jar wishify.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "wishify.jar"]
