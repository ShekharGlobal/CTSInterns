# Step 1: Use a lightweight JRE image for Java 17
FROM eclipse-temurin:17-jre-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR from your target folder to the container
# Based on your image, the path is target/Springrest-0.0.1-SNAPSHOT.jar
COPY target/Springrest-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port Spring Boot runs on
EXPOSE 8090

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]