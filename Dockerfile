FROM openjdk:12-oraclelinux7

RUN  mkdir /app

COPY . /app/

EXPOSE 8080

WORKDIR /app

CMD ["java", "-jar", "/app/Kafka-1.0-SNAPSHOT.jar"]
