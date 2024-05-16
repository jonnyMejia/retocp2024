# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/retocp24-0.0.2.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080
EXPOSE 3306

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]