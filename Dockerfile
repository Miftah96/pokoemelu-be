# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Add app.jar (name can be changed by Maven build)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
