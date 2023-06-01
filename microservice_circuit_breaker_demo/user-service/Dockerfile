#Installing base Image of JDK
FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

LABEL Maintainer="MOHAMMED USAMA"

ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "user-service-0.0.1-SNAPSHOT.jar" ]
