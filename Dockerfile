FROM openjdk:17
ADD target/tweet-app.jar tweet-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tweet-app.jar"]