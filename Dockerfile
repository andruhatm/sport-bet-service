FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9000
ADD build/libs/SportBetsService-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
