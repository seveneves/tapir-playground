package demo.api

import sttp.model.StatusCode
import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.circe

object MovieEndpoints {
  val Get: PublicEndpoint[Title, (StatusCode, ErrorInfo), Movie, Any] =
    endpoint.get
      .in("api" / "movies" / path[Title]("title"))
      .out(circe.jsonBody[Movie])
      .errorOut(statusCode.and(circe.jsonBody[ErrorInfo]))

  val Create: PublicEndpoint[Movie, (StatusCode, ErrorInfo), Unit, Any] =
    endpoint.put
      .in("api" / "movies")
      .in(circe.jsonBody[Movie])
      .errorOut(statusCode.and(circe.jsonBody[ErrorInfo]))
}
