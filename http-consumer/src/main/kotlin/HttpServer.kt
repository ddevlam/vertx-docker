import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class HttpServer : AbstractVerticle() {

    override fun start(startFuture: Future<Void>?) {

        val server = vertx.createHttpServer()

        server.requestHandler({ request ->
            println("Server is now publishing to service a and b")

            vertx.eventBus().publish("nl.seiferd.service-a", "Calling service a")
            vertx.eventBus().publish("nl.seiferd.service-b", "Calling service b")

            request.response().end("Done with request")
        })

        server.listen(8080, { res ->
            if (res.succeeded()) {
                println("Server is now listening!")
            } else {
                println("Failed to bind!")
            }
        })

        super.start(startFuture)
    }

}