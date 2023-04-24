FROM openjdk:20
EXPOSE 8080
ADD target/statify-back.jar statify-back.jar
ENTRYPOINT ["java", "-jar", "/statify-back.jar"]