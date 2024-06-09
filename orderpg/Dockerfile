FROM openjdk:20

ARG jar_name=target/*.jar

ADD ${jar_name} order.jar

EXPOSE 9091

ENTRYPOINT ["java","-jar","order.jar"]
