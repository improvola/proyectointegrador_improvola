//dockerfile act

FROM amazoncorretto:11-alpine-jdk
MAINTAINER IMP
COPY target/imp-0.0.1-SNAPSHOT.jar  imp-app.jar
ENTRYPOINT ["java","-jar","/imp-app.jar"]
