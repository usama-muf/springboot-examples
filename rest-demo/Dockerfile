#Installing base Image of JDK
FROM eclipse-temurin:17-alpine

WORKDIR /app

COPY . /app

LABEL Maintainer="MOHAMMED USAMA"

ADD target/rest-demo-0.0.1-SNAPSHOT.jar rest-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "rest-demo-0.0.1-SNAPSHOT.jar" ]
