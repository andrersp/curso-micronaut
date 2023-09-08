FROM gradle:jdk17-alpine as build-image
WORKDIR /app
COPY --chown=gradle:gradle . .
# Build the application.
RUN gradle build -x test

FROM eclipse-temurin:17.0.7_7-jre-alpine
COPY --from=build-image /app/build/libs/stock-0.1-all-optimized.jar app.jar
ENTRYPOINT java -jar app.jar
