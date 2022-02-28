package demo.test

import demo.api.ErrorInfo
import demo.api.Movie
import demo.api.Title
import io.circe.parser._
import io.circe.syntax._
import sttp.client3._
import sttp.model.StatusCode

object PlainMovieApi {
  private val backend = sttp.client3.HttpURLConnectionBackend()

  val Get: Title => Either[(StatusCode, ErrorInfo), Movie] = { title =>
    val request = basicRequest
      .get(uri"http://localhost:8080/api/movies/".addPath(title.value))
    backend
      .send(request)
      .body
      .flatMap(parse)
      .flatMap(_.as[Movie])
      .left
      .map(e => StatusCode.InternalServerError -> ErrorInfo(e.toString))
  }

  val Create: Movie => Either[(StatusCode, ErrorInfo), Unit] = { movie =>
    val request = basicRequest
      .put(uri"http://localhost:8080/api/movies")
      .body(movie.asJson.toString())
    backend
      .send(request)
      .body
      .map(_ => ())
      .left
      .map(f => StatusCode.InternalServerError -> ErrorInfo(f))

  }
}
