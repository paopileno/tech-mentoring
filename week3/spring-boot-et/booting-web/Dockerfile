FROM maven:3.6.3-openjdk-11-slim
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package
COPY target/booting-web-*.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=0 /build/target/application.jar /app/
CMD java -jar /app/application.jar