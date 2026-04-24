# Use OpenJDK as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Java source file to the container
COPY Sample.java /app/

# Compile the Java program
RUN javac Sample.java

# Run the Java program when the container starts
ENTRYPOINT ["java", "Sample"]
