# Stage 1: The "Construction Site" (Heavy)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# We skip tests to save memory and time
RUN mvn clean package -DskipTests

# Stage 2: The "Finished House" (Tiny)
FROM eclipse-temurin:21-jre
WORKDIR /app
# We only copy the final jar file, not the whole Maven mess
COPY --from=build /app/target/musics-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar", "app.jar"]
