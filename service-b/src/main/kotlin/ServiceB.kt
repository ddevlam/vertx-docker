import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class ServiceB : AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        println("Starting the service-b")

        vertx.eventBus().consumer<Any>("nl.seiferd.service-b", { message ->
            println("I have received a message on service-b: ${message.body()}")
        })

        super.start(startFuture)
    }
}