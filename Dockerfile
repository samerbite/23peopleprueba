FROM openjdk:8-jdk-alpine
VOLUME /tmp
LABEL maintainer="Francisco Venegas frvenegasrojas@gmail.com"
EXPOSE 8080
WORKDIR /
ARG JAR_FILE=/build/libs/cl-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} titicoctel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cl-0.0.1-SNAPSHOT.jar"]