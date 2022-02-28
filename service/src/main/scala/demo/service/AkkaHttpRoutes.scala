package demo.service

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import demo.api.MovieEndpoints
import sttp.tapir.openapi.Info
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

import scala.concurrent.Future

object AkkaHttpRoutes {

  private val SwaggerEndpoints: List[ServerEndpoint[Any, Future]] =
    SwaggerInterpreter(pathPrefix = List("docs"))
      .fromEndpoints[Future](
        List(MovieEndpoints.Get, MovieEndpoints.Create),
        Info(
          "My Movie App",
          "1.0.0",
          description = Option("APIs for accessing movies")
        )
      )

  private val GetRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Get.serverLogic(MoviesService.getMovie)
  )
  private val CreateRoute = AkkaHttpServerInterpreter().toRoute(
    MovieEndpoints.Create
      .serverSecurityLogic(AuthenticationService.checkSecurity)
      .serverLogic(authCtx => movie => MoviesService.createMovie(movie))
  )

  private val SwaggerRoute =
    AkkaHttpServerInterpreter().toRoute(SwaggerEndpoints)

  val All: Route = GetRoute ~ CreateRoute ~ SwaggerRoute

}
