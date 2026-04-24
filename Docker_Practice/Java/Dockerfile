# Use Eclipse Temurin as the base image instead of the deprecated openjdk 
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container [cite: 1, 4]
WORKDIR /app

# Copy your Sample.java source file into the container [cite: 1]
COPY Sample.java /app/

# Compile the Java program inside the container [cite: 1]
RUN javac Sample.java

# Execute the program when the container starts [cite: 1]
ENTRYPOINT ["java", "Sample"]
