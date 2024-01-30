FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/climaxProject-1.0-SNAPSHOT-shaded.jar /app/climax.jar

EXPOSE 8083

CMD ["java", "-jar", "/app/climax.jar"]

