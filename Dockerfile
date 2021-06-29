FROM adoptopenjdk/openjdk15:jdk-15.0.2_7-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=releases/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]