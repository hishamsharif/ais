FROM openjdk:8-jdk-alpine
RUN addgroup -S andela && adduser -S andela -G andela
USER andela:andela
ARG JAR_FILE=target/automatic-irrigation-system.jar
COPY ${JAR_FILE} automatic-irrigation-system.jar
ENTRYPOINT ["java","-jar","/automatic-irrigation-system.jar"]