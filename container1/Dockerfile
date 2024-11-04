# Use an official OpenJDK runtime as a base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR files into the container
COPY demo-docker-backend/target/demo-docker-backend-0.0.1.jar demo-docker-backend.jar
COPY demo-docker-frontend/target/demo-docker-frontend-0.0.1.jar demo-docker-frontend.jar

# Define the entry point and default command
# ENTRYPOINT ["java", "-jar"]
# CMD ["demo-docker-backend.jar", "&", "demo-docker-frontend.jar"]
CMD ["sh", "-c", "java -jar demo-docker-backend.jar & java -jar demo-docker-frontend.jar"]

# Documentation Puspose ONLY. It does not map or publish ports on the host.
# Expose the ports that the applications will run on
EXPOSE 8190 8090
EXPOSE 8191 8091