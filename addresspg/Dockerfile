FROM openjdk:20

ARG jarfile=target/*.jar

COPY ${jarfile} address.jar

EXPOSE 9080

ENTRYPOINT  ["java","-jar","address.jar"]

