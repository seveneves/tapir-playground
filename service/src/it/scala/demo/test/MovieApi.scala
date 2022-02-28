package demo.test

import demo.api.ErrorInfo
import demo.api.ApiKey
import demo.api.Movie
import demo.api.MovieEndpoints
import demo.api.Title
import sttp.client3._
import sttp.model.StatusCode
import sttp.tapir.client.sttp.SttpClientInterpreter

object MovieApi {
  val Get: Title => Either[(StatusCode, ErrorInfo), Movie] =
    SttpClientInterpreter().toQuickClient(
      MovieEndpoints.Get,
      Option(uri"http://localhost:8080")
    )

  val Create: ApiKey => Movie => Either[(StatusCode, ErrorInfo), Unit] =
    SttpClientInterpreter().toQuickSecureClient(
      MovieEndpoints.Create,
      Option(uri"http://localhost:8080")
    )
}
