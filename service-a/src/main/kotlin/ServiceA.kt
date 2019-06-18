import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class ServiceA : AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        println("Starting the service-a")

        vertx.eventBus().consumer<Any>("nl.seiferd.service-a", { message ->
            println("I have received a message on service-a: ${message.body()}")
        })

        super.start(startFuture)
    }
}