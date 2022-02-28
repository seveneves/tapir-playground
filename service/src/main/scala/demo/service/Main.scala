package demo.service

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import org.slf4j.LoggerFactory

import scala.util.Failure
import scala.util.Success

object Main {
  private val logger = LoggerFactory.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    implicit val actorSystem: ActorSystem = ActorSystem()
    import actorSystem.dispatcher
    val http = Http()
    http
      .newServerAt("localhost", 8080)
      .bind(AkkaHttpRoutes.All)
      .onComplete {
        case Success(value) =>
          logger.info(s"Started: $value")
        case Failure(ex) =>
          logger.error(s"Failed to start", ex)
      }
  }
}
