FROM amazoncorretto:17.0.1 as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY manifests manifests

RUN ./mvnw package -DskipTests

FROM amazoncorretto:17.0.1

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
