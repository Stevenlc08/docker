# Use an official OpenJDK runtime as a base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR files into the container
COPY demo-docker-external/target/demo-docker-external-0.0.1.jar demo-docker-external.jar

# Documentation Puspose ONLY. It does not map or publish ports on the host.
# Expose the ports that the applications will run on
ENTRYPOINT ["java", "-jar"]
CMD ["demo-docker-external.jar"]

# Expose the ports that the applications will run on
EXPOSE 8192 8090