# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /ShortNestApp

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

WORKDIR /ShortNestApp

# Copy the built jar from the previous stage
COPY --from=build /ShortNestApp/target/URLShortner-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "URLShortner-0.0.1-SNAPSHOT.jar"]
