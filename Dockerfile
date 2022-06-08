FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/prueba-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
