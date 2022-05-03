FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/main-2.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
