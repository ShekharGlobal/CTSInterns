# Use Eclipse Temurin as the base image (replaces the deprecated openjdk:17)
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app [cite: 4]

# Copy the Java source file to the container
COPY Sample.java /app/ 

# Compile the Java program
RUN javac Sample.java 

# Run the Java program when the container starts
ENTRYPOINT ["java", "Sample"]
