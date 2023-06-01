#Installing base Image of JDK
FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

LABEL Maintainer="MOHAMMED USAMA"

EXPOSE 8761

ADD target/service-discovery-0.0.1-SNAPSHOT.jar service-discovery-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "service-discovery-0.0.1-SNAPSHOT.jar" ]
