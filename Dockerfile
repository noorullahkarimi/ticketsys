# Use the official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/your-application.jar app.jar

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
