#Installing base Image of JDK
#FROM eclipse-temurin:11-alpine

#Installing image of maven latest
#FROM maven:3-eclipse-temurin-11-alpine
FROM maven:3-eclipse-temurin-17-alpine

RUN mvn -v
RUN java --version


WORKDIR /app

COPY . /app

#RUN ./mvnw package -DskipTests

RUN echo 'Print ng PWD and listing all files in current Directory'
RUN pwd
RUN ls

#RUN pwd

#RUN mvn clean 
#RUN mvn install 
RUN mvn clean package
EXPOSE 8081
LABEL Maintainer="MOHAMMED USAMA"

ADD target/docker-demo-0.0.1-SNAPSHOT.jar docker-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "docker-demo-0.0.1-SNAPSHOT.jar" ]

