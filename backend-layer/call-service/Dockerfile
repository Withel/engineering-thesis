FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=jars/call-service-v1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]