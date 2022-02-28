package demo.service

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import demo.api.MovieEndpoints
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

import scala.concurrent.Future

object AkkaHttpRoutes {

  private val SwaggerEndpoints = SwaggerInterpreter().fromEndpoints[Future](
    List(MovieEndpoints.Get, MovieEndpoints.Create),
    "My Movie App",
    "1.0"
  )

  private val GetRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Get.serverLogic(MoviesService.getMovie)
  )
  private val CreateRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Create.serverLogic(MoviesService.createMovie)
  )
  private val SwaggerRoute =
    AkkaHttpServerInterpreter().toRoute(SwaggerEndpoints)

  val All: Route = GetRoute ~ CreateRoute ~ SwaggerRoute

}
