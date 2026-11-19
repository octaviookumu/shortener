# ---- Stage 1: Build ----
FROM maven:3.9-eclipse-temurin-21 AS build

LABEL maintainer="Octavian <octaviookumu@gmail.com>"

WORKDIR /app

COPY . .

# Compiles and packages the app into target/blog-*.jar.
# -DskipTests skips the test suite for faster builds - a failing test won't
# block a deploy this way, so don't rely on this as your safety net.
RUN mvn clean package -DskipTests

# ---- Stage 2: Run ----
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Reaches back into the "build" stage and grabs just the jar it produced,
# renaming it to app.jar. Source code, Maven cache, and the JDK itself are
# left behind - this is what keeps the final image small.
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]