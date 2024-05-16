# Usar una imagen base de OpenJDK
FROM maven:3.8.3-openjdk-17 as maven_builder

RUN mvn clean install
RUN mv target/*.jar target/application.jar  # <-- add

FROM openjdk:17-jdk-alpine as builder
WORKDIR /app
COPY --from=maven_builder /app/target/application.jar ./
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-jdk-alpine
WORKDIR /app

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080
EXPOSE 3306

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]