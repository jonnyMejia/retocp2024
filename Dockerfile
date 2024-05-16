FROM amazoncorretto:17-alpine-jdk

COPY target/retocp24-0.0.3.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]