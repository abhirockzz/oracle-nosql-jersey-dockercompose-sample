FROM oracle/openjdk:latest
 
RUN mkdir app

WORKDIR "/app"

ADD target/jersey-oracle-nosql-jar-with-dependencies.jar .

EXPOSE 8080

CMD ["java", "-jar", "jersey-oracle-nosql-jar-with-dependencies.jar"]