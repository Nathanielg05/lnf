# --- STAGE 1: Build the Java application and bundle the frontend ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Optional: Copy your frontend 'public' folder into Spring Boot's static resources 
# so your Java server can serve your website AND handle backend APIs together!
COPY public ./src/main/resources/static

# Build the executable jar file (Docker downloads Maven automatically)
RUN mvn clean package -DskipTests

# --- STAGE 2: Run the application ---
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar file from Stage 1
COPY --from=build /app/target/*.jar app.jar

# Expose the port Spring Boot runs on (Default is 8080)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]