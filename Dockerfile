FROM maven:3.8.4-jdk-11  as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:11
WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar
EXPOSE 8080

ENTRYPOINT java -jar app.jar