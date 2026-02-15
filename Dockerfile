#Use official Java 17 image
FROM eclipse-temurin:17-jdk-alpine

#set working directory
WORKDIR /app

#copy jar file from target folder
COPY target/*.jar app.jar

#expose application port
EXPOSE 8080

#Run the jar
ENTRYPOINT ["java","-jar","app.jar"]