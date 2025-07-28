# ----------- Build Stage -----------
FROM maven:3.9.6-eclipse-temurin-8 AS builder

WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests -pl -web-ui

# ----------- Runtime Stage -----------
FROM eclipse-temurin:8-jre

WORKDIR /app

# Copy built JAR file from builder stage
COPY --from=builder /app/dossier/dossier-app/target/*.jar app.jar

# Expose port your app runs on (usually 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
