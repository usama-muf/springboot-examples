#Installing base Image of JDK
FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

LABEL Maintainer="MOHAMMED USAMA"

ADD target/service-1-0.0.1-SNAPSHOT.jar service-1-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "service-1-0.0.1-SNAPSHOT.jar" ]
