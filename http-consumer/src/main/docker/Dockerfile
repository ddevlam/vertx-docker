FROM vertx/vertx3

ENV VERTICLE_HOME /usr/verticles
ENV VERTICLE_NAME HttpServer

EXPOSE 8080

COPY ./verticles $VERTICLE_HOME/

WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/* -cluster"]