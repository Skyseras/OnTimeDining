FROM openjdk:11

WORKDIR /ontimedining

COPY target/OnTimeDining-0.0.1-SNAPSHOT.jar ontimedining/

EXPOSE 9090

CMD ["java","-jar","ontimedining/OnTimeDining-0.0.1-SNAPSHOT.jar","--server.port=9090"]

