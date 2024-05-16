# Usar una imagen base de OpenJDK
FROM maven:3.9.5-openjdk-17 as maven_builder

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY /target/retocp24-0.0.3.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080
EXPOSE 3306

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]