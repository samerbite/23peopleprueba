FROM openjdk:8-jdk-alpine
# Add a volume pointing to /tmp
VOLUME /tmp
# Add Maintainer Info
LABEL maintainer="Francisco Venegas frvenegasrojas@gmail.com"
#Add Port
EXPOSE 8080
# Add the application's jar to the container
ADD build/libs/cl-0.0.1-SNAPSHOT.jar /app/cl-0.0.1-SNAPSHOT.jar
# Run the jar file
WORKDIR /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api23people.jar"]