#Installing base Image of JDK
FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

LABEL Maintainer="MOHAMMED USAMA"

ADD target/catalogue-service-0.0.1-SNAPSHOT.jar catalogue-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "catalogue-service-0.0.1-SNAPSHOT.jar" ]
