package demo.service

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import demo.api.MovieEndpoints
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter

object AkkaHttpRoutes {

  private val getRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Get.serverLogic(MoviesService.getMovie)
  )
  private val createRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Create.serverLogic(MoviesService.createMovie)
  )

  val All: Route = createRoute ~ getRoute

}
